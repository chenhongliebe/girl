package com.liebe.lambda;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


public class ListTest {


    public static void main(String[] args) {

        //1
        List<com.liebe.lambda.User> userList = new ArrayList<>();
        userList.add(new com.liebe.lambda.User());
        //分组
        Map<String, List<User>> groupBySex = userList.stream().collect(Collectors.groupingBy(User::getSex));
////        //遍历分组
////        for (Map.Entry<String, List<User>> entryUser : groupBySex.entrySet()) {
////            String key = entryUser.getKey();
////            List<User> entryUserList = entryUser.getValue();
////        }

        //2
        //过滤
        //排除掉工号为201901的用户
        List<User> userCommonList = userList.stream().filter(a -> !a.getJobNumber().equals("201901")).collect(Collectors.toList());


        //3求和
        //基本类型
//        int sumAge = userList.stream().mapToInt(User::getAge).sum();
//        //BigDecimal求和
        BigDecimal totalQuantity = userList.stream().map(User::getFamilyMemberQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);


        //4 最小
        Date minEntryDate = userList.stream().map(User::getEntryDate).min(Date::compareTo).get();
//
//        //最大
        Date maxEntryDate = userList.stream().map(User::getEntryDate).max(Date::compareTo).get();

        //5 list转map
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  user1,user2的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Long, User> userMap = userList.stream().collect(Collectors.toMap(User::getId, a -> a,(k1, k2)->k1));
        //6
        //单字段排序，根据id排序
        userList.sort(Comparator.comparing(User::getId));
//        //多字段排序，根据id，年龄排序
        userList.sort(Comparator.comparing(User::getId).thenComparing(User::getAge));

        //7 可通过distinct方法进行去重
        List<Integer> idList = Arrays.asList(3,5,6,3,4,5,8,9);
        List<Integer> distinctIdList = idList.stream().distinct().collect(Collectors.toList());
        distinctIdList.forEach(v-> System.out.println(v));

        //8获取list对象的某个字段组装成新list
        List<Long> userIdList = userList.stream().map(a -> a.getId()).collect(Collectors.toList());
    }


}
