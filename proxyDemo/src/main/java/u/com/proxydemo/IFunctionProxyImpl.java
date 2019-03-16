package u.com.proxydemo;

/**
 * 创建日期：2019/3/2 on 16:18
 * 描述:
 * 作者: lvzishen
 */
public class IFunctionProxyImpl implements IFunctionProxy {


    @Override
    public void doAThing() {
        System.out.println("I am handle doAThing Method ");
    }

    @Override
    public void doBThing() {
        System.out.println("I am handle doBThing Method ");
    }

    @Override
    public void doCThing() {
        System.out.println("I am handle doCThing Method ");
    }

}
