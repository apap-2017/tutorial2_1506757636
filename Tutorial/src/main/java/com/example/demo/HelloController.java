package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HelloController {

    @RequestMapping("/hello")
        public String index() {
            return "Hello";
    }

    @RequestMapping("/greeting")
        public String greeting (@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/greeting/{name}")
    public String greetingPath (@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/perkalian")
        public String perkalian(@RequestParam(value = "a", defaultValue = "0")Long a, Long b, Long result, Model model, Model model2, Model model3) {
           if (b == null) {
            model.addAttribute("a", a);
            model2.addAttribute("b", 0);
            model3.addAttribute("result", a * 0);
        } else {
            model.addAttribute("a", a);
            model2.addAttribute("b", b);
            model3.addAttribute("result", a * b);
        }
        return "perkalian";
    }
}
