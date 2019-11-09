package com.reyco.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.reyco.aop.core.annotation.EnableAop;

@Configuration
@ComponentScan("com.reyco")
@EnableAop
public class Appconfig {

}
