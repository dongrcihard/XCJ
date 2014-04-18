package test;

/*
 * 创建时间：14-4-18 上午9:28
 * 设计人员：dongxl.
 */
public class Chinese implements Person {
    private Axe axe;

    //It is necessary to write this non-parameter constructor when using Spring.
    public Chinese() {

    }

    public Chinese(Axe axe) {
        this.axe = axe;
    }

    //Dependency Injection method
    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    @Override
    public void useAxe() {
        System.out.println(axe.chop());
    }
}

