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
        Geometry3D leftFrontWheel = this.leftFrontWheel.generateWithTranslate(-2, 4, 0);
        Geometry3D rightFrontWheel = this.rightFrontWheel.generateWithTranslate(2, 4, 0);
        Geometry3D leftBackWheel = this.leftBackWheel.generateWithTranslate(-2, -4, 0);
        Geometry3D rightBackWheel = this.rightBackWheel.generateWithTranslate(2, -4, 0);
        Geometry3D carBody = this.carBody.generateWithTranslate(0, 0, 2.2);

        return csg.union3D(carBody, leftFrontWheel, rightFrontWheel, leftBackWheel, rightBackWheel);
    }
}