package org.example;

public class Park {
    private String названиеПарка;
    private String город;

    public Park(String названиеПарка, String город){
        this.названиеПарка = названиеПарка;
        this.город = город;
    }

    public static class Аттракцион{
        private String название;
        private String времяРаботы;
        private double стоимость;

        public Аттракцион(String название,String времяРаботы, double стоимость){
            this.название = название;
            this.времяРаботы = времяРаботы;
            this.стоимость = стоимость;
        }

        public void вывестиИнформацию(){
            System.out.println("()0()0() " + название + " ()0()0()");
            System.out.println("Время работы: " + времяРаботы);
            System.out.println("Стоимость: " + стоимость + " руб.");
        }

        public String getНазвание(){return название;}
        public String getВремяРаботы(){return времяРаботы;}
        public double getСтоимость(){return стоимость;}


        public static Аттракцион добавитьАттракцион(String название, String времяРаботы,double стоимость){
            return new Аттракцион(название,времяРаботы,стоимость);
        }
    }
        public String getНазваниеПарка(){return названиеПарка;}
        public String getГород(){return город;}
}
