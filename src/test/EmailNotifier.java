package test;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/*
 * 创建时间：14-4-18 下午12:48
 * 设计人员：dongxl.
 */
public class EmailNotifier implements ApplicationListener{
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //only for EmailEvent, send the Email notification.
        if (applicationEvent instanceof EmailEvent){
            EmailEvent emailEvent = (EmailEvent)applicationEvent;
            System.out.println("Mail send Address " +
                emailEvent.getAddress());
            System.out.println("Main send context " +
                emailEvent.getText());
        }else {
            System.out.println("The container event " + applicationEvent);
        }
    }
}
