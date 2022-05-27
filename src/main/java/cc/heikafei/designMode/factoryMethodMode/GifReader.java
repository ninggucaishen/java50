package cc.heikafei.designMode.factoryMethodMode;

/**
 * gif图片加载器
 */
public class GifReader implements Reader{
    @Override
    public void read() {
        System.out.println("read gif");
    }
}
