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
import jpa.entities.UsuariosSistema;

/**
 *
 * @author Cristian Delgadillo
 */
@Stateless
public class UsuariosSistemaFacade extends AbstractFacade<UsuariosSistema> {

    @PersistenceContext(unitName = "BarterEvolutionFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosSistemaFacade() {
        super(UsuariosSistema.class);
    }
     
    public UsuariosSistema encontrarUsuarioxLogin(String nombreUsuario){
    Query q=em.createNamedQuery("UsuariosSistema.findByUsuario",UsuariosSistema.class).setParameter("usuario",nombreUsuario);
    List<UsuariosSistema> listado=q.getResultList();
    
    if(!listado.isEmpty()){
    return listado.get(0);
    }
    return null;
    } 
       
    
    public List obtenerCantidadTiposUsuario(){
    Query q = em.createNativeQuery("SELECT Nombre_tipous,COUNT(*)\n" +
            "FROM usuarios_sistema JOIN tipo_usuario ON Id_usuario= Id_tipo_usuario\n" +
            "GROUP BY Nombre_tipous ORDER BY Nombre_tipous;");
        List<Object[]> listado=q.getResultList();
        return listado;
    }
   
   public List clientesconusuariosistema(){
    Query q = em.createNativeQuery("SELECT cl.Cedula_cliente, concat(cl.Nombrecliente1,' ',cl.Apellidocliente1) as Nombres, us.Email, us.Usuario, tpus.Nombre_tipous,\n" +
"COUNT(con.Id_condicion_contrato)  \n" +
"FROM clientes cl INNER JOIN usuarios_sistema us ON cl.Cedula_cliente=us.Cedula_usuario\n" +
"INNER JOIN tipo_usuario tpus ON us.Id_usuario=tpus.Id_tipo_usuario\n" +
"INNER JOIN contratos con ON con.Cedula_cliente=cl.Cedula_cliente\n" +
"GROUP BY cl.Cedula_cliente\n" +
"ORDER BY cl.Nombrecliente1");
        List<Object[]> listado=q.getResultList();
        return listado;
    } 
   
   public List<UsuariosSistema> obtenerUsuariosBusquedaxCadena(String cadena){
   Query q = em.createNativeQuery("SELECT `Cedula_usuario`, `Id_documento`, `Id_usuario`, `Nombreusuario1`, \n" +
   "`Nombreusuario2`, `Apellidousuario1`, `Apellidousuario2`,\n" +
   "`Email`, `Usuario`, `Contraseña` FROM `usuarios_sistema`\n" +
   "WHERE Nombreusuario1 LIKE'%"+cadena+"%'", UsuariosSistema.class);
   List<UsuariosSistema> lst=q.getResultList();
   return lst;
    }
}
