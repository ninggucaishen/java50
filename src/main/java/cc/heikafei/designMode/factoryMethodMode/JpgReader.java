package cc.heikafei.designMode.factoryMethodMode;

/**
 * jpg图片加载器
 */
public class JpgReader implements Reader{
    @Override
    public void read() {
        System.out.println("read jpg");
    }
}
