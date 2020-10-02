package com.rodion.forty.kernel;

public class Team {

    private Player jugador1;
    private Player jugador2;
    private int puntaje;
    private int cartasGanadas;
    private final boolean esPareja;

    public Player getJugador1() {
        return jugador1;
    }

    public Player getJugador2() {
        return jugador2;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getCartasGanadas() {
        return cartasGanadas;
    }

    public Team(Player j1){
        puntaje=0;
        cartasGanadas=0;
        jugador1=j1;
        jugador2=null;
        esPareja=false;
    }

    public Team(Player j1, Player j2){
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
