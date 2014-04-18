/*
 * 创建时间：14-4-18 上午8:24
 * 设计人员：dongxl.
 */
package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

public class SpringTest {
    public static void main(String[] args) {
        //Create the ApplicationContext of Spring.
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("Springxml/person_bean.xml", "Springxml/spring_test.xml");
        System.out.println("ctx");
        System.out.println("------------------------------");
        PersonService p = ctx.getBean("personService", PersonService.class);
        p.info();

        System.out.println("------------------------------");
        Person person = ctx.getBean("chinese", Person.class);
        person.useAxe();

        System.out.println("------------------------------");
        Person person1 = ctx.getBean("chinese2", Person.class);
        person1.useAxe();

        System.out.println("------------------------------");
        String[] a = {"reader"};
        String hello = ctx.getMessage("hello", a, Locale.getDefault());
        Object[] b = {new Date()};
        String now = ctx.getMessage("now", b, Locale.getDefault());
        System.out.println(hello);
        System.out.println(now);

        System.out.println("------------------------------");
        EmailEvent ele = new EmailEvent("hello", "spring_test@163.com",
                "this is a test");
        ctx.publishEvent(ele);

        System.out.println("------------------------------");
        Chinese2 chinese2 = ctx.getBean("chinese3", Chinese2.class);
        System.out.println(chinese2.getCtx());
        System.out.println(ctx == chinese2.getCtx());
    }
}