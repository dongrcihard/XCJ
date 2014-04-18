package test;

/*
 * 创建时间：14-4-18 上午8:27
 * 设计人员：dongxl.
 */
public class PersonService {
    private String name;
    //the method of name property
    public void setName(String name) {
        this.name = name;
    }
    public void info() {
        System.out.println("The person's name is " + name);
    }
}
