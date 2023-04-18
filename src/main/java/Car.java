import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Car {

    private final JavaCSG csg;
    private final CarBody carBody;
    private final CarWheel leftFrontWheel, rightFrontWheel, leftBackWheel, rightBackWheel;

    public Car(JavaCSG csg, CarBody carBody, CarWheel leftFrontWheel, CarWheel rightFrontWheel, CarWheel leftBackWheel, CarWheel rightBackWheel) {
        this.csg = csg;
        this.carBody = carBody;
        this.leftFrontWheel = leftFrontWheel;
        this.rightFrontWheel = rightFrontWheel;
        this.leftBackWheel = leftBackWheel;
        this.rightBackWheel = rightBackWheel;
    }

    public Geometry3D generate() {
        double x = carBody.getWidth() / 2.0;
        Geometry3D leftFrontWheel3d = this.leftFrontWheel.generateWithTranslate(
                -1 * (x - (this.leftFrontWheel.getWidth() / 2.0)), 4, 0);
        Geometry3D rightFrontWheel3d = this.rightFrontWheel.generateWithTranslate(
                1 * (x - (this.rightFrontWheel.getWidth() / 2.0)), 4, 0);
        Geometry3D leftBackWheel3d = this.leftBackWheel.generateWithTranslate(
                -1 * (x - (this.leftBackWheel.getWidth() / 2.0)), -4, 0);
        Geometry3D rightBackWheel3d = this.rightBackWheel.generateWithTranslate(
                1 * (x - (this.rightBackWheel.getWidth() / 2.0)), -4, 0);
        Geometry3D carBody = this.carBody.generateWithTranslate(0, 0, 1.9);
        Geometry3D car = csg.difference3D(carBody,
                this.leftBackWheel.getFullSizeWithTranslate(
                        -1 * (x - (this.leftFrontWheel.getWidth() / 2.0)), 4, 0),
                this.rightFrontWheel.getFullSizeWithTranslate(
                        1 * (x - (this.rightFrontWheel.getWidth() / 2.0)), 4, 0),
                this.leftBackWheel.getFullSizeWithTranslate(
                        -1 * (x - (this.leftBackWheel.getWidth() / 2.0)), -4, 0),
                this.rightBackWheel.getFullSizeWithTranslate(
                        1 * (x - (this.rightBackWheel.getWidth() / 2.0)), -4, 0));

        return csg.union3D(car, leftFrontWheel3d, rightFrontWheel3d, leftBackWheel3d, rightBackWheel3d);
    }
}