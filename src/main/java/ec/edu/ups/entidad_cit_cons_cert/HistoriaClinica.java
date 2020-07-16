package ec.edu.ups.entidad_cit_cons_cert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class HistoriaClinica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private Date fecha;
    private String observacion;
    @ManyToOne
    private HistorialClinico historialclinico;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "historiaclinica")
    private OrdenMedica ordenesmedicas;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "historiaclinica")
    private Prescripcion prescripcion;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Date fecha, String observacion, HistorialClinico historialclinico, OrdenMedica ordenesmedicas, Prescripcion prescripcion) {
        this.fecha = fecha;
        this.observacion = observacion;
        this.historialclinico = historialclinico;
        this.ordenesmedicas = ordenesmedicas;
        this.prescripcion = prescripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public HistorialClinico getHistorialclinico() {
        return historialclinico;
    }

    public void setHistorialclinico(HistorialClinico historialclinico) {
        this.historialclinico = historialclinico;
    }

    public OrdenMedica getOrdenesmedicas() {
        return ordenesmedicas;
    }

    public void setOrdenesmedicas(OrdenMedica ordenesmedicas) {
        this.ordenesmedicas = ordenesmedicas;
    }

    public Prescripcion getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(Prescripcion prescripcion) {
        this.prescripcion = prescripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriaClinica that = (HistoriaClinica) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
