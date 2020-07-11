package ec.edu.ups.controlador;

import ec.edu.ups.ejb.*;
import ec.edu.ups.entidad_cit_cons_cert.Cita;
import ec.edu.ups.entidad_cit_cons_cert.Paciente;
import ec.edu.ups.entidad_ingre_egre_rep.FacturaDetalle;
import ec.edu.ups.entidad_ingre_egre_rep.Medicamento;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.*;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaIngresoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private FacturaIngresoFacade ejbFacturaIngreso;
    @EJB
    private FacturaDetalleFacade ejbFacturaDetalle;
    @EJB
    private MedicamentoFacade ejbMedicamentoFacade;
    @EJB
    private PacienteFacade ejbPacienteFacade;
    @EJB
    private CitaFacade ejbCitaFacade;
    private String fecha;
    private String total_iva;
    private String subtotal;
    private String total;
    private String caja;
    private String paciente;
    private String cita;
    //Detalle de la factura
    private String cantidad;
    private String medicamento;
    private String det_total;
    //Lista para de las detalles de las facturas
    private List<FacturaDetalle> list;
    //Lista de citas segun el paciente;
    private List<Cita> citas_paciente;
    //Mensaje controlador
    private String mensaje;
    //cita seleccionada para facturar
    private String selected_cita;


    public FacturaIngresoBean(){

    }
    @PostConstruct
    public void init(){
        //list=ejbFacturaDetalle.findAll();

    }

    public String getSelected_cita() {
        return selected_cita;
    }

    public void setSelected_cita(String selected_cita) {
        this.selected_cita = selected_cita;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<FacturaDetalle> getList() {
        return list;
    }

    public void setList(List<FacturaDetalle> list) {
        this.list = list;
    }


    public String getTotal_iva() {
        return total_iva;
    }

    public void setTotal_iva(String total_iva) {
        this.total_iva = total_iva;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDet_total() {
        return det_total;
    }

    public void setDet_total(String det_total) {
        this.det_total = det_total;
    }

    public List<Cita> getCitas_paciente() {
        return citas_paciente;
    }

    public void setCitas_paciente(List<Cita> citas_paciente) {
        this.citas_paciente = citas_paciente;
    }

    public void add() {

            System.out.println("ingreso al metodo");
        /*Medicamento medicamento_encontrado=buscarMedicamento(medicamento);
        double precio_total= medicamento_encontrado.getPrecio()*Integer.parseInt(cantidad);
        Date date = null;
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);  */
        //SE DEBE BUSCAR POR CEDULA;
        Cita cita_buscada= new Cita();
        try {
            Paciente paciente_buscado = ejbPacienteFacade.buscarPorCedula(paciente);
            setMensaje("Paciente Encontrado");
            citas_paciente=ejbCitaFacade.buscarCitaPorPaciente(paciente_buscado);

        }catch (Exception e){
            setMensaje("PACIENTE NO ENCONTRADO");
            System.out.println("no encontro "+e);
        }
        System.out.println("encontro");




        }
    }


