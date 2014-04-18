/*
 * 创建时间：14-4-18 上午8:24
 * 设计人员：dongxl.
 */
package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        //Create the ApplicationContext of Spring.
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
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

    }
}
