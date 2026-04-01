package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "2", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try{
            int result = sum2DArray(arr);
            System.out.println("Сумма: " + result);
        }catch (MyArraySizeException e){
            System.out.println("Проблема с размером: " + e.getMessage());
        }catch (MyArrayDataException e){
            System.out.println("Проблема с данными: " + e.getMessage());
        }
    }

    public static void testIndexOutOfBounds(){
        int[] numbers = new int[5];

        try{
            int x = numbers[10];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Поймали выход за границы. ");
            System.out.println("Детали: " + e.getMessage());
        }
    }

    static class MyArrayDataException extends Exception {
        public MyArrayDataException(int row, int col, String value) {
            super(String.format("Ошибка в ячейке [%d][%d]. Значение не является числом", row, col, value));
        }
    }

        static class MyArraySizeException extends Exception {
            public MyArraySizeException(String message) {
                super(message);
            }
        }

        public static int sum2DArray(String[][] arr) throws MyArrayDataException, MyArraySizeException {

            if (arr == null) {
                throw new MyArraySizeException("Массив равен null");
            }

            if (arr.length != 4) {
                throw new MyArraySizeException("Строк не 4 а: " + arr.length);
            }

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null || arr[i].length != 4) {
                    throw new MyArraySizeException("В строке: " + i + " неверное количество столбцов");
                }
                for (int j = 0; j < arr[i].length; j++) {
                    try {
                        sum += Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j, arr[i][j]);
                    }
                }
            }
            return sum;
        }



}
