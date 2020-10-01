package com.rodion.forty.kernel;

import java.util.ArrayList;

public class Equipo {

    private Jugador jugador1;
    private Jugador jugador2;
    private int puntaje;
    private int cartasGanadas;
    private final boolean esPareja;

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getCartasGanadas() {
        return cartasGanadas;
    }

    public Equipo(Jugador j1){
        puntaje=0;
        cartasGanadas=0;
        jugador1=j1;
        jugador2=null;
        esPareja=false;
    }

    public Equipo(Jugador j1, Jugador j2){
        puntaje=0;
        cartasGanadas=0;
        jugador1=j1;
        jugador2=j2;
        esPareja=true;
    }

    public boolean isEsPareja() {
        return esPareja;
    }

    public void incrementarPuntaje(int valor){
        this.puntaje+=valor;
    }

     public void incrementarCartas(int valor){
        this.cartasGanadas+=valor;
     }

     public void contar(){
        if(this.puntaje<30 && this.cartasGanadas>=19){
            int sumar=this.cartasGanadas-19+5;
            if(sumar%2!=0)
                sumar+=1;
            this.incrementarPuntaje(sumar);
        }
     }
}
