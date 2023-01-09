package com.myTreeSet;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyTreeSet<E> {
    private Leaf<E> root;
    private int size = 0;

    class Leaf<E> {
        private E current = null;
        private Leaf<E> left = null;
        private Leaf<E> right = null;

        Leaf(E o) {
            if (current == null) {
                current = o;
            } else add(o);
        }

        void add(E o) {
            if(current!=null){
                compareTo(o);
            }else{
                current=o;
            }
        }

        private void compareTo(E o) {

        }

    }

    MyTreeSet() {

    }

    public void add(E o) {
        new Leaf<E>(o);
    }
}
