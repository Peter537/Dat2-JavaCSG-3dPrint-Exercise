import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class CarBodyTest {

    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();
        CarWheel leftFrontWheel = new CarWheel(csg, 3, 2);
        CarWheel rightFrontWheel = new CarWheel(csg, 3, 2);
        CarWheel leftBackWheel = new CarWheel(csg, 3, 2);
        CarWheel rightBackWheel = new CarWheel(csg, 3, 2);
        CarBody carBody = new CarBody(csg, 16, 7, 5);
        csg.view(carBody.generateWithWheels(leftFrontWheel, rightFrontWheel, leftBackWheel, rightBackWheel));
    }
}