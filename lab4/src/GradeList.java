import java.util.*;

public class GradeList {
    private final ArrayList<Double> gradesList = new ArrayList<>();
    public int getGradesListSize() {
        return gradesList.size();
    }
    public void addNewGrade(double grade) {
        gradesList.add(grade);
    }
    public double getAverageOfGrades() {
        double sum = 0;
        if (gradesList.size() == 0) {
            return sum;
        } else {
            for (double grade : gradesList) {
                sum += grade;
            }
            double average = sum / gradesList.size();
            return average;
        }
    }
    public double getLowestGrade() {
        double lowest = gradesList.get(0);
        for (Double grade : gradesList) {
            if (grade < lowest)
                lowest = grade;
        }
        return lowest;
    }
    public double getHighestGrade() {
        double highest = gradesList.get(0);
        for (Double grade : gradesList) {
            if (grade > highest)
                highest = grade;
        }
        return highest;
    }

}
