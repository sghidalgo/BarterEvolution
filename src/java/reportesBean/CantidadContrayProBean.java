package reportesBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.sessions.ContratosFacade;


@Named(value = "cantidadContrayProBean")
@RequestScoped
public class CantidadContrayProBean {

    @EJB
    private ContratosFacade contraFacade;
    private List<Object[]> listar;

    public List<Object[]> getListar() {
        return listar;
    }

    public void setListar(List<Object[]> listar) {
        this.listar = listar;
    }

    
    
    /**
     * Creates a new instance of CantidadTipoUsuarioBean
     */

       
    
    public CantidadContrayProBean() {
    }
    @PostConstruct
    public void llenarTabla(){
        listar=contraFacade.obtenerContrayPro();
    }
   
}
