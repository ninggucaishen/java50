package cc.heikafei.designMode.factoryMethodMode;

/**
 * jpg加载器工厂
 */
public class JpgReaderFactory implements ReaderFactory{
    @Override
    public Reader getReader() {
        return new JpgReader();
    }
}
