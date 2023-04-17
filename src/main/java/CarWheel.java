import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class CarWheel {

    private final JavaCSG csg;
    private final int diameter, width;

    public CarWheel(JavaCSG csg, int diameter, int width) {
        this.csg = csg;
        this.diameter = diameter;
        this.width = width;
    }

    public Geometry3D generate() {
        Geometry3D circle = csg.cylinder3D(diameter, width, 360, true);
        Geometry3D circleCenter = csg.cylinder3D(diameter / 2.0, width + 10, 360, true);
        Geometry3D shape = csg.difference3D(circle, circleCenter);
        return csg.rotate3DY(csg.degrees(90)).transform(shape);
    }

    public Geometry3D generateWithTranslate(int x, int y, int z) {
        Geometry3D generated = generate();
        return csg.translate3D(x, y, z).transform(generated);
    }
}