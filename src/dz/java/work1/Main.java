package work1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static work1.University.printStudents;
import static work1.University.removeLow;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> grades1 = Map.of("Математика", 5.0,"История",5.0,"Астрология",5.0);
        Map<String, Double> grades2 = Map.of("Математика", 2.0,"История",2.5,"Астрология",2.3);
        Map<String, Double> grades3 = Map.of("Математика", 3.5,"История",3.5,"Астрология",3.5);

        Student s1 = new Student("Анна", "Группа: 1 ",2, grades1);
        Student s2 = new Student("Вася","Группа: 2 ", 2, grades2);
        Student s3 = new Student("Даша","Группа: 3 ", 3, grades3);

        Set<Student> students = new HashSet<>(Arrays.asList(s1,s2,s3));

        System.out.println("До обработки: ");
        printStudents(students,2);

        removeLow(students);

        System.out.println("После обработки: ");
        printStudents(students,2);
        printStudents(students,3);


    }
}