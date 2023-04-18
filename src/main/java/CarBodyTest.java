import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class CarBodyTest {

    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();
        CarBody carBody = new CarBody(csg, 16, 7, 5);
        csg.view(carBody.generate());
    }
}