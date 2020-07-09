package ec.edu.ups.entidad_cit_cons_cert;

import ec.edu.ups.entidad_ingre_egre_rep.FacturaCabecera;
import ec.edu.ups.entidad_ingre_egre_rep.FacturaIngreso;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Paciente  implements Serializable {


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
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "paciente")
    private List<Certificado> certificados;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "paciente")
    private HistorialClinico historialClinico;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "paciente")
    private List<Cita> citas;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "paciente")
    private List<FacturaIngreso> facturas;

    public Paciente() {
    }

    public Paciente(String cedula, String nombre, String apellido, String correo, String password, Rol rol, List<Certificado> certificados, HistorialClinico historialClinico, List<Cita> citas, List<FacturaIngreso> facturas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
        this.certificados = certificados;
        this.historialClinico = historialClinico;
        this.citas = citas;
        this.facturas = facturas;
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

    public List<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(HistorialClinico historialClinico) {
        this.historialClinico = historialClinico;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<FacturaIngreso> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaIngreso> facturas) {
        this.facturas = facturas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return codigo == paciente.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "codigo=" + codigo +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                ", certificados=" + certificados +
                ", historialClinico=" + historialClinico +
                ", citas=" + citas +
                ", facturas=" + facturas +
                '}';
    }
}
