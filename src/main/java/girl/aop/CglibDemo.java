package girl.aop;

/**
 * Created by cmazxiaoma on 2017/11/5.
 * everyday is mayday.
 */
public class CglibDemo {

    public static void main(String[] args) {
        Dog rayDog = Factory.getInstance(new CglibProxy());
        rayDog.call();
    }
}
