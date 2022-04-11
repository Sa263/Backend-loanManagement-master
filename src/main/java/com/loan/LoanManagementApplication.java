package com.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages={
        "com.loan.controller", "com.loan.exception","com.loan.model","com.loan.proxy","com.loan.repository","com.loan.service","com.loan.serviceimpl"})
@EnableFeignClients
@EnableSwagger2
//@EnableEurekaClient
public class LoanManagementApplication {
    public static void main(String args[])
    {
        SpringApplication.run(LoanManagementApplication.class, args);
    }

}
