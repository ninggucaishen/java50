package cc.heikafei.designMode.abstractDesignMode;

public class WpFactory implements SystemFactory{
    @Override
    public OperationController createOperationController() {
        return new WpOperationController();
    }

    @Override
    public UIController createInterfaceController() {
        return new WpUIController();
    }
}
