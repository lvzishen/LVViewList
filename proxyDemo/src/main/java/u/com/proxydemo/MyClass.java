package u.com.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyClass {

    public static void main(String args[]) {
//        IFunction iFunction = new FunctionProvider(); //新建具体实现类
//        Proxy proxy = new Proxy(iFunction); //放入代理类
//        proxy.doAThing(); //执行最终的逻辑,给方法套用相同的逻辑

//        Object proxyInstance = java.lang.reflect.Proxy.newProxyInstance(IFunctionP.class.getClassLoader(), new Class[]{IFunctionP.class, IFunctionProxy.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object obj, Method method, Object[] objects) throws Throwable {
//                System.out.println("Start:" + System.currentTimeMillis());
//                System.out.println("End:" + System.currentTimeMillis());
//                return obj;
//            }
//        });
//        IFunctionProxy iFunctionProxy = (IFunctionProxy) proxyInstance;
//        iFunctionProxy.doAThing();
//        iFunctionProxy.doBThing();
//        iFunctionProxy.doCThing();
//        IFunctionP iFunctionProxy1 = (IFunctionP) proxyInstance;
//        iFunctionProxy1.doIFunctionP();

        final IFunctionProxyImpl functionProxy = new IFunctionProxyImpl();
        Object proxyInstance = java.lang.reflect.Proxy.newProxyInstance(functionProxy.getClass().getClassLoader(), new Class[]{IFunctionProxy.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object obj, Method method, Object[] objects) throws Throwable {
//                if (method.getName().equals("doAThing")) {
//                    System.out.print("do A:" + System.currentTimeMillis());
//                }
                System.out.println("Start:" + System.currentTimeMillis());
                Object o = method.invoke(functionProxy, objects);
                System.out.println("End:" + System.currentTimeMillis());
                return o;
            }
        });
        IFunctionProxy iFunctionProxy = (IFunctionProxy) proxyInstance;
        iFunctionProxy.doAThing();
        iFunctionProxy.doBThing();
        iFunctionProxy.doCThing();

    }

}
