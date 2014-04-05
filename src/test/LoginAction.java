package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;


public class LoginAction extends ActionSupport{

    private boolean success = true;
    private String message;
    private User user;

    public String execute() throws Exception {

        if(user.getUsername().equals("admin")&&user.getPassword().equals("admin")){
            this.success= true;
            //this.message="你的账号是："+user.getUsername()+"密码是："+user.getPassword();
        }else{
            this.success=false;
            this.message="对不起，未授权的用户不能登录改系统";
        }
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