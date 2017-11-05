package girl.aop;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by cmazxiaoma on 2017/11/5.
 * everyday is mayday.
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return null;
    }
}
