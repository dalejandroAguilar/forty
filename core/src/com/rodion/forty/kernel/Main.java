package com.rodion.forty.kernel;

public class Main {

    public static void main(String[] args) throws Exception {

        Player j1=new Player();
        Player j2=new Player();
        Player j3=new Player();
        Player j4=new Player();
        Team e1=new Team(j1,j2);
        Team e2=new Team(j3,j4);
        Game j=new Game(e1,e2);
        System.out.println("baraja");
        j.getMazo().imprimir();
        System.out.println("baraja 1");
        j1.getHand().imprimir();
        System.out.println("baraja 2");
        j2.getHand().imprimir();
    }
}
