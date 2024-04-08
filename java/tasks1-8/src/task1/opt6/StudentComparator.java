package task1.opt6;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.grade.compareTo(o2.grade);
    }
}
