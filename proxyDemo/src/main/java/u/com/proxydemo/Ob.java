package u.com.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 创建日期：2019/3/2 on 16:53
 * 描述:
 * 作者: lvzishen
 */
//public class Proxy implements IFunctionP, IFunctionProxy {
//    InvocationHandler invocationHandler = new InvocationHandler() {
//        @Override
//        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//            System.out.println("Start:" + System.currentTimeMillis());
//            System.out.println("End:" + System.currentTimeMillis());
//            return null;
//        }
//    };
//
//    @Override
//    public String doIFunctionP() {
//        try {
//            Method method = IFunctionP.class.getMethod("doIFunctionP");
//            return (String) invocationHandler.invoke(this, method, null);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public void doAThing() {
//        try {
//            Method method = IFunctionProxy.class.getMethod("doAThing");
//            invocationHandler.invoke(this, method, null);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
//
//    @Override
//    public void doBThing() {
//        try {
//            Method method = IFunctionProxy.class.getMethod("doBThing");
//            invocationHandler.invoke(this, method, null);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
//
//    @Override
//    public void doCThing() {
//        try {
//            Method method = IFunctionProxy.class.getMethod("doCThing");
//            invocationHandler.invoke(this, method, null);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
//}
