package me.lunev.homework34.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String start() {
        return "<h1 style=\"text-align: center\">Приложение запущено</h1>";
    }

    @GetMapping("/info")
    public String info() {
        return "Дмитрий<br>Course3<br>12.01.2023<br>Приложение для сайта рецептов";
    }
}
