
package reportesBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.sessions.VentasFacade;


@Named(value = "consultaVentasBean")
@RequestScoped
public class ConsultaVentasBean {

@EJB
private VentasFacade vFacade;
private List<Object[]> listar;

    public List<Object[]> getListar() {
        return listar;
    }

    public void setListar(List<Object[]> listar) {
        this.listar = listar;
    }
    
    /**
     * Creates a new instance of ConsultaVentasBean
     */
    public ConsultaVentasBean() {
    }
    @PostConstruct
    public void llenarTabla(){
       listar=vFacade.obtenerConsVenta();
    }
}
