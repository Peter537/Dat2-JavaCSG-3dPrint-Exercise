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
        return csg.box3D(width, length, height, true);
    }

    public Geometry3D generateWithTranslate(int x, int y, int z) {
        Geometry3D generated = generate();
        return csg.translate3D(x, y, z).transform(generated);
    }
}