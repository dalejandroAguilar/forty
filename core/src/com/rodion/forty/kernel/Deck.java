package com.rodion.forty.kernel;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void añadirCarta(Card c){
        deck.add(c);
    }

    private ArrayList<Card> deck;

    public Deck(){
        this.deck=new ArrayList<>();
    }

    private Deck(ArrayList<Card> l){
        this.deck=l;
    }

    public Card buscarPar(int valor){
        for (Card c:this.deck) {
            if (c.getNumero().getValue()==valor){
                return c;
            }
        }
        return null;
    }

    public Deck buscarEscalera(int valor){
        ArrayList<Card> ret=new ArrayList<>();
        for (int i = valor; i < 11; i++) {
            Card c=buscarPar(valor);
            if(c!=null)
                ret.add(c);
            else
                break;
        }
        return new Deck(ret);
    }

    public ArrayList<Deck> buscarSuma(int valor){
        ArrayList<Deck> retorno=new ArrayList<>();
        for (Card c:this.deck) {
            int valor1=c.getNumero().getValue();
            if( valor1<4){
                for (Card comp:this.deck) {
                    int valor2=comp.getNumero().getValue();
                    if(valor1!=valor2 && valor1+valor2==valor){
                        Deck a = buscarEscalera(valor+1);
                        a.deck.add(c);
                        a.deck.add(comp);
                        retorno.add(a);
                    }
                }
            }
        }
        return retorno;
    }


    public void transferir(int i, Deck b){
        for (int j = 0; j < i; j++) {
            Card aux=this.deck.get(0);
            b.deck.add(aux);
            this.deck.remove(0);
        }
    }

    public static Deck nuevaBaraja(){
        ArrayList<Card> b=new ArrayList<>();
        for (Pip n: Pip.values()) {
            for (Suit p: Suit.values()) {
                Card aux=new Card(n,p);
                b.add(aux);
            }
        }
        Collections.shuffle(b);
        return new Deck(b);
    }

    public void quitarCarta(Card c){
        this.deck.remove(c);
    }

    public void imprimir(){
        for (Card c:this.deck) {
            System.out.println(c.toString());
        }
    }
}
