/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.bean;

import java.io.Serializable;

/**
 *
 * @author Sergio
 */
public class Intento implements Serializable {

    private String numIntroducido;
    private int muertos;
    private int heridos;
    private String valorCampos;

    public String getNumIntroducido() {
        return numIntroducido;
    }

    public void setNumIntroducido(String numIntroducido) {
        this.numIntroducido = numIntroducido;
    }



    public int getMuertos() {
        return muertos;
    }

    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }

    public int getHeridos() {
        return heridos;
    }

    public void setHeridos(int heridos) {
        this.heridos = heridos;
    }

    public String getValorCampos() {
        return valorCampos;
    }

    public void setValorCampos(String valorCampos) {
        this.valorCampos = valorCampos;
    }
    
    
    
}
