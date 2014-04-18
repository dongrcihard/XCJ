package instantmsg;

/*
 * 创建时间：14-4-18 下午2:06
 * 设计人员：dongxl.
 */
public class Message {
    private Integer id;
    private String title;
    private String content;

    private User user;

    public Message() {

    }

    public Message(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
