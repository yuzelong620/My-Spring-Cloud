package com.yzl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by sunjingjia  on 2019/12/17.
 */
@SpringBootApplication
@EnableFeignClients //声明启用 Feign。
@EnableCircuitBreaker   //声明启用数据监控。
@EnableHystrixDashboard //声明启用可视化数据监控。
public class HystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class,args);
    }
}
