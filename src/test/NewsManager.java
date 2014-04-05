package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class NewsManager {

    public static void main(String[] args) throws Exception {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        Configuration conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        SessionFactory sf = conf.buildSessionFactory();
        //实例化Session
        Session sess = sf.openSession();
        //开始事务
        Transaction tx = sess.beginTransaction();
        //创建消息实例
        News n = new News();
        //设置消息标题和消息内容
        n.setTitle("疯狂Java联盟成立了FFFF");
        n.setContent("疯狂Java联盟成立了，"
                + "网站地址http://www.crazyjava.org");
        //保存消息
        sess.save(n);
        //提交事务
        tx.commit();
        //关闭Session
        sess.close();
    }
}
