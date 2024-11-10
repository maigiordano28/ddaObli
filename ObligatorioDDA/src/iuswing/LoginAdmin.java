/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iuswing;
import Dominio.Usuario.Admin;
import Dominio.Usuario.Usuario;
import Dominio.Exceptions.UsuarioException;
import java.awt.Frame;
import javax.swing.JOptionPane;
import ui.controller.LoginController;

/**
 *
 * @author HOLA
 */
public class LoginAdmin extends Login {
    Frame padre;
      LoginController controller = new LoginController(this);
    public LoginAdmin(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Ingreso para Admin");
        padre = parent;
    }
   

    @Override
    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);  
    }

    @Override
    public void cargarSiguientePantalla(Usuario u) { 
       
        InicioAdmin a= new InicioAdmin(padre,false,(Admin) u);
        a.setVisible(true);
        this.dispose();
    }

    @Override
    public void Login(String name, String contra) {
         controller.LoginAdmin(name, contra);
    }
    
    
}