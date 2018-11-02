package com.blevast.motion.ui;

import java.util.ArrayList;
import java.util.List;

public class JavaClass {

    /**
     *
     */
    public void sum(){

        //A supertype relationship
        //This is basically means list of
        //any parent class for sTring
        List<? super String> list = new ArrayList<>();
        List<Object> o = new ArrayList<>();

        //Subtype relationship
        //This basically means
        //list of any subclass to Objects
        List<? extends Object> s = new ArrayList<>();
        List<String> objects = new ArrayList<>();

        s = objects;
        list = o;

        Object ot = list.get(0);



        //
        //objects = list;
        //
    }
}
