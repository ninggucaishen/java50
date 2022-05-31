package cc.heikafei.designMode.abstractDesignMode;

public class Test {
    public static void main(String[] args) {

        SystemFactory mFactory;
        UIController interfaceFactory;
        OperationController operationController;

        //Andriod
        //mFactory = new AndriodFactory();

        //IOS
        mFactory = new IosFactroy();

        //WP
        //mFactory = new WpFactory();
        //注释都打开的话，控制台输出最下面的

        interfaceFactory = mFactory.createInterfaceController();
        operationController = mFactory.createOperationController();

        interfaceFactory.display();
        operationController.control();

    }
}
