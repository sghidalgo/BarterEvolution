/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.entities.Contratos;

/**
 *
 * @author Cristian Delgadillo
 */
@Stateless
public class ContratosFacade extends AbstractFacade<Contratos> {

    @PersistenceContext(unitName = "BarterEvolutionFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratosFacade() {
        super(Contratos.class);
    }
       public List obtenerContrayPro(){
    Query q = em.createNativeQuery("SELECT cont.No_contrato, concat(cli.nombrecliente1,' ',cli.apellidocliente1) as Clientes, tipc.Nombre_tipocliente, cont.Valor_contrato, pro.No_prorroga, pro.Valor_mes as Valor_Prorroga, cont.Fecha_inicio, cont.Fecha_vencimiento, pro.Fecha_inicio_prorroga, pro.Fecha_vencimiento_prorroga\n" +
"FROM clientes AS cli INNER JOIN contratos AS cont ON cont.Cedula_cliente=cli.Cedula_cliente\n" +
"INNER JOIN prorrogas pro ON cont.No_prorroga=pro.No_prorroga\n" +
"INNER JOIN tipo_cliente tipc ON cli.Id_tipocliente=tipc.Id_tipocliente\n" +
"WHERE pro.No_prorroga >=\"PR-00001\"\n" +
"ORDER BY cont.No_contrato");
        List<Object[]> listar=q.getResultList();
        return listar;
    }
   
     public List diasContrato(){
    Query q = em.createNativeQuery("SELECT contra.No_contrato, contra.Fecha_inicio, contra.Fecha_vencimiento,"
            + " DATEDIFF(CURDATE(), Fecha_inicio) diasContratos, CASE WHEN DATEDIFF(CURDATE(), Fecha_inicio) BETWEEN 10 AND 20 THEN 'Mas de diez días' WHEN DATEDIFF(CURDATE(), Fecha_inicio) BETWEEN 21 AND 30 THEN 'Mas de veinte días' WHEN DATEDIFF(CURDATE(), Fecha_inicio) >= 30 THEN 'Mas de treinta días'"
            + " ELSE 'Menos de diez días' END RANGO FROM contratos contra WHERE contra.Id_condicion_contrato=\"V\"");
        List<Object[]> listado=q.getResultList();
        return listado;
    }

public List clientes_variosCon(){
    Query q = em.createNativeQuery("SELECT c.Cedula_cliente, cl.Nombrecliente1, cl.Apellidocliente1, c.No_contrato, c.No_prorroga, ccon.Nombre_condicioncon, art.Nombre_articulo\n" +
"FROM contratos c JOIN clientes cl ON c.Cedula_cliente=cl.Cedula_cliente\n" +
"JOIN condicion_contratos ccon ON c.Id_condicion_contrato=ccon.Id_condicion_contrato\n" +
"JOIN articulos art ON c.Id_articulo=art.IdArticulo\n" +
"    WHERE c.Cedula_cliente IN (\n" +
"        SELECT Cedula_cliente FROM contratos \n" +
"            GROUP BY Cedula_cliente \n" +
"            HAVING COUNT(*)>1        \n" +
"        )\n" +
"        ORDER by cl.Nombrecliente1");
        List<Object[]> listado=q.getResultList();
        return listado;
    }     
     
}
