package reportesBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.sessions.ContratosFacade;


@Named(value = "clientesVariosCon")
@RequestScoped
public class clientesVariosCon {
    
    @EJB
    private ContratosFacade contrafacade;
    private List<Object[]> listar;

    public List<Object[]> getListar() {
        return listar;
    }

    public void setListar(List<Object[]> listar) {
        this.listar = listar;
    }

    /**
     * Creates a new instance of clientesVariosCon
     */
    public clientesVariosCon() {
    }
    @PostConstruct
    public void llenarTabla(){
        listar=contrafacade.clientes_variosCon();
    
        }
}