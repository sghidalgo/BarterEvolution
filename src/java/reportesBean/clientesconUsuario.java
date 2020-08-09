/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportesBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.sessions.UsuariosSistemaFacade;


@Named(value = "clientesconUsuario")
@RequestScoped
public class clientesconUsuario {

@EJB
    private UsuariosSistemaFacade usistemaFacade;
    private List<Object[]> listar;

    public List<Object[]> getListar() {
        return listar;
    }

    public void setListar(List<Object[]> listar) {
        this.listar = listar;
    }
  
        
    /**
     * Creates a new instance of clientesconUsuario
     */
    public clientesconUsuario() {
    }
    
 @PostConstruct
    public void llenarTabla(){
        listar=usistemaFacade.clientesconusuariosistema();
    }
   
    
}
