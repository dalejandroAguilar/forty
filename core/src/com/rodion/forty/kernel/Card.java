package com.rodion.forty.kernel;

public class Card {

    private Pip numero;
    private Suit palo;

    public Card(Pip numero, Suit palo){
        this.numero=numero;
        this.palo=palo;
    }

    public Suit getSuit() {
        return palo;
    }

    public Pip getPip() {
        return numero;
    }

    @Override
    public String toString(){
        return numero.name()+' '+palo.name();
    }
}
