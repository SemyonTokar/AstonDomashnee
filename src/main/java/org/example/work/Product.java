package work;

public class Product {
    String name;
    int dateProduct;
    String manufacturer;
    String countryOfOrigin;
    double price;
    boolean bookingStatus;

    public Product(String name, int dateProduct, String manufacturer,
                   String countryOfOrigin, double price,
                   boolean bookingStatus){
        this.name = name;
        this.dateProduct = dateProduct;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public void displayInfo(){
        System.out.println("--- Информация о товаре ---");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + dateProduct);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования покупателем: " + bookingStatus);
    }
    public String getName(){return name;}
    public int getDateProduct(){return dateProduct;}
    public String getManufacturer(){return manufacturer;}
    public String getCountryOfOrigin(){return countryOfOrigin;}
    public double getPrice(){return price;}
    public boolean isBookingStatus(){return bookingStatus;}

    public void setName(String name){this.name = name;}
    public void setDateProduct(int dateProduct){this.dateProduct = dateProduct;}
    public void setManufacturer(String manufacturer){this.manufacturer = manufacturer;}
    public void setCountryOfOrigin(String countryOfOrigin){this.countryOfOrigin = countryOfOrigin;}
    public void setPrice(double price){this.price = price;}
    public void setBookingStatus(boolean bookingStatus){this.bookingStatus = bookingStatus;}

    Product[] manyProduct = new Product[5];
}

