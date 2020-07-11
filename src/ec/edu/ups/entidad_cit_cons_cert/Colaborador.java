package ec.edu.ups.entidad_cit_cons_cert;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Colaborador extends Persona implements Serializable {

    @ManyToOne
    private Rol rol;

    public Colaborador(){

    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "rol=" + rol +
                '}';
    }
}