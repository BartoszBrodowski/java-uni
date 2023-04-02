import java.util.Scanner;

public class Main {

    Cylinder myCylinder = new Cylinder(5, 10);
    public static void main(String[] args) {
        System.out.println("This program is used to create a Cylinder instance and calculate its properties.");
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        Cylinder myCylinder = new Cylinder();
        while (isRunning) {
            System.out.println("Choose your option: \n 1. Get the base surface area \n 2. Get the side surface area \n 3. Get the total surface area \n 4. Get the volume \n 5. Show values of radius and height \n 6. Exit");
            System.out.print("Your option: ");
            int option = input.nextInt();
            if (option == 6) {
                isRunning = false;
                break;
            }
            System.out.print("Enter the radius of the cylinder: ");
            double radius = input.nextDouble();
            System.out.print("Enter the height of the cylinder: ");
            double height = input.nextDouble();
            myCylinder.setCylinderRadius(radius);
            myCylinder.setCylinderHeight(height);
            switch (option) {
                case 1:
                    System.out.println("The base surface area of cylinder is: " + myCylinder.getBaseSurfaceArea());
                    break;
                case 2:
                    System.out.println("The side surface area of cylinder is: " + myCylinder.getSideSurfaceArea());
                    break;
                case 3:
                    System.out.println("The total surface area of cylinder is: " + myCylinder.getTotalSurfaceArea());
                    break;
                case 4:
                    System.out.println("The volume of cylinder is: " + myCylinder.getVolume());
                    break;
                case 5:
                    System.out.println("The radius of cylinder is: " + myCylinder.getCylinderRadius() + " and the height of cylinder is: " + myCylinder.getCylinderHeight());
                    break;
            }
        }
    }
}
