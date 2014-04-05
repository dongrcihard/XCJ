package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class NewsManager {

    public static void main(String[] args) throws Exception {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        Configuration conf = new Configuration().configure();
        //新方法初始化SensssionFactory
        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(sr);
        //以Configuration创建SessionFactory
        //实例化Session
        Session sess = sf.openSession();
        //开始事务
        Transaction tx = sess.beginTransaction();
        //创建消息实例
        News n = new News();
        //设置消息标题和消息内容
        n.setTitle("hibernate");
        n.setContent("i am testing.");
        //保存消息
        sess.save(n);
        //提交事务
        tx.commit();
        //关闭Session
        sess.close();

    }
}
