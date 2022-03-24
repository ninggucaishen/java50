package cc.heikafei.designMode.creationalPattern;

/**
 * 单例模式:
 * 1.私有化构造方法
 * 2.提供静态方法给外部类使用
 * 3.包含自身类型的成员变量
 */
public class mySingleton {

    private static mySingleton ms;

    //私有化构造方法
    private mySingleton() {
    }

    public static mySingleton getInstance() {
        //实例化依次
        //第一次调用getInstance的时候实例化
        if (ms == null) {
            ms = new mySingleton();
        }
        return ms;
    }
}
