/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import Logica.Exceptions.MesaException;
/**
 *
 * @author bsout
 */
public class Mesa {
    
    private int numero;
    private int cantidadJugadores;
    private ArrayList<Jugador> jugadores;
    private double apuestaBase;
    private EstadoMesa EstadoMesa;
    private double porcentajeComision ;
    private Mano mano;
    private ArrayList<Carta> cartas;

    public Mesa(int cantidadJugadores, double apuestaBase, double porcentajeComision) {
        this.cantidadJugadores = cantidadJugadores;
        this.apuestaBase = apuestaBase;
        this.porcentajeComision = porcentajeComision;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public double getApuestaBase() {
        return apuestaBase;
    }

    public void setApuestaBase(double apuestaBase) {
        this.apuestaBase = apuestaBase;
    }

    public EstadoMesa getEstadoMesa() {
        return EstadoMesa;
    }

    public void setEstadoMesa(EstadoMesa EstadoMesa) {
        this.EstadoMesa = EstadoMesa;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public Mano getMano() {
        return mano;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    
    
    
    public void ActualizarEstado(){
        
    }
    public void EliminarJugador(){
        
    }
    public void IniciarJuego(){
        
    }
    public void FinalizarJuego(){
        
    }
    public void CalcularGanador(){
        
    }

    
    
    
    public void Validar()throws MesaException{
        if(cantidadJugadores<2||cantidadJugadores>5)throw new MesaException("Cantidad de jugadores no valida");
        if(apuestaBase<1)throw new MesaException("Apuesta base inválida");
        if(porcentajeComision<1||porcentajeComision>50)throw new MesaException("Comision invalida");
    }
   }
