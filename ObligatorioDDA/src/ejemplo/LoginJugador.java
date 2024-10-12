/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo;
import Logica.Jugador;
import Logica.Usuario;
import Logica.Exceptions.UsuarioException;
import java.awt.Frame;
import javax.swing.JOptionPane;
import ui.controller.LoginController;

/**
 *
 * @author HOLA
 */
public class LoginJugador extends Login {
    Frame padre;
      LoginController controller = new LoginController(this);
    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Ingreso para jugadores");
        padre = parent;
    }
   

    @Override
    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);  
    }

    @Override
    public void cargarSiguientePantalla(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Login(String name, String contra) {
         controller.LoginJugador(name, contra);
    }
    
    
}
