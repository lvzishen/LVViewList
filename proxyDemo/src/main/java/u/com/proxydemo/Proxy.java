package u.com.proxydemo;

/**
 * 创建日期：2019/3/2 on 11:43
 * 描述:
 * 作者: lvzishen
 */
public class Proxy implements IFunction {
    private IFunction provider;

    Proxy(IFunction provider) {
        this.provider = provider;
    }

    @Override
    public void doAThing() {
        //在这里可以添加自己需要给每个功能提供者都代理上的公用逻辑
        doSomeThing();
        provider.doAThing();
    }

    private void doSomeThing() {
        System.out.println("This Time:" + (System.currentTimeMillis()));
    }

}
