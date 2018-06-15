package inner.extend;

import inner.impl.School;
import inner.interf.Man;

public class Grade extends School {
    public Man StudentInGrade(){
        return man();
    }

    public static void main(String[] args) {
        Grade grade = new Grade();
        Man man = grade.StudentInGrade();
        System.out.println(man);
    }
}
