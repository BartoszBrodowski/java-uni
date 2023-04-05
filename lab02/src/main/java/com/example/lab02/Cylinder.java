package com.example.lab02;
public class Cylinder {
    private double cylinderBaseRadius;
    private double cylinderHeight;
    public Cylinder(double radius, double height) {
        cylinderBaseRadius = radius;
        cylinderHeight = height;
    }

    public Cylinder() {

    }

    public void setRadius(float num) {
        cylinderBaseRadius = num;
    }

    public void setHeight(float num) {
        cylinderHeight = num;
    }

    public double getRadius() {
        return cylinderBaseRadius;
    }

    public double getHeight() {
        return cylinderHeight;
    }

    public double calculateBaseSurfaceArea() {
        return Math.PI * Math.pow(cylinderBaseRadius, 2);
    }

    public double calculateSideSurfaceAres() {
        return 2 * Math.PI * cylinderBaseRadius * cylinderHeight;
    }

    public double calculateTotalSurfaceArea() {
        return 2 * calculateBaseSurfaceArea() * calculateSideSurfaceAres();
    }

    public double calculateVolume() {
        return calculateBaseSurfaceArea() * cylinderHeight;
    }
}
