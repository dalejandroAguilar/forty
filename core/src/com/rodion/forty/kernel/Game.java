package com.rodion.forty.kernel;

public class Game {

    private Equipo equipo1;
    private Equipo equipo2;
    private Baraja mazo;

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public Baraja getMazo() {
        return mazo;
    }

    public Baraja getMesa() {
        return mesa;
    }

    private Baraja mesa;
    private final boolean parejas;
    private int jugadorTurno;
    private Card cartaAnteriro;

    public Game(Equipo e1, Equipo e2) throws Exception {
        if(e1.isEsPareja() == e2.isEsPareja()){
            parejas=e1.isEsPareja();
            this.equipo1=e1;
            this.equipo2=e2;
            mazo=Baraja.nuevaBaraja();
            mesa=new Baraja();
            this.repartir();
        }
        else
            throw new Exception("Los equipos no tienen los mismos jugadores");
    }

    private void repartir(){
        mazo.transferir(5,equipo1.getJugador1().getMano());
        mazo.transferir(5,equipo2.getJugador1().getMano());
        if(parejas){
            mazo.transferir(5,equipo1.getJugador2().getMano());
            mazo.transferir(5,equipo2.getJugador2().getMano());
        }
    }

//todo:Cambiar equipo a array List ???
    //todo:Trio, cuato caidas (Jugadas Especiales)
    //todo:configurar gana 40:evento??
    //todo: ultima caida
    public void nextTurn(Card a){
        Jugador jug=obtenerJugador();
        Equipo eq=obtenerEquipo();
        int resultado=jug.turno(a,this.mazo);
        if(resultado!=0){
            eq.incrementarCartas(resultado);
            if(a.getNumero()==cartaAnteriro.getNumero())
                eq.incrementarPuntaje(2);
            else if(this.mazo.getDeck().size()==0 && eq.getPuntaje()>38){
                eq.incrementarPuntaje(2);
            }
        }
    }

    //todo:Mejorar esto
    private Equipo obtenerEquipo(){
        Equipo eq=null;
        if(this.jugadorTurno==1 || this.jugadorTurno==3)
            eq=equipo1;
        if(this.jugadorTurno==2 || this.jugadorTurno==4)
            eq=equipo2;
        return eq;
    }

    private Jugador obtenerJugador(){
        Jugador jug=null;
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
