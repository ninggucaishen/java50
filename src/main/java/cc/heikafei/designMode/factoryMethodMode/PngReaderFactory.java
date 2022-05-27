package cc.heikafei.designMode.factoryMethodMode;

/**
 * png加载器工厂
 */
public class PngReaderFactory implements ReaderFactory{
    @Override
    public Reader getReader() {
        return new PngReader();
    }
}
