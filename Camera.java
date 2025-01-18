public class Camera {
    public double x;
    public double y;
    public double z;
    public Vector3 pointingAt;
    public double fov = 90;
    public Vector3 up = new Vector3(0, 1, 0);
    //clipping planes
    double near = 0.1;
    double far = 10000;
    Camera(double x, double y, double z, Vector3 rotation) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.pointingAt = rotation;
    }
    public Matrix calculateProjectionMatrix(double sw, double sh) {
        double aspectRatio = sw / sh;
        double f = 1 / Math.tan(Math.toRadians(fov) / 2);
        double[][] projectionMatrix = {
            {f / aspectRatio, 0, 0, 0},
            {0, f, 0, 0},
            {0, 0, (far + near) / (near - far), (2 * far * near) / (near - far)},
            {0, 0, -1, 0}
        };
        return new Matrix(projectionMatrix);
    }
}
