package cc.heikafei.designMode.factoryMode;

public class Test {
    public static void main(String[] args) {

        //画圆形
        Shape shape = ShapeFactory.getShape("circle");
        shape.draw();

        //画正方形
        Shape shape2 = ShapeFactory.getShape("rect");
        shape2.draw();

        //画三角形
        Shape shape3 = ShapeFactory.getShape("triangle");
        shape3.draw();

    }
}
