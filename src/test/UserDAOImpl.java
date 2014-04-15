package test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO{

    //增加用户
    public void save(User user){
        Session session= HibernateUtil.getSession();	//生成Session实例
        Transaction tx = session.beginTransaction();	//创建Transaction实例
        try{
            session.save(user);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally{
        HibernateUtil.closeSession();
        }
    }

    //根据用户标识查找指定用户
    public User findById(int id){
        User user=null;
        Session session= HibernateUtil.getSession();	//生成Session实例
        Transaction tx = session.beginTransaction();	//创建Transaction实例
        try{
            user=(User)session.get(User.class,id);		//使用Session的get方法获取指定id的用户到内存中
            tx.commit();								//提交事务
        } catch(Exception e){
            e.printStackTrace();
            tx.rollback();								//回滚事务
        }finally{
            HibernateUtil.closeSession();				//关闭Session实例
        }
        return user;
    }

    //核对用户是否正确
    public int findUser(User user){
        Session session= HibernateUtil.getSession();	//生成Session实例
        Transaction tx = session.beginTransaction();	//创建Transaction实例
        try{
            List list = session.createQuery("from User where username like :username").setParameter("username", user.getUsername()).list();			//使用Session的get方法获取指定id的用户到内存中
            switch (list.size()) {
                case 0:
                    return 1;   //用户名错误
                case 1:
                    User u = (User)list.get(0);
                    if (!u.getPassword().equalsIgnoreCase(user.getPassword())) {
                        return 2;   //用户名错误
                    } else {
                        return 3;   //登录正确
                    }
                default:
                    return 4;   //表示同名用户存在，数据库错误
            }
        } catch(Exception e){
            e.printStackTrace();
            tx.rollback();								//回滚事务
        }finally{
            HibernateUtil.closeSession();				//关闭Session实例
        }
        return 0;
    }

    //删除用户
    public void delete(User user){
        Session session= HibernateUtil.getSession();	//生成Session实例
        Transaction tx = session.beginTransaction();	//创建Transaction实例
        try{
            session.delete(user);						//使用Session的delete方法将持久化对象删除
            tx.commit();								//提交事务
        } catch(Exception e){
            e.printStackTrace();
            tx.rollback();								//回滚事务
        }finally{
            HibernateUtil.closeSession();				//关闭Session实例
        }
    }

    //修改用户信息
    public void update(User user){
        Session session = HibernateUtil.getSession();	//生成Session实例
        Transaction tx = session.beginTransaction();	//创建Transaction实例
        try{
            session.update(user);						//使用Session的update方法更新持久化对象
            tx.commit();								//提交事务
        } catch(Exception e){
            e.printStackTrace();
            tx.rollback();								//回滚事务
        }finally{
            HibernateUtil.closeSession();				//关闭Session实例
        }
    }
}
