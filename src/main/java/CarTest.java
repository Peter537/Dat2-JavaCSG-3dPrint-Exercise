import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class CarTest {

    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();

        CarWheel leftFrontWheel = new CarWheel(csg, 3, 2);
        CarWheel rightFrontWheel = new CarWheel(csg, 3, 2);
        CarWheel leftBackWheel = new CarWheel(csg, 3, 2);
        CarWheel rightBackWheel = new CarWheel(csg, 3, 2);
        CarBody carBody = new CarBody(csg, 16, 7, 5);
        Car car = new Car(csg, carBody, leftFrontWheel, rightFrontWheel, leftBackWheel, rightBackWheel);

        csg.view(car.generate());
    }
}