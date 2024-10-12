
package Inicio;
import Logica.Fachada;

public class DatosPrueba {

    static void Cargar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
   
    public void precargarUsuarios(){
        Fachada fachada = Fachada.getInstancia();
   fachada.agregarJugador("48392010" ,"abc123","Carlos Gómez" ,5000);
fachada.agregarJugador("29384729" ,"pass123","Lucía Martínez" ,10000);
fachada.agregarJugador("18492048" ,"qwerty","Jorge Pérez" ,7500);
fachada.agregarJugador("39482030" ,"hunter2","María López" ,2500);
fachada.agregarJugador("58493029" ,"clave123","Federico Hernández" ,12000);
fachada.agregarJugador("47381939" ,"mypassword","Ana Fernández" ,8900);
fachada.agregarJugador("38492039" ,"123456","Andrés Rodríguez" ,4600);
fachada.agregarJugador("29382047" ,"password1","Verónica Gutiérrez" ,3200);
fachada.agregarJugador("39204828" ,"letmein","Ricardo Núñez" ,5200);
fachada.agregarJugador("58492030" ,"welcome1","Sofía Ramírez" ,6000);
fachada.agregarJugador("29384829" ,"secret12","Rodrigo Castro" ,8000);
fachada.agregarJugador("59403930" ,"dragonfly","Natalia Vázquez" ,9000);
fachada.agregarJugador("39482349" ,"freedom21","Emilio Benítez" ,11000);
fachada.agregarJugador("58493920" ,"shadow23","Silvia Torres" ,7800);
fachada.agregarJugador("39484939" ,"trustno1","Gabriel Silva" ,6700);
fachada.agregarJugador("29382930" ,"starlord","Elena Cabrera" ,9400);
fachada.agregarJugador("38494030" ,"moonlight","Esteban Ruiz" ,12000);
fachada.agregarJugador("57393029" ,"pass789","Laura Rivas" ,10400);
fachada.agregarJugador("49203829" ,"maverick","Julián Méndez" ,9200);
fachada.agregarJugador("29304839" ,"bluebird","Valentina Ortega" ,8600);


fachada.agregarAdmin("58492011" ,"alpha123","Manuel Vargas" );
fachada.agregarAdmin("29385030" ,"secure789","Clara Salinas" );
fachada.agregarAdmin("18493050" ,"password3","Ignacio Flores" );
fachada.agregarAdmin("39481020" ,"letmein456","Paola Castillo" );
fachada.agregarAdmin("58491040" ,"mypassword8","Santiago Durán" );
    }
}
