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
import jpa.entities.Ventas;

/**
 *
 * @author Cristian Delgadillo
 */
@Stateless
public class VentasFacade extends AbstractFacade<Ventas> {

    @PersistenceContext(unitName = "BarterEvolutionFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentasFacade() {
        super(Ventas.class);
    }
         public List obtenerConsVenta(){
    Query q = em.createNativeQuery("SELECT  ven.No_factura, ven.Cedula_cliente, concat(cli.nombrecliente1,' ',cli.apellidocliente1) as Clientes, ven.VALOR_TOTAL, art.Nombre_articulo, ven.Id_articulo, esart.Nombre_estadoart\n" +
"FROM clientes as cli INNER JOIN ventas AS ven ON ven.Cedula_cliente=cli.Cedula_cliente\n" +
"INNER JOIN articulos as art ON ven.Id_articulo=art.IdArticulo\n" +
"INNER JOIN estado_articulos as esart ON ven.Id_estado_articulo=esart.Id_estado_articulo\n" +
"ORDER BY ven.No_factura");
        List<Object[]> listar=q.getResultList();
        return listar;
    }
}
