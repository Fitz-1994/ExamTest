package inner.impl;

import inner.interf.Man;

public class Test {
    public static void main(String[] args) {
        Home home = new Home();
        Man man = home.getMan();

        man.readBook();
    }
}
