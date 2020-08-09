
package reportesBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.sessions.InventarioFacade;


@Named(value = "inventarioCantidadArtBean")
@RequestScoped
public class InventarioCantidadArtBean {

@EJB
private InventarioFacade invFacade;
private List<Object[]> listar;

    public List<Object[]> getListar() {
        return listar;
    }

    public void setListar(List<Object[]> listar) {
        this.listar = listar;
    }
  
    
    /**
     * Creates a new instance of InventarioCantidadArtBean
     */
    public InventarioCantidadArtBean() {
    }
 @PostConstruct
    public void llenarTabla(){
       listar=invFacade.obtenerConsInv();
    }   
    
}
