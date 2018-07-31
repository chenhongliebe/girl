//package com.liebe.Config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Administrator on 2017/10/16.
// */
//@Configuration
//public class ApplicationConfig  {
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        MyFilter myFilter = new MyFilter();
//        registrationBean.setFilter(myFilter);
//        List<String> urlPatterns = new ArrayList<String>();
//        urlPatterns.add("/**");
//        registrationBean.setUrlPatterns(urlPatterns);
//        return registrationBean;
//    }
//
//
//}
