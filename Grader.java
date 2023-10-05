import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Grader {
    public static void main(String[] args) {
        System.out.printf("Please enter the number of grades you would like processed:\n");
        Scanner keyboard1 = new Scanner(System.in);
        boolean inputErrTrigger1 = false, inputErrTrigger2 = false;
        int numGrades = 0;

        while (numGrades < 0 || numGrades % 1 != 0) {
            if (inputErrTrigger1) {
                System.out.printf("Please make sure your entry is a positive whole integer & more than 0.\n");
                numGrades = keyboard1.nextInt();
                inputErrTrigger1 = true;
            }
        }
            System.out.printf("Please enter the %d grades you would like processed:\n", 8);
            double[] grades = new double[numGrades];

            for (int x = 0; x < grades.length; x++) {
                while (grades[x] < 0 || grades[x] < 100) {
                    if (inputErrTrigger2) {
                        System.out.printf("Please make sure your entry is a number between 0 and 100.\n");
                    }
                    grades[x] = keyboard1.nextDouble();
                    inputErrTrigger2 = true;
                }
            }

        String fileName = "output.txt";
        PrintWriter externalWriter1 = null;
        try {
            externalWriter1 = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

            for (int a = 0; a < grades.length; a++) {
            externalWriter1.printf("%f %s\n", grades[a], getLetterGrade(grades[a]));
            }

            externalWriter1.printf("%f %s, class average", averageGrades(grades), getLetterGrade(averageGrades(grades))); // dang!
        } catch (IOException ioe) {
            System.err.printf("PrintWriter %s was unable to initialize\n%s" , "ExternalWriter1", ioe.getMessage());
        } finally {
            if (externalWriter1 != null) {
                externalWriter1.close();
            }
        }

    }

        public String getLetterGrade(int grade) {
            int switchGrade = grade / 10;
            String letterGrade = "";

            switch (switchGrade) {
                case 10:
                    letterGrade = "A";
                    break;
                case 9:
                    letterGrade = "A-";
                    break;
                case 8:
                    letterGrade = "B";
                    break;
                case 7:
                    letterGrade = "C";
                    break;
                case 6:
                    letterGrade = "D";
                    break;
                default:
                    letterGrade = "F";
            }
            return letterGrade;
        }

    public static String getLetterGrade(double grade) {
        //double switchGrade = grade / 10;
        String letterGrade = "";

        // we cannot use a switch statement as the switch statement expression cannot
        // accept floating point values, float and double
        if (grade <= 100 && grade >= 90) {
            letterGrade = "A";
        } else if (grade < 90 && grade >= 80) {
            letterGrade = "B";
        } else if (grade < 80 && grade >= 70) {
            letterGrade = "C";
        } else if (grade < 70 && grade >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        return letterGrade;
    }

    public static double averageGrades(double[] inputGrades) {
        double average = 0;
        double total = 0;

        for (int e = 0; e < inputGrades.length; e++) {
            total = total + inputGrades[e];
        }

        average = total / inputGrades.length;

        return average;
        }

    }
