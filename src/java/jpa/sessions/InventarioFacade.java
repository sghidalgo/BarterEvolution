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
import jpa.entities.Inventario;

/**
 *
 * @author Cristian Delgadillo
 */
@Stateless
public class InventarioFacade extends AbstractFacade<Inventario> {

    @PersistenceContext(unitName = "BarterEvolutionFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioFacade() {
        super(Inventario.class);
    }
    public List obtenerConsInv(){
    Query q = em.createNativeQuery("SELECT inv.Id_articulo, art.Nombre_articulo, cate.Nombre_categoria,\n" +
"inv.Cantidad, inv.Id_inventario, conart.nombre_condicionart\n" +
"FROM inventario inv INNER JOIN articulos art ON inv.Id_articulo=art.IdArticulo\n" +
"INNER JOIN categorias cate ON inv.Id_categoria=cate.Id_categoria\n" +
"INNER JOIN condicion_articulos conart ON inv.Id_condicion_articulo=conart.id_condicion_articulo\n" +
"GROUP BY inv.Id_articulo");
        List<Object[]> listar=q.getResultList();
        return listar;
    }
}
