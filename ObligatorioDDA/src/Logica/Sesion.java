/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Date;

/**
 *
 * @author bsout
 */
public class Sesion {
    
    private Usuario usuario;
    private Date fechaSesion;

    public Sesion(Usuario usuario, Date fechaSesion) {
        this.usuario = usuario;
        this.fechaSesion = fechaSesion;
    }

    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

     public Usuario getUsuario() {
        return usuario;
    }
     
    public void setFechaSesion(Date fechaSesion) {
        this.fechaSesion = fechaSesion;
    }

    public Date getFechaSesion() {
        return fechaSesion;
    }
    
    
    
}
