package com.rodion.forty.kernel;

public class Main {

    public static void main(String[] args) throws Exception {

        Jugador j1=new Jugador();
        Jugador j2=new Jugador();
        Jugador j3=new Jugador();
        Jugador j4=new Jugador();
        Equipo e1=new Equipo(j1,j2);
        Equipo e2=new Equipo(j3,j4);
        Game j=new Game(e1,e2);
        System.out.println("baraja");
        j.getMazo().imprimir();
        System.out.println("baraja 1");
        j1.getMano().imprimir();
        System.out.println("baraja 2");
        j2.getMano().imprimir();
    }
}
