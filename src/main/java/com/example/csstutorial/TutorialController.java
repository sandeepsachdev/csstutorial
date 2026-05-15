package com.example.csstutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TutorialController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/basics")
    public String basics() {
        return "basics";
    }

    @GetMapping("/box-model")
    public String boxModel() {
        return "box-model";
    }

    @GetMapping("/flexbox")
    public String flexbox() {
        return "flexbox";
    }

    @GetMapping("/mobile")
    public String mobile() {
        return "mobile";
    }

    @GetMapping("/media-queries")
    public String mediaQueries() {
        return "media-queries";
    }
}
