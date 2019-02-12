package com.tracking.onlinetracking.api;

import com.tracking.onlinetracking.persistance.User;
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
import packages.wsdl.PackageDTO;

import javax.validation.Valid;

/**
 * Created by Robi on 1/13/2019.
 */
@Controller
public class SignUpController {
    @Autowired
    PackageServiceAxis2 packageServiceAxis2;

    @GetMapping("/signup")
    public ModelMap getSignUpForm(@RequestParam(value = "id",required = false)User user){
        if(user == null){
            user = new User();
        }
        return new ModelMap("user", user);
    }

    @PostMapping("/signup")
    public String postSignUpForm(@ModelAttribute @Valid User user, BindingResult errors, SessionStatus status){
        if (errors.hasErrors()){
            return "admin/add_form";
        }
        packageServiceAxis2.registerUser(user);
        status.setComplete();
        return "redirect:login";
    }
}
