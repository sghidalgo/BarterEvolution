/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscarTabla.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import jpa.entities.UsuariosSistema;
import jpa.sessions.UsuariosSistemaFacade;


@Named(value = "consultaEspecificaBean")
@SessionScoped
public class consultaEspecificaBean implements Serializable {

    private String textoaBuscar="";
     private List<UsuariosSistema> listausuarios=new ArrayList<>();
     
     @EJB
     
     private UsuariosSistemaFacade connFacade;

    public String getTextoaBuscar() {
        return textoaBuscar;
    }

    public void setTextoaBuscar(String textoaBuscar) {
        this.textoaBuscar = textoaBuscar;
    }

    public List<UsuariosSistema> getListausuarios() {
        return listausuarios;
    }

    public void setListausuarios(List<UsuariosSistema> listausuarios) {
        this.listausuarios = listausuarios;
    }
    
    public consultaEspecificaBean() {
    }
    
    public void llenarUsuarios(){
        listausuarios=connFacade.obtenerUsuariosBusquedaxCadena(textoaBuscar);
    } 
}
