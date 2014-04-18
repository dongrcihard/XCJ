package test;

import org.springframework.context.ApplicationEvent;

/*
 * 创建时间：14-4-18 下午12:44
 * 设计人员：dongxl.
 */
public class EmailEvent extends ApplicationEvent {

    private String address;
    private String text;

    public EmailEvent(Object source) {
        super(source);
    }

    public EmailEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


