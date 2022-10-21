package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void oneMonthCalendar(int tage, int erster) {
        int zeilen;
        if((tage+erster)%7!=0)
            zeilen = (tage/7)+1;
        else
            zeilen = tage/7;

        for (int i = 1; i < erster; i++) {
            System.out.print("   ");
        }

        int count = 1;
        int column = erster;

        for (int a = 0; a < zeilen; a++) {
            while (column <= 7) {
                System.out.printf("%2d ",count);
                if (count == tage){
                    System.out.println();
                    return;
                }
                column++;
                count++;
            }
            column =1;
            System.out.println();
        }
    }

    public static long[] lcg(long seed) {
        long m = ((long) Math.pow(2, 31));
        long a = 1103515245;
        long c = 12345;

        long[] arr1 = new long[10];
        arr1[0] = ((a*seed)+c)%m;

        for (int i = 1; i < 10; i++) {
            arr1[i] = ((a*arr1[i-1])+c)%m;
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        return arr1;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner sc1 = new Scanner(System.in);
        int guess;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Guess number "+i+": ");
            guess = sc1.nextInt();

            if (guess == numberToGuess){
                System.out.println("You won wisenheimer!");
                break;
            }

            if (i == 10){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }

            if (guess > numberToGuess)
                System.out.println("The number AI picked is lower than your guess.");
            if (guess < numberToGuess)
                System.out.println("The number AI picked is higher than your guess.");
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        return random.nextInt(100)+1;
    }

    public static boolean swapArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=arr1[i]-arr2[i];
            arr2[i]=arr2[i]+arr1[i];
            arr1[i]=arr2[i]-arr1[i];
        }
        return true;
    }

    public static String camelCase(String satz) {
        char[] sa = satz.toCharArray();
        if (sa[0] >= 97 && sa[0] <= 122)
            sa[0] -= 32;

        for (int i = 0; i < sa.length; i++) {
            if (i >= 1 && sa[i-1] == ' ' && sa[i] >= 97 && sa[i] <= 122){
                sa[i] -= 32;
            }
            if (i >= 1 && sa[i-1] != ' ' && sa[i] >= 65 && sa[i] <= 90){
                sa[i] += 32;
            }
        }

        for (int i = 0; i < sa.length; i++) {
            if ((sa[i] > 0 && sa[i] <= 64) || (sa[i] >= 91 && sa[i] <= 96) || (sa[i] >= 123 && sa[i] <= 127)){
                sa[i] = 32;
            }
        }
        return String.valueOf(sa).replaceAll(" ","");
    }

    public static int checkDigit(int[] arr1) {
        int gewichtung = 2;
        int sum=0;
        int mod;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i]*(gewichtung+i);
        }
        mod = sum%11;

        if (11-mod==10)
            return 0;
        if (11-mod==11)
            return 5;

        return 11-mod;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        System.out.println("---- Number 1 ----");
        oneMonthCalendar(30,3);
        System.out.println();

        System.out.println("---- Number 2 ----");
        lcg(12345);
        System.out.println();

        System.out.println("---- Number 3 ----");
        guessingGame(randomNumberBetweenOneAndHundred());
        System.out.println();

        System.out.println("---- Number 4 ----");
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] array2 = new int[]{100, 202, 30, 14, 15, 16};
        swapArrays(array1,array2);
        System.out.println();

        System.out.println("---- Number 5 ----");
        camelCase("abc abc abc aBc");
        System.out.println();

        System.out.println("---- Number 6 ----");
        checkDigit(array1);
        System.out.println();
    }
}