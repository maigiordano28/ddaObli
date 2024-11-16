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
import panelCartasPoker.CartaPoker;


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
    private Mazo mazo;
    private boolean mesaEnJuego = false;

    public List<Mano> getManos() {
        return manos;
    }
    
    public boolean EnJuego(){
        return this.mesaEnJuego;
    }

    public void setMesaEnJuego(boolean mesaEnJuego) {
        this.mesaEnJuego = mesaEnJuego;
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
        this.cartas= new ArrayList<Carta>();
        this.mazo = new Mazo();
    }

    public Mazo getMazo() {
        return mazo;
    }

    public int getNumero() {
        return numero;
    }
    
public ArrayList<CartaPoker> obtenerArrayMazoComoCartasPoker() {
        ArrayList<CartaPoker> cartasPoker = new ArrayList<>();
        for (Carta carta : mazo.cartasMazo) {
            cartasPoker.add(carta); // Usando el constructor de CartaPoker
        }
        return cartasPoker;
    }
 
    public ArrayList<CartaPoker> repartirCartas(ArrayList<CartaPoker> cartas){
        
        ArrayList<CartaPoker> cartasPoker = new ArrayList<>();
       
        int i = 0;
        //ArrayList<CartaPoker> cartas = obtenerArrayMazoComoCartasPoker();
       
            while(cartasPoker.size()<5 && i<cartas.size()){

                cartasPoker.add(cartas.get(i));
                i++;
            }
        
return cartasPoker;
   
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
        if(this.obtenerLargoListaJugadores()==this.getCantidadJugadores()){
        
        Fachada.getInstancia().avisar(EventoFachada.ACTIVAR_POKER);
        
        }
        Fachada.getInstancia().avisar(EventoFachada.NUEVO_JUGADOR_MESA);
        
    
    }
    
    public Mano AgregarMano(){
        Mano mano = new Mano();
        manos.add(mano);
        Fachada.getInstancia().avisar(EventoFachada.NUEVA_MANO);
        return mano;
    }
    
    public void ActualizarPozo(boolean bollean ,Double monto){
     if(bollean==true){
     
        pozo+=monto;
     
     }else{
     
     pozo-=monto;
     
     }
     

    }
    
    public void apostar(Double apuesta){
    ActualizarPozo(true,apuesta);
     Fachada.getInstancia().avisar(EventoFachada.NUEVA_APUESTA);
    
    
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
    
    
   
    
    public int obtenerLargoListaJugadores(){
         return this.jugadores.size();
    }

    
    
    public boolean jugadorEnMesa(Jugador jugador){
    boolean ret=false;
    for(Jugador j:jugadores){
    
    if(j.equals(jugador)){
    
     ret=true;
    }
    
    }
    return ret;
    
    
    }
    
    
    
    
    public void PagarLuz(Jugador j){
     
       
        ActualizarPozo(true,apuestaBase);       
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
