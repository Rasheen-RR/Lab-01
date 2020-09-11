import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGrade {

     public static void main(String[] args) {

        String name = "";
        int grade = 0;
        String userSelection = "";
        boolean restart = true;

        Scanner sc = new Scanner(System.in);


        while(true){

            //Check if it needs to reiterate the whole process if the grade was entered incorrectly this part will not be displayed
            if(restart) {
                System.out.println("Enter student name:");
                name = sc.nextLine();

                System.out.println("Enter student grade:");
            }

            try {

                grade = sc.nextInt();
                System.out.println(String.format("Student Name: %s , Student Grade: %s%% , The letter grade for %s%% is %s",
                        name,grade,grade,checkGrade(grade)));

                // The previous input was taken using sc.nextInt() this only reads int value which will result in the sc.nextLine() receiving a "/n" for the input
                // which will mess with the next input user provides.
                sc.nextLine();

                // Check if user wants to quit or keep going
                System.out.println("Enter n to check  another record or enter anyother value to exit.");
                userSelection = sc.nextLine();

                // If condition to execute the users selection.
                if(userSelection.equals("n") || userSelection.equals("N") ){
                    // Set restard to true to restart the whole process
                    restart = true;
                    continue;
                }else{
                    // Close the scanner and end the application
                    sc.close();
                    return;
                }
            }catch (InputMismatchException ex){
                System.out.println("Please enter a valid student grade:");
                // Set restart to false so that the name won't be promted again
                restart = false;

                // sc.nextLine() used instead of continue to reiterate only once
                // if continue is used it will be in an endless loop
                sc.nextLine();
            }
        }
    }


    // Method to check grades
    // static used as non static methods cannot be referenced in the main method which is  static 
    public static String checkGrade(int grade){

        String gradeString = "F";

        // Set grade string according to grade.
        if(grade >= 80){
            gradeString = "A";
        }else if(grade >= 70){
            gradeString = "B";
        }else if(grade >= 60){
            gradeString = "C";
        }else if(grade >= 50){
            gradeString = "D";
        }

        return  gradeString;
    }
}
