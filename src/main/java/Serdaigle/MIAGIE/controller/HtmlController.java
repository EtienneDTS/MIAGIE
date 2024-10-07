package Serdaigle.MIAGIE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/hello")
    public String hello() {
        return "hello"; // Le nom du fichier HTML sans l'extension .html
    }
}