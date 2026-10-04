/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package online.examination.syatem;

import java.util.Scanner;

/**
 *
 * @author Jaina
 */
public class OnlineExaminationSyatem {
    static class InvalidStudentIDException extends Exception {
        public InvalidStudentIDException(String message) {
            super(message);
        }
    }

    static class InvalidQuestionNumberException extends Exception {
        public InvalidQuestionNumberException(String message) {
            super(message);
        }
    }

    static class InvalidAnswerException extends Exception {
        public InvalidAnswerException(String message) {
            super(message);
        }
    }

    static class ExaminationTimeExpiredException extends Exception {
        public ExaminationTimeExpiredException(String message) {
            super(message);
        }
    }

    static class DuplicateSubmissionException extends Exception {
        public DuplicateSubmissionException(String message) {
            super(message);
        }
    }

    static boolean submitted = false;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String validStudentID = "ST101";

        String[] questions = {
            "Which language is used for Android development?",
            "Which keyword is used to inherit a class in Java?",
            "Which data type stores true or false?",
            "Which symbol is used to end a Java statement?"
        };

        String[][] options = {
            {"A. HTML", "B. Java", "C. CSS", "D. SQL"},
            {"A. implements", "B. extends", "C. inherits", "D. super"},
            {"A. int", "B. char", "C. boolean", "D. float"},
            {"A. :", "B. .", "C. ,", "D. ;"}
        };

        char[] correctAnswers = {'B', 'B', 'C', 'D'};

        int score = 0;

        // Examination time limit: 60 seconds
        long startTime = System.currentTimeMillis();
        long timeLimit = 5 * 60 * 1000;
        try {

            // LOGIN
            System.out.println("=================================");
            System.out.println("     ONLINE EXAMINATION SYSTEM");
            System.out.println("=================================");

            System.out.print("Enter Student ID: ");
            String studentID = sc.nextLine();

            if (!studentID.equals(validStudentID)) {
                throw new InvalidStudentIDException(
                    "Invalid Student ID! Please enter a valid ID."
                );
            }

            System.out.println("Login successful!");
            System.out.println("Student ID: " + studentID);
            System.out.println("---------------------------------");

            // ANSWER QUESTIONS
            for (int i = 0; i < questions.length; i++) {

                // Check examination time
                long elapsedTime = System.currentTimeMillis() - startTime;

                if (elapsedTime >= timeLimit) {
                    throw new ExaminationTimeExpiredException(
                        "Examination time has expired!"
                    );
                }

                System.out.println("\nQuestion " + (i + 1));
                System.out.println(questions[i]);

                for (String option : options[i]) {
                    System.out.println(option);
                }

                // Question number validation
                System.out.print("Enter question number: ");
                int questionNumber = sc.nextInt();

                if (questionNumber < 1 || questionNumber > questions.length) {
                    throw new InvalidQuestionNumberException(
                        "Invalid question number! Enter a number from 1 to 4."
                    );
                }

                // Answer validation
                System.out.print("Enter your answer (A/B/C/D): ");
                char answer = Character.toUpperCase(sc.next().charAt(0));

                if (answer != 'A' && answer != 'B'
                        && answer != 'C' && answer != 'D') {

                    throw new InvalidAnswerException(
                        "Invalid answer! Please enter A, B, C, or D."
                    );
                }

                if (answer == correctAnswers[questionNumber - 1]) {
                    score++;
                }

                System.out.println("Answer recorded successfully.");
            }

            // SUBMISSION
            submitExam();

            System.out.println("\n=================================");
            System.out.println("       EXAMINATION RESULT");
            System.out.println("=================================");
            System.out.println("Student ID : " + studentID);
            System.out.println("Score      : " + score + "/" + questions.length);
            System.out.println("Examination submitted successfully!");

            // Demonstrate duplicate submission exception
            System.out.print("\nDo you want to submit again? (Y/N): ");
            sc.nextLine();
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                submitExam();
            }

        } catch (InvalidStudentIDException e) {
            System.out.println("\nERROR: " + e.getMessage());

        } catch (InvalidQuestionNumberException e) {
            System.out.println("\nERROR: " + e.getMessage());

        } catch (InvalidAnswerException e) {
            System.out.println("\nERROR: " + e.getMessage());

        } catch (ExaminationTimeExpiredException e) {
            System.out.println("\nERROR: " + e.getMessage());
            System.out.println("Your examination has been stopped.");

        } catch (DuplicateSubmissionException e) {
            System.out.println("\nERROR: " + e.getMessage());
        }

        sc.close();
    }

    // Method for submitting examination
    static void submitExam() throws DuplicateSubmissionException {

        if (submitted) {
            throw new DuplicateSubmissionException(
                "Examination has already been submitted!"
            );
        }

        submitted = true;
        System.out.println("\nExamination submitted successfully!");
    }
}

        // TODO code application logic here
    
    

