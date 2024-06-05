package br.ucsal.youp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @GetMapping("/youp")
    public String index(){
        return "home.html";
    }
}
