package cc.heikafei.designMode.factoryMethodMode;

public class Test {
    public static void main(String[] args) {

        //读取jpg
        ReaderFactory jpgReaderFactory = new JpgReaderFactory();
        Reader reader = jpgReaderFactory.getReader();
        reader.read();

        //读取png
        ReaderFactory pngReaderFactory = new PngReaderFactory();
        Reader reader2 = pngReaderFactory.getReader();
        reader2.read();

        //读取gif
        GifReaderFactory gifReaderFactory = new GifReaderFactory();
        Reader reader3 = gifReaderFactory.getReader();
        reader3.read();
    }
}
