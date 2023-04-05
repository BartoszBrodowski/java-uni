package com.example.power;
import java.util.Scanner;

public class Main {
    public static int powerOfTwo(int num) {
        int result = 1;
        for(int i=0;i<num;i++){
            result = result * 2;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("This program takes a number n input and outputs the nth power of 2");
        Scanner scanner = new Scanner(System.in);
        boolean runProgram = true;
        while (runProgram) {
            System.out.print("Input an exponent: ");
            int number = scanner.nextInt();
            int result = powerOfTwo(number);
            System.out.println("The result of powerOfTwo function is: " + result);
            System.out.println("If you want to exit the program, input 1, else input any number");
            int runInput = scanner.nextInt();
            if (runInput == 1) {
                runProgram = false;
            }
        }
        scanner.close();
    }
}
