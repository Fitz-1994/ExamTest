package inner.impl;

import inner.interf.Man;

public class Home {
    private class Boy implements Man {
        @Override
        public void readBook() {
            System.out.println("This boy is reading book");
        }
    }
    public Man getMan(){
        return new Boy();
    }
}
