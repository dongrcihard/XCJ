package instantmsg;

import java.util.HashSet;
import java.util.Set;

/*
 * 创建时间：14-4-18 下午2:03
 * 设计人员：dongxl.
 */
public class User {
    private Integer id;
    private String name;
    private String pass;

    private Set<Message> messages = new HashSet<Message>();

    public User() {

    }

    public User(Integer id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
