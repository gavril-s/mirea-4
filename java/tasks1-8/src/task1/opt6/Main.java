package task1.opt6;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[] {
            new Student("Ivan", 100),
            new Student("Dima", 50),
            new Student("Vika", 0)
        };

        Comparator comparator = new StudentComparator();
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length; j++) {
                System.out.format(
                        "%s compareTo %s -> %2d\n",
                        students[i].name,
                        students[j].name,
                        comparator.compare(students[i], students[j])
                );
            }
        }
    }
}