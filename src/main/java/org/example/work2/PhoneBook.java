package work2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phone){
        if(!phoneBook.containsKey(surname)){
            phoneBook.put(surname,new ArrayList<>());
        }
        phoneBook.get(surname).add(phone);
    }

    public List<String>get(String surname){
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();

        pb.add("Васильев", "+79995555555");
        pb.add("Васильев","+79053213344");
        pb.add("Иванов","+79995544433");
        pb.add("Кузнецов","+79933332234");
        pb.add("Шевченко","+79933212244");

        System.out.println("Телефоны Васильева: " + pb.get("Васильев"));
        System.out.println("Телефоны Иванова: " + pb.get("Иванов"));
        System.out.println("Телефоны Кузнецова: " + pb.get("Кузнецов"));
        System.out.println("Телефоны Рябинова: " + pb.get("Рябинов"));


    }

}
