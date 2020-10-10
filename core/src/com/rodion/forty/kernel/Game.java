package com.rodion.forty.kernel;

public class Game {

    private Team equipo1;
    private Team equipo2;
    private Deck mazo;

    public Team getEquipo1() {
        return equipo1;
    }

    public Team getEquipo2() {
        return equipo2;
    }

    public Deck getMazo() {
        return mazo;
    }

    public Deck getMesa() {
        return mesa;
    }

    private Deck mesa;
    private final boolean parejas;
    private int jugadorTurno;
    private Card cartaAnteriro;

    public Game(Team e1, Team e2) throws Exception {
        if(e1.isEsPareja() == e2.isEsPareja()){
            parejas=e1.isEsPareja();
            this.equipo1=e1;
            this.equipo2=e2;
            mazo= Deck.nuevaBaraja();
            mesa=new Deck();
            this.repartir();
        }
        else
            throw new Exception("Los equipos no tienen los mismos jugadores");
    }

    private void repartir(){
        mazo.transferir(5,equipo1.getJugador1().getHand());
        mazo.transferir(5,equipo2.getJugador1().getHand());
        if(parejas){
            mazo.transferir(5,equipo1.getJugador2().getHand());
            mazo.transferir(5,equipo2.getJugador2().getHand());
        }
    }

//todo:Cambiar equipo a array List ???
    //todo:Trio, cuato caidas (Jugadas Especiales)
    //todo:configurar gana 40:evento??
    //todo: ultima caida
    public void nextTurn(Card a){
        Player jug=obtenerJugador();
        Team eq=obtenerEquipo();
        int resultado=jug.turno(a,this.mazo);
        if(resultado!=0){
            eq.incrementarCartas(resultado);
            if(a.getPip()==cartaAnteriro.getPip())
                eq.incrementarPuntaje(2);
            else if(this.mazo.getDeck().size()==0 && eq.getPuntaje()>38){
                eq.incrementarPuntaje(2);
            }
        }
    }

    //todo:Mejorar esto
    private Team obtenerEquipo(){
        Team eq=null;
        if(this.jugadorTurno==1 || this.jugadorTurno==3)
            eq=equipo1;
        if(this.jugadorTurno==2 || this.jugadorTurno==4)
            eq=equipo2;
        return eq;
    }

    private Player obtenerJugador(){
        Player jug=null;
        if(this.jugadorTurno==1)
            jug=equipo1.getJugador1();
        if(this.jugadorTurno==2)
            jug=equipo2.getJugador1();
        if(this.jugadorTurno==3)
            jug=equipo1.getJugador2();
        if(this.jugadorTurno==4)
            jug=equipo2.getJugador2();
        return jug;
    }
}
