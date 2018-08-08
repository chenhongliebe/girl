package com.liebe;

import com.liebe.sys.entity.User;
import com.liebe.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2017/7/28.
 */
@RestController
@RequestMapping("home")
@Slf4j
public class HelloController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/")
    public String say(){
    System.out.print("#####################");
        return "hello spring boot";
    }
    @RequestMapping("hello")
    public String sayHello(HttpServletRequest request) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        log.info("用户名："+user.getUsername());
        HttpSession session = request.getSession();
        String s = session.getId();
        String str = (String) redisUtil.get(s);
        log.info("sssss："+s);
        return "hello world";
    }

    @RequestMapping("login")
    public ModelAndView login(User user, HttpServletRequest request, HttpServletResponse response){
        String username = user.getUsername();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()) {
            try {
                //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
                //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
                //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
                log.info("对用户[" + username + "]进行登录验证..验证开始");
                currentUser.login(token);
//                String ids = UUID.randomUUID().toString().replaceAll("-", "");

                log.info("对用户[" + username + "]进行登录验证..验证通过");
            } catch (AuthenticationException ae) {
                //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
                log.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
//                ae.printStackTrace();
            }
        }
        HttpSession session = request.getSession();
        String s = session.getId();
        log.info("ids:"+s);
        log.info("username:"+username);
        redisUtil.set(s,username);

        log.info("当前用户：{}",currentUser.getPrincipal());
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            log.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            return new ModelAndView("redirect:/index.html");
        }else{
            token.clear();
            return new ModelAndView("redirect:/login.html");
        }
    }




//    public static void main(String[] arg){

//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
//                "classpath:conf/spring-redis-sentinel.xml");
//        RedisTemplate<String, String> template = (RedisTemplate<String, String>) context.getBean("redisTemplate");
//        template.opsForValue().set("aaa", "aaabbb");
//        System.err.println(template.opsForValue().get("aaa"));




//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("1");

//        int[] a = {24,55,64,34,11,6,34,23,67};
////        int[] a = {10,20,15,0,6,7,2,1,-5,55};
//        System.out.print("排序前：");
//        printArr(a);
//
////        bubbleSort(a);
////        System.out.print("冒泡排序后：");
////        printArr(a);
//
//        quick(a);
//        System.out.print("快速排序后：");
//        printArr(a);
//
//        Singleton s  = Singleton.getInsatnce();
//        Calendar calendar = Calendar.getInstance();
//        long maxMemory = Runtime.getRuntime().maxMemory();
//        long totalMemory = Runtime.getRuntime().totalMemory();
//        System.out.println("maxMemory="+maxMemory+"字节、"+(maxMemory/(double)1024/1024)+"MB");
//        System.out.println("totalMemory="+totalMemory+"字节、"+(totalMemory/(double)1024/1024)+"MB");



//    }

    /**
     *
     * @param numbers 带排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void quickSort(int[] numbers,int low,int high)
    {
        if (low < high ){
            int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle-1);   //对低字段表进行递归排序
            quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }

    }
    public static int getMiddle(int[] a,int low ,int high){
//        int[] a = {23,55,64,34,11,6,34,23,67};
        int temp = a[low];/*用字表的第一个记录作为枢轴*/
       while(low<high){
           while(low<high && temp <=a[high]){
               high--;
           }
           a[low]=a[high];/*将比第一个小的移到低端*/
           while(low<high && a[low]<temp){
               low++;
           }
           a[high] = a[low];/*将比第一个大的移到高端*/
       }
       a[low]=temp;
        return low;// 返回中轴的位置
    }

    /**
     * 快速排序
     * @param numbers 带排序数组
     */
    public static void quick(int[] numbers)
    {
        if(numbers.length > 0)   //查看数组是否为空
        {
            quickSort(numbers, 0, numbers.length-1);
        }
    }

    public static void printArr(int[] numbers)
    {
        for(int i = 0 ; i < numbers.length ; i ++ )
        {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }

    public static void quickSorts(int[] a,int low ,int high){
        if(low<high){
            int middle =getMiddle(a,low,high);
            quickSorts(a,low,middle-1);
            quickSorts(a,middle+1,high);
        }
    }



    public static int calcu(Point point,Point[] points,int sum,int count){
        for(int i=0;i<points.length;i++){
                if(points[i].checked==false){
                    points[i].checked=true;
                    count++;
                    sum +=point.getLength(points[i]);
                    if(count==points.length){
                        sum+=points[i].getLength(start);
                        if(sum<min){
                            min = sum;
                        }
                    }
                    calcu(points[i],points,sum,count);

                    points[i].checked=false;
                    sum-=point.getLength(points[i]);
                    count--;
                }
        }
        return min;
    }
    private static int min =Integer.MAX_VALUE;
    public static final Point start = new Point(0,0);

    public static void main(String[] arg){
//        Point[] points=new Point[4];
//        points[0]=new Point(2,2);
//        points[1]=new Point(2,8);
//        points[2]=new Point(4,4);
//        points[3]=new Point(7,2);
//        int min =calcu(start,points,0,0);
//        System.out.println(min);

        Student zlj = new Student("丁晓宇", 21);
        Student dxy = new Student("赵四", 22);
        Student cjc = new Student("张三", 11);
        Student lgc = new Student("刘武", 19);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(zlj);
        studentList.add(dxy);
        studentList.add(cjc);
        studentList.add(lgc);

        System.out.println("按年龄升序：");
//        Collections.sort(studentList, new SortByAge());
        for (Student student : studentList) {
            System.out.println(student.getName() + " / " + student.getAge());
        }
        System.out.println();
        System.out.println("按姓名排序：");
//        Collections.sort(studentList, new SortByName());
        for (Student student : studentList) {
            System.out.println(student.getName() + " / " + student.getAge());
        }


    }


    class SortByAge implements Comparator {
        public int compare(Object o1, Object o2) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            if (s1.getAge() > s2.getAge())
                return 1;
            return -1;
        }
    }

    class SortByName implements Comparator {
        public int compare(Object o1, Object o2) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            return s1.getName().compareTo(s2.getName());
        }
    }




}
