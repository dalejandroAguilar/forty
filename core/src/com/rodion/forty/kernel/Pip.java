package com.rodion.forty.kernel;

public enum Pip {
    Ace(1), Two(2), Three(3), Four(4) , Five(5) , Six(6),
    Seven(7), Jack(8), Queen(9), King(10);
    public final int value;
    public final int index;

    private Pip(int value){
        this.value=value;
        this.index = value - 1;
    }

    public int getValue() {
        return value;
    }

}
