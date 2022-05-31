package cc.heikafei.designMode.abstractDesignMode;

public interface SystemFactory {
    public OperationController createOperationController();

    public UIController createInterfaceController();
}
