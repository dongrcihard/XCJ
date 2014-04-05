package test;

import java.util.List;

//创建UserDAO接口
public interface UserDAO {
    void save(User user);			//添加用户
    User findById(int id);			//根据用户标识查找指定用户
    void delete(User user);			//删除用户
    void update(User user);			//修改用户信息
    boolean findUser(User user);
}

