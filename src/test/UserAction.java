package test;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    private boolean success;
    private String message;
    private User user;
//    private UserDAOImpl userDao;

    public String execute() throws Exception {
        this.success = true;
        UserDAO userdao = new UserDAOImpl();
        try {
            /*查找用户*/
            int find = userdao.findUser(user);
            switch (find) {
                case 0:
                    this.success = false;
                    this.message = "对不起，数据库访问出错，请联系管理员。";
                    break;
                case 1:
                    this.success = false;
                    this.message = "对不起，用户名错误";
                    break;
                case 2:
                    this.success = false;
                    this.message = "对不起，密码错误";
                    break;
                case 4:
                    this.success = false;
                    this.message = "对不起，同名用户存在，请联系管理员";
                    break;
                default:
                    HibernateUtil.shutdown();
                    return SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        HibernateUtil.shutdown();
        return SUCCESS;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}