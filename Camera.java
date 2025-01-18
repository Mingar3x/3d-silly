public class Camera {
    public double x;
    public double y;
    public double z;
    public Vector3 rotation;
    public double fov = 90;
    Camera(double x, double y, double z, Vector3 rotation) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.rotation = rotation;
    }
}
