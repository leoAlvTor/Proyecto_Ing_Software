package ec.edu.ups.entidad_cit_cons_cert;

import sun.security.x509.CertificateIssuerExtension;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Certificado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String observacion;
    private Date fecha;
    @ManyToOne
    private Medico medico;
    @ManyToOne
    private Paciente paciente;

    public Certificado() {
        super();
    }


    public Certificado(String observacion, Date fecha, Medico medico, Paciente paciente) {
        this.observacion = observacion;
        this.fecha = fecha;
        this.medico = medico;
        this.paciente = paciente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificado that = (Certificado) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Certificado{" +
                "codigo=" + codigo +
                ", observacion='" + observacion + '\'' +
                ", fecha=" + fecha +
                ", medico=" + medico +
                ", paciente=" + paciente +
                '}';
    }
}
