package ec.edu.ups.entidad_cit_cons_cert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Medico implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    @ManyToOne
    private Rol rol;
    private String especialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private List<Cita> citas;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "medico")
    private List<Certificado> certificados;

    public Medico() {
    }

    public Medico(int codigo, String cedula, String nombre, String apellido, String correo, String password, Rol rol, String especialidad, List<Cita> citas, List<Certificado> certificados) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
        this.especialidad = especialidad;
        this.citas = citas;
        this.certificados = certificados;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return codigo == medico.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Medico{" +
                "codigo=" + codigo +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                ", especialidad='" + especialidad + '\'' +
                ", citas=" + citas +
                ", certificados=" + certificados +
                '}';
    }
}
