package com.example;


public interface Visitor {
    void visit (Car c);
    void visit (Electronics e);
    void visit (Chocolate c);

}

