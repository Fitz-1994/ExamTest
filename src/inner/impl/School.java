package inner.impl;

import inner.interf.Man;

public class School {
    protected class Student implements Man{
        @Override
        public void readBook() {
            System.out.println("Student read books");
        }
    }
    protected Man man(){
        return new Student();
    }
}
