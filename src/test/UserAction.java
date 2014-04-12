package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.struts2.convention.annotation.*;

public class UserAction extends ActionSupport {

    private boolean success;
    private String message;
    private User user;
    private UserDAOImpl userDao;

    public String execute() throws Exception {

       // if(user.getUsername().equals("ad")&&user.getPassword().equals("ad")){
            this.success= true;
            UserDAO userdao = new UserDAOImpl();
            try{
/*                User u = new User();
                u.setUsername("dongxl");
                u.setPassword("123");
                userdao.save(u);
                return SUCCESS;*/
//                    this.success = false;
//                    this.message="对不起，用户不存在";
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
                    case 3:
                        return SUCCESS;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            //fail("Not yet implemented");
            //this.message="你的账号是："+user.getUsername()+"密码是："+user.getPassword();
        //}else{
        //    this.success=false;
        //    this.message="对不起，未授权的用户不能登录改系统";
        //}
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