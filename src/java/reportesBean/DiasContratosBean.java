package reportesBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.sessions.ContratosFacade;


@Named(value = "diasContratosBean")
@RequestScoped
public class DiasContratosBean {

@EJB
private ContratosFacade contraFacade;
private List<Object[]> listado;

    public List<Object[]> getListado() {
        return listado;
    }

    public void setListado(List<Object[]> listado) {
        this.listado = listado;
    }
    
    
    /**
     * Creates a new instance of DiasContratosBean
     */
    public DiasContratosBean() {
    }
    @PostConstruct
    public void llenarTabla(){
        listado=contraFacade.diasContrato();
    }
   
}
