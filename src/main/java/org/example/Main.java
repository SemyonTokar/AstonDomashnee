package org.example;

import java.util.Arrays;

public class Main {

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 2;
        int b = 1;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 4;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else if (value > 100) {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 1;
        int b = 2;

        if (a >= b) {
            System.out.println("a >= b");
        } else System.out.println("a < b");
    }

    public static boolean checkingTheAmount(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        return false;
    }

    public static void checkingPositive(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else System.out.println("Отрицательное число");
    }

    public static boolean checkingBoolPositive(int a) {
        if (a < 0) {
            return true;
        } else return false;
    }

    public static void stringAndNumber(String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else return false;
    }

    public static void task10Massiv() {
        int[] massivInt = {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1};

        System.out.println("До: " + Arrays.toString(massivInt));

        for (int i = 0; i < massivInt.length; i++) {
            if (massivInt[i] == 0) {
                massivInt[i] = 1;
            } else {
                massivInt[i] = 0;
            }
        }

        System.out.println("После: " + Arrays.toString(massivInt));
    }

    public static void task11Massiv() {
        int[] massivInteger = new int[100];

        for (int i = 0; i < massivInteger.length; i++) {
            massivInteger[i] = i + 1;
        }

        System.out.println("Первые 10: " + Arrays.toString(Arrays.copyOfRange(massivInteger, 0, 10)));
        System.out.println("Последние 10: " + Arrays.toString(Arrays.copyOfRange(massivInteger, 90, 100)));
    }

    public static void task12Massiv() {
        int[] massivIntTask = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("До: " + Arrays.toString(massivIntTask));

        for (int i = 0; i < massivIntTask.length; i++) {
            if (massivIntTask[i] < 6) {
                massivIntTask[i] = massivIntTask[i] * 2;
            }
        }
        System.out.println("После: " + Arrays.toString(massivIntTask));
    }

    public static void task13Massiv() {
        int size = 5;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static int[] task14Method(int len, int initialValue){
        int[] arr = new int[len];

        for(int i = 0; i < arr.length; i++){
            arr[i] = initialValue;
        }
        return arr;
    }

    public static void task14Massiv(){
        int[] arr1 = task14Method(14,13);
        int[] arr2 = task14Method(4, 10);

        System.out.println("len = 14, initialValue = 13: " + Arrays.toString(arr1));
        System.out.println("len = 4, initialValue = 10: " + Arrays.toString(arr2));
    }



    public static void main(String[] args) {
        printThreeWords();

        checkSumSign();

        printColor();

        compareNumbers();

        System.out.println(checkingTheAmount(2, 4));

        checkingPositive(2);

        System.out.println(checkingBoolPositive(1));

        stringAndNumber("text", 3);

        System.out.println(isLeapYear(4));

        task10Massiv();

        task11Massiv();

        task12Massiv();

        task13Massiv();

        task14Massiv();
    }
}