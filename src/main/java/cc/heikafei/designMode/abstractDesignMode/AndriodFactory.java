package cc.heikafei.designMode.abstractDesignMode;

/**
 * Andriod Factory
 */
public class AndriodFactory implements SystemFactory{
    @Override
    public OperationController createOperationController() {
        return new AndriodOperationController();
    }

    @Override
    public UIController createInterfaceController() {
        return new AndriodUIController();
    }
}
