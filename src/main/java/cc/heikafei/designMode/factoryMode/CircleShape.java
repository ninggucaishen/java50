package cc.heikafei.designMode.factoryMode;

/**
 * 圆形
 */
public class CircleShape implements Shape{

    public CircleShape() {
        System.out.println("CircleShape created:");
    }

    @Override
    public void draw() {
        System.out.println("draw CircleShape");
    }
}
