package com.example.demo.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ControllerAdvice
public class GlobalController {

    private String userName;
    private static String LANGUAGE;
    public static boolean IS_LANGUAGE_EN;

    public GlobalController() {
    }

    static {
        LANGUAGE = "en";
        IS_LANGUAGE_EN = LANGUAGE.equals("en");
    }

    @ModelAttribute("userName")
    public String getUserName() {
        if (userName == null && SecurityContextHolder.getContext().getAuthentication() != null) {
            userName = SecurityContextHolder.getContext().getAuthentication().getName();
        }
        return userName;
    }

    @ModelAttribute("lang")
    public String getLanguage() {
        LANGUAGE = LocaleContextHolder.getLocale().toString();
        return LANGUAGE;
    }

    @ModelAttribute("pathCSS")
    public String isLangAR() {
        return LANGUAGE.equals("ar") ? "/dist/css/AdminLTE-rtl.min.css" : "/dist/css/AdminLTE.min.css";
    }

    @ModelAttribute("direction")
    public String direction() {
        return LANGUAGE.equals("ar") ? "rtl" : "ltr";
    }

    @RequestMapping("/")
    public String testPage(){
        return "index";
    }

}
