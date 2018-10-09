package com.sunway.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
 
@SpringBootApplication
// 使@Filter里的urlPatterns生效。
@ServletComponentScan
public class Application   {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
 
}
