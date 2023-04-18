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
}