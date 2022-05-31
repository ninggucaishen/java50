package cc.heikafei.designMode.abstractDesignMode;

public class IosFactroy implements SystemFactory{
    @Override
    public OperationController createOperationController() {
        return new IosOperationController();
    }

    @Override
    public UIController createInterfaceController() {
        return new IosUIController();
    }
}
