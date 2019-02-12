package com.tracking.onlinetracking.api;

import com.tracking.onlinetracking.service.PackageService;
import com.tracking.onlinetracking.service.PackageServiceAxis2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.tempuri.Route;
import packages.wsdl.PackageDTO;
import packages.wsdl.RouteDTO;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Robi on 1/10/2019.
 */

@Controller
public class PackageManagerController {
    @Autowired
    PackageService packageService;

    @Autowired
    PackageServiceAxis2 packageServiceAxis2;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin/packagemanager")
    public ModelMap showPackages(){
        return new ModelMap().addAttribute("packages_data", packageService.getAllPackages());
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("admin/add_form")
    public ModelMap getAddForm(@RequestParam(value = "id",required = false)PackageDTO packageDTO){
        if(packageDTO == null){
            packageDTO = new PackageDTO();
        }
        return new ModelMap("package", packageDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("admin/add_form")
    public String postAddForm(@ModelAttribute @Valid PackageDTO packageDTO, BindingResult errors, SessionStatus status){
        if (errors.hasErrors()){
            return "admin/add_form";
        }
        packageService.addPackage(packageDTO);
        status.setComplete();
        return "redirect:packagemanager";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("admin/packagedetails")
    public ModelMap getDetails(@RequestParam(value = "id",required = false)String awb){
        PackageDTO packageDTO = packageService.getPackageByAwb(Integer.parseInt(awb));
        List<Route> routeList = packageServiceAxis2.getRoutesByAwb(Integer.parseInt(awb));
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setAwb(Integer.parseInt(awb));

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("package_data", packageDTO);
        modelMap.addAttribute("routes_data", routeList);
        modelMap.addAttribute("route", routeDTO);

        return modelMap;
    }

    /*
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("admin/addroute")
    public String addRoute(@RequestParam("awb") String awb, @RequestParam("city") String city){
        packageService.addRoute(Integer.parseInt(awb), city);
        return "redirect:packagemanager";
    }
    */

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("admin/addroute")
    public String postAddRoute(@ModelAttribute @Valid RouteDTO routeDTO, BindingResult errors, SessionStatus status){
        if (errors.hasErrors()){
            return "admin/packagedetails";
        }
        packageService.addRoute(routeDTO.getAwb(), routeDTO.getCity());
        status.setComplete();
        return "redirect:packagemanager";
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("admin/delete")
    public String deletePackage (@RequestParam("id") String awb){
        packageService.removePackage(Integer.parseInt(awb));
        return "redirect:packagemanager";
    }
}
