package test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*
 * 创建时间：14-4-18 下午1:25
 * 设计人员：dongxl.
 */
public class Chinese2 implements ApplicationContextAware {

    //using BeanFactory as member variable
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
            this.ctx = applicationContext;
    }

    public ApplicationContext getCtx() {
        return ctx;
    }
}
