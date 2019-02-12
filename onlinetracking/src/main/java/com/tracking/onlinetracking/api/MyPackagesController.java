package com.tracking.onlinetracking.api;


import com.tracking.onlinetracking.persistance.User;
import com.tracking.onlinetracking.service.CustomUserDetailsService;
import com.tracking.onlinetracking.service.PackageServiceAxis2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.tempuri.Route;
import packages.wsdl.PackageDTO;
import packages.wsdl.RouteDTO;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Robi on 12/11/2018.
 */

@Controller
public class MyPackagesController {
    @Autowired
    PackageServiceAxis2 packageServiceAxis2;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/client/mypackages")
    public ModelMap showPackages(){
        User currentUser = CustomUserDetailsService.getCurrentUser();
        PackageDTO packageDTO = new PackageDTO();

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("packages_data", packageServiceAxis2.getPackagesByUserId(currentUser.getId()));
        modelMap.addAttribute("package_search", packageDTO);
        return modelMap;
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/client/mypackages")
    public void postPackages(){

    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/client/search")
    public ModelMap postSearchForm(@ModelAttribute @Valid PackageDTO packageDTO){
        User currentUser = CustomUserDetailsService.getCurrentUser();

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("packages_data", packageServiceAxis2.getPackagesByUserIdAwb(currentUser.getId(), packageDTO.getAwb()));
        return modelMap;
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("client/route")
    public ModelMap getRoute(@RequestParam(value = "id",required = false)String awb){
        List<Route> routeList = packageServiceAxis2.getRoutesByAwb(Integer.parseInt(awb));

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("routes_data", routeList);

        return modelMap;
    }
}
