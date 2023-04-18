import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class CarWheelTest {

    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();
        CarWheel wheel = new CarWheel(csg, 3, 2);
        csg.view(wheel.generate());
    }
}