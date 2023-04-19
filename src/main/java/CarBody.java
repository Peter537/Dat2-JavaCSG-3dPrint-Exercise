import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class CarBody {

    private final JavaCSG csg;
    private final int length, width, height;

    public CarBody(JavaCSG csg, int length, int width, int height) {
        this.csg = csg;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Geometry3D generate() {
        Geometry3D box = csg.box3D(width, length, height, true);
        Geometry3D frontRemoval = csg.box3D(width + 1, length * 3 + 1, height / 4.5 + 1, true);
        Geometry3D frontRemovalRotated = csg.rotate3DX(csg.degrees(135)).transform(frontRemoval);
        return csg.difference3D(box, csg.translate3D(0, length / 2.0, height / 4.9).transform(frontRemovalRotated));
    }

    public Geometry3D generateWithTranslate(double x, double y, double z) {
        return csg.translate3D(x, y, z).transform(generate());
    }

    public Geometry3D generateWithWheels(CarWheel leftFrontWheel, CarWheel rightFrontWheel, CarWheel leftBackWheel, CarWheel rightBackWheel) {
        double x = this.width / 2.0;
        Geometry3D leftFrontWheel3d = leftFrontWheel.generateWithTranslate(
                -1 * (x - (leftFrontWheel.getWidth() / 2.0)), 4, 0);
        Geometry3D rightFrontWheel3d = rightFrontWheel.generateWithTranslate(
                1 * (x - (rightFrontWheel.getWidth() / 2.0)), 4, 0);
        Geometry3D leftBackWheel3d = leftBackWheel.generateWithTranslate(
                -1 * (x - (leftBackWheel.getWidth() / 2.0)), -4, 0);
        Geometry3D rightBackWheel3d = rightBackWheel.generateWithTranslate(
                1 * (x - (rightBackWheel.getWidth() / 2.0)), -4, 0);
        Geometry3D carBody = this.generateWithTranslate(0, 0, 1.9);
        return csg.difference3D(carBody,
                leftBackWheel.getFullSizeWithTranslate(
                        -1 * (x - (leftFrontWheel.getWidth() / 2.0)), 4, 0),
                rightFrontWheel.getFullSizeWithTranslate(
                        1 * (x - (rightFrontWheel.getWidth() / 2.0)), 4, 0),
                leftBackWheel.getFullSizeWithTranslate(
                        -1 * (x - (leftBackWheel.getWidth() / 2.0)), -4, 0),
                rightBackWheel.getFullSizeWithTranslate(
                        1 * (x - (rightBackWheel.getWidth() / 2.0)), -4, 0));
        }

    public int getWidth() {
        return this.width;
    }
}