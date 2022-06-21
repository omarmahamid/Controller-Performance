package com.omriato.plm.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/server", produces = MediaType.APPLICATION_JSON_VALUE)
public class PLMController {

    @PostMapping(path = "/execute")
    public String doPost(@RequestBody final String body){
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "PING";
    }

}
