package ec.edu.ups.controlador;


import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class InicioSesionBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /*VARIABLE DE LA VISTA*/
    private String correo, contrasenia;


    /*METODOS*/



    /*SET Y GET*/

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
