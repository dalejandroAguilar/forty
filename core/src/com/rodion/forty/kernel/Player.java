package com.rodion.forty.kernel;

import java.util.ArrayList;

public class Player {

    private Deck mano;

    public Player(){
        mano=new Deck();
    }

    public Deck getHand() {
        return mano;
    }

    public int turno(Card c, Deck mazo){
        int retorno=0;
        int valor=c.getPip().getValue();
        ArrayList<Deck> opciones=mazo.buscarSuma(valor);
        Deck aux= mazo.buscarEscalera(valor);
        if (aux != null){
            opciones.add(aux);
        }
        if(opciones.size()==0){
            mazo.añadirCarta(c);
        }
        else if(opciones.size()==1){
            retorno=opciones.get(0).getDeck().size();
            for (Card i:opciones.get(0).getDeck()) {
                mazo.quitarCarta(i);
            }
        }
        else {
            int indice=0;
            int cartas=0;
            for (Deck m:opciones) {
                if(m.getDeck().size()>cartas){
                    cartas=m.getDeck().size();
                    indice=opciones.indexOf(m);
                }
            }
            retorno=opciones.get(indice).getDeck().size();
            for (Card i:opciones.get(indice).getDeck()) {
                mazo.quitarCarta(i);
            }
        }
        this.mano.quitarCarta(c);
        return retorno;
    }
}
