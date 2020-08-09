
package reportesBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.sessions.UsuariosSistemaFacade;

@Named(value = "cantidadTipoUsuarioBean")
@RequestScoped
public class CantidadTipoUsuarioBean {

    @EJB
    private UsuariosSistemaFacade usuFacade;
    private List<Object[]> listado;

    public List<Object[]> getListado() {
        return listado;
    }

    public void setListado(List<Object[]> listado) {
        this.listado = listado;
    }
    
    /**
     * Creates a new instance of CantidadTipoUsuarioBean
     */

    
  
    public CantidadTipoUsuarioBean() {
    }
   @PostConstruct
    public void llenarTabla(){
        listado=usuFacade.obtenerCantidadTiposUsuario();
    }
     
    
}
