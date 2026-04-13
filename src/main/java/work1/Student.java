package work1;

import java.util.Map;
import java.util.Objects;

public class Student {
     private String name;
     private String group;
     private int course;
     private Map<String, Double> grades;

     public Student(String name, String group, int course, Map<String,Double> grades){
         this.name = name;
         this.group = group;
         this.course = course;
         this.grades = grades;
     }
     public String getName(){return name;}
    public int getCourse(){return course;}
    public Map<String,Double> getGrades(){return grades;}

    public void setCourse(int course){this.course = course;}

    public double getAverage(){
         if (grades.isEmpty())return 0.0;

         double sum = 0;
         for(double grade : grades.values()){
             sum += grade;
         }
         return sum / grades.size();
    }
    @Override
    public boolean equals(Object o){
         if(this == o) return true;
         if (o == null || !(o instanceof Student)) return false;
         Student student = (Student) o;
         return name.equals(student.name);
    }

    public int hashCode(){
         return name.hashCode();
    }

}
