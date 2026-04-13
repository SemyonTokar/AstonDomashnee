package work1;

import java.util.Set;

public class University {
    public static void removeLow(Set <Student> students) {
        students.removeIf(s -> s.getAverage() < 3.0);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student s: students){
            if (s.getAverage() >= 3.0) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course){
        System.out.println("Студенты " + course + " курса: ");
        boolean found = false;
        for (Student s : students){
            if (s.getCourse() == course){
                System.out.println("- " + s.getName());
                found = true;
            }
        }
        if (!found) System.out.println(" (нет)");
    }

}
