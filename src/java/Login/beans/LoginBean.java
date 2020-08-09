
package Login.beans;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import jpa.entities.TipoUsuario;
import jpa.entities.UsuariosSistema;
import jpa.sessions.UsuariosSistemaFacade;


@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
     private String nombreUsuario;
     private String password;
     private String roladm="A";
     private String rolemp="E";
     private String rolcli="C";
   


    @EJB
    private UsuariosSistemaFacade usuFacade;
    private TipoUsuario roles;
    private UsuariosSistema usuarioAutenticado;
    

    public UsuariosSistema getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(UsuariosSistema usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
        public String autenticar(){
        usuarioAutenticado=usuFacade.encontrarUsuarioxLogin(nombreUsuario);
                        
        if(usuarioAutenticado!=null){            
            if(usuarioAutenticado.getContraseña().equals(password)){              
            if(usuarioAutenticado.getIdusuario().getIdtipousuario().equals(roladm)){             
            return "/tradash_admin?faces-.redirect=true";              
            }
            
            else if(usuarioAutenticado.getIdusuario().getIdtipousuario().equals(rolemp)){                
             return "/tradash_emple?faces-.redirect=true";
            }
            else if(usuarioAutenticado.getIdusuario().getIdtipousuario().equals(rolcli)){                
             return "/tradash_clie?faces-.redirect=true";
            }
            }            
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"el password no corresponde","el password no corresponde"));
            return null;
        }
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"el usuario no existe","el usuario no existe"));
        return null;
    }       

 //Se cierra la sesión
public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate(); //Cierre de sesion
        }
                
     return "/Login?faces-.redirect=true" ;  
    }

}
 
        
