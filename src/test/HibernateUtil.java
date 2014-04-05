package test;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
	
	/*
	//This program is ok.
	private static final SessionFactory sessionFactory;
	static{
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new AnnotationConfiguration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	*/

    private static SessionFactory sessionFactory;
    private  static Configuration configuration = new Configuration();
    //创建线程局部变量threadLocal，用来保存Hibernate的Session
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    //使用静态代码块初始化Hibernate
    static {
        try {
            Configuration cfg=new Configuration().configure();		//读取配置文件hibernate.cfg.xml
            sessionFactory=cfg.buildSessionFactory();				//创建SessionFactory
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    //获得SessionFactory实例
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    //获得ThreadLocal 对象管理的Session实例.
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            //通过SessionFactory对象创建Session对象
            session = (sessionFactory != null) ? sessionFactory.openSession(): null;
            //将新打开的Session实例保存到线程局部变量threadLocal中
            threadLocal.set(session);
        }
        return session;
    }
    //关闭Session实例
    public static void closeSession() throws HibernateException {
        //从线程局部变量threadLocal中获取之前存入的Session实例
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
    //重建SessionFactory
    public static void rebuildSessionFactory() {
        try {
            configuration.configure("/hibernate.cfg.xml");			//读取配置文件hibernate.cfg.xml
            sessionFactory = configuration.buildSessionFactory();		//创建SessionFactory
        } catch (Exception e) {
            System.err.println("Error Creating SessionFactory ");
            e.printStackTrace();
        }
    }
    //关闭缓存和连接池
    public static void shutdown() {
        getSessionFactory().close();
    }
}

