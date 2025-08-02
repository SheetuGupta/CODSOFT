import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of subjects");
        int sub = sc.nextInt();

        int[] marks = new int[sub];
        int totalMarks = 0;
        for (int i = 0; i < sub; i++) {
            System.out.print("Enter marks for subject " + (i + 1));
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

       double average =  (double)totalMarks / sub;
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);
        
        sc.close();
    }
}

