package com.OP13;

public class EmptyItem extends Exception {
    public EmptyItem() {
        super();
    }

    public EmptyItem(String massage) {
        super(massage);
    }

    public EmptyItem(String massage, Throwable cause) {
        super(massage, cause);
    }

    public EmptyItem(Throwable cause) {
        super(cause);
    }
}
