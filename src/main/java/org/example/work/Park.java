package work;

public class Park {
    private String namePark;
    private String city;

    public Park(String namePark, String city){
        this.namePark = namePark;
        this.city = city;
    }

    public class Attraction{
        private String name;
        private String timeWork;
        private double price;

        public Attraction(String name,String timeWork, double price){
            this.name = name;
            this.timeWork = timeWork;
            this.price = price;
        }

        public void displayInfo(){
            System.out.println("Аттракцион: " + name );
            System.out.println("Время работы: " + timeWork);
            System.out.println("Стоимость: " + price + " руб.");
        }

        public String getName(){return name;}
        public String getTimeWork(){return timeWork;}
        public double getPrice(){return price;}

    }
        public String getNamePark(){return namePark;}
        public String getCity(){return city;}
}
