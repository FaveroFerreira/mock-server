package org.faveroferreira.mockserver.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GeneralController {

    @GetMapping(value = "/**")
    public String testGeneralGet() {
        System.out.println("get ok");
        return "a";
    }

    @PostMapping("/**")
    public void testGeneralPost() {
        System.out.println("get post");
    }

    @PutMapping("/**")
    public void testGeneralPut() {
        System.out.println("get put");
    }

    @DeleteMapping("/**")
    public void testGeneralDelete() {
        System.out.println("get delete");
    }

}
