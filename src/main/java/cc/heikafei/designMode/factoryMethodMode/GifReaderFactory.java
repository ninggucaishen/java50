package cc.heikafei.designMode.factoryMethodMode;

/**
 * gif加载器工厂
 */
public class GifReaderFactory implements ReaderFactory{
    @Override
    public Reader getReader() {
        return new GifReader();
    }
}
