import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This program is used to store students grades and get statistics of the grades list");
        GradeList grades = new GradeList();
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning) {
            int size = grades.getGradesListSize();
            System.out.println("Choose your option by inputting an integer: \n 1. Add new grade \n 2. Get average of all grades \n 3. Get the highest grade \n 4. Get the lowest grade \n 5. Exit");
            System.out.print("Your option: ");
            int option = input.nextInt();
            switch (option) {
                case 1 -> { System.out.print("Provide the grade: ");
                    double newGrade = input.nextDouble();
                    grades.addNewGrade(newGrade); }
                case 2 -> { String result = ((size == 0) ? "There is no grades." : "The average of grades is: " + grades.getAverageOfGrades());
                    System.out.println(result); }
                case 3 -> { String result = ((size == 0) ? "There is no grades." : "The highest grade in the list is: " + grades.getHighestGrade());
                    System.out.println(result); }
                case 4 -> { String result = ((size == 0) ? "There is no grades." : "The lowest grade in the list is: " + grades.getLowestGrade());
                    System.out.println(result); }
                case 5 -> isRunning = false;
                default -> System.out.println("Provided option doesn't exist.");
            }
        }
    }
}