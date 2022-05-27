package cc.heikafei.designMode.factoryMethodMode;

/**
 * png图片加载器
 */
public class PngReader implements Reader{
    @Override
    public void read() {
        System.out.println("read png");
    }
}
