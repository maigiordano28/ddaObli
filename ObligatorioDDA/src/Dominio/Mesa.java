/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Usuario.Jugador;
import java.util.ArrayList;
import Dominio.Exceptions.MesaException;
import java.util.List;
import Dominio.EventoFachada;

/**
 *
 * @author bsout
 */
public class Mesa {
    private static int s_ultNumero=1;
    private int numero;
    private int cantidadJugadores;
    private ArrayList<Jugador> jugadores;
    private double apuestaBase;
    private EstadoMesa EstadoMesa;
    private double porcentajeComision ;
    private List<Mano> manos;
    private Double pozo;

    public List<Mano> getManos() {
        return manos;
    }
    private ArrayList<Carta> cartas;

    public Mesa(int cantidadJugadores, double apuestaBase, double porcentajeComision) {
        this.cantidadJugadores = cantidadJugadores;
        this.apuestaBase = apuestaBase;
        this.porcentajeComision = porcentajeComision;
        this.numero = s_ultNumero++;
        this.jugadores=new ArrayList();
        this.manos = new ArrayList<Mano>();
        this.EstadoMesa = EstadoMesa.abierta;
        this.pozo=0.0;
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

  
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public Double getPozo() {
        return pozo;
    }

    public void setPozo(Double pozo) {
        this.pozo = pozo;
    }
    
    public void AgregarJugador(Jugador jugador){
        
        this.jugadores.add(jugador);
        Fachada.getInstancia().avisar(EventoFachada.NUEVO_JUGADOR_MESA);
        
    
    }
    
    public Mano AgregarMano(){
        Mano mano = new Mano();
        manos.add(mano);
        Fachada.getInstancia().avisar(EventoFachada.NUEVA_MANO);
        return mano;
    }
    
    public void ActualizarPozo(Double monto){
     

        pozo+=monto;
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
    
    public void PagarLuz(Jugador j){
        Fachada.getInstancia().avisar(EventoFachada.NUEVA_INFO);
       
        ActualizarPozo(apuestaBase);
        j.ActualizarSaldo(false, apuestaBase);
       
    }
    
    
    public double TotalApostado(){
        int total=0;
        for(Mano m:manos){
        total+=m.getTotalApostado();
        }
        return total;
    }

 
    
    
    @Override
    public String toString() {
        return "Mesa: " +numero + " - Jugadores Necesarios: " + cantidadJugadores + " - Apuesta Base: " + apuestaBase + " - Jugadores Actuales: "+ jugadores.size()+ " - Mano "+ manos.size()+" - MontoTotal: "+TotalApostado() +" - Comision: "+porcentajeComision +" - Estado: "+ EstadoMesa ;
    }
    
    public void Validar()throws MesaException{
        if(cantidadJugadores<2||cantidadJugadores>5)throw new MesaException("Cantidad de jugadores no valida");
        if(apuestaBase<1)throw new MesaException("Apuesta base inválida");
        if(porcentajeComision<1||porcentajeComision>50)throw new MesaException("Comision invalida");
    }

    public Mesa cambiarEstado() {
       Fachada.getInstancia().avisar(EventoFachada.NUEVO_MESA_INICIADA);
         setEstadoMesa(EstadoMesa.iniciada);
         
         return this;
    }
   }
