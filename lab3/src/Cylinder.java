public class Cylinder {
    private double radius;
    private double height;

    public void setCylinderRadius(double num) {
        radius = num;
    }
    public void setCylinderHeight(double num) {
        height = num;
    }

    public double getCylinderRadius() {
        return radius;
    }

    public double getCylinderHeight() {
        return height;
    }

    public Cylinder(double cylinderRadius, double cylinderHeight) {
        radius = cylinderRadius;
        height = cylinderHeight;
    }

    public Cylinder() {

    }

    public double getBaseSurfaceArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getSideSurfaceArea() {
        return 2 * Math.PI * Math.pow(radius, 2);
    }

    public double getTotalSurfaceArea() {
        return 2 * getBaseSurfaceArea() + getSideSurfaceArea();
    }

    public double getVolume() {
        return getBaseSurfaceArea() * height;
    }
}