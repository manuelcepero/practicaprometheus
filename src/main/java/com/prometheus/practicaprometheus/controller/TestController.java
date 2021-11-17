/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prometheus.practicaprometheus.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manuel
 */
@RestController
public class TestController {
    
    private Counter counter;
    
    public TestController(MeterRegistry registry){
        this.counter = Counter.builder("invocaciones.hello").description("Invocaciones totales").register(registry);
    }
    
    @GetMapping(path="/helloWorld")
    public String helloWorld(){
        counter.increment();
        return "Hello World";
    }
    
}
