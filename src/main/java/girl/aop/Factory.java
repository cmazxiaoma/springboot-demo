package girl.aop;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by cmazxiaoma on 2017/11/5.
 * everyday is mayday.
 */
public class Factory {

    public static Dog getInstance(CglibProxy proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback(proxy);
        Dog rayDog = (Dog) enhancer.create();
        return rayDog;
    }
}
