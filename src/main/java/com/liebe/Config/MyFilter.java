//package com.liebe.Config;
//
//
//import javax.servlet.*;
//import java.io.IOException;
//import java.util.Calendar;
//
//
///**
// * Created by Administrator on 2017/10/16.
// */
//public class MyFilter implements Filter{
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.print("过滤器init");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        // 获取系统时间
//        Calendar ca = Calendar.getInstance();
//        int hour = ca.get(Calendar.HOUR_OF_DAY);
//        System.out.print("过滤器doFilter:"+hour);
//        // 设置限制运行时间 0-4点
//        if (hour < 4) {
////            HttpServletResponse httpResponse = (HttpServletResponse) response;
////            httpResponse.setCharacterEncoding("UTF-8");
////            httpResponse.setContentType("application/json; charset=utf-8");
////
////            // 消息
////            Map<String, Object> messageMap = new HashMap<>();
////            messageMap.put("status", "1");
////            messageMap.put("message", "此接口可以请求时间为:0-4点");
////            ObjectMapper objectMapper=new ObjectMapper();
////            String writeValueAsString = objectMapper.writeValueAsString(messageMap);
////            response.getWriter().write(writeValueAsString);
//            System.out.print("过滤器doFilter:111111111#######");
//        } else {
//            chain.doFilter(request, response);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
