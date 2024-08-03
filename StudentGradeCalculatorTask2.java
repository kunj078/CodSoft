import java.util.Scanner;

public class StudentGradeCalculatorTask2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        
        // store marks
        int[] marks = new int[numberOfSubjects];
        
        // check marks : 0 to 100
        for (int i = 0; i < numberOfSubjects; i++) {
            marks[i] = getValidMark(scanner, i + 1);
        }
        
        int totalMarks = calculateTotalMarks(marks);
        
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
        
        char grade = determineGrade(averagePercentage);
        
        displayResults(totalMarks, averagePercentage, grade);        
    }
    
    private static int getValidMark(Scanner scanner, int subjectNumber) {
        int mark;
        while (true) {
            System.out.print("Enter marks for subject " + subjectNumber +": ");
            mark = scanner.nextInt();
            if (mark > 0 && mark <= 100) {
                return mark;
            } else {
                System.out.println("Invalid input. Please enter a mark between 1 and 100.");
            }
        }
    }
    
    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }
    
    private static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }
    
    private static char determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    
    public static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
