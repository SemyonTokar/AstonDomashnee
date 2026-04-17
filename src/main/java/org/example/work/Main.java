package work;

public class Main {
    public static void main(String[] args) {
        Product[] manyProduct = new Product[3];
        Product product1 = new Product("Беспроводные наушники «SoundMax Pro» с активным шумоподавлением",22022002,
                "SoundMax Pro","Китай",2000,true);

        product1.displayInfo();
        System.out.println();

        manyProduct[0] = new Product("Телевизор",220220000,"Пукат","Франция",2000,true);
        manyProduct[1] = new Product("Телефон",21012001,"apple","Америка",80000,false);
        manyProduct[2] = new Product("Гитара",1998,"Струна","Россия",2000,true);

        System.out.println("Каталог товаров:\n");
        for (Product product:manyProduct){
            product.displayInfo();
        }

        Park park = new Park("Парк для детей", "Краснодар");
        System.out.println("Парк: " + park.getNamePark() + "\n");

        Park.Attraction twister = park.new Attraction("Крутилка","c 8:00 до 20:00", 250);
        Park.Attraction train = park.new Attraction("Поезд","с 7:00 до 19:00",200);
        Park.Attraction ferrisWheel = park.new Attraction("Колесо обзрения","с 10:00 до 20:00",500);

        System.out.println("Аттракционы:\n");
        twister.displayInfo();
        train.displayInfo();
        ferrisWheel.displayInfo();

    }
}