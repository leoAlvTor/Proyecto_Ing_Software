package ec.edu.ups.controlador;

import ec.edu.ups.ejb.CajaFacade;
import ec.edu.ups.ejb.FacturaEgresoFacade;
import ec.edu.ups.ejb.FacturaIngresoFacade;
import ec.edu.ups.entidad_ingre_egre_rep.Caja;
import ec.edu.ups.entidad_ingre_egre_rep.FacturaEgreso;
import ec.edu.ups.entidad_ingre_egre_rep.FacturaIngreso;
import org.jboss.weld.context.ejb.Ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.List;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CajaBean implements Serializable {
    @EJB
    private CajaFacade ejbCajaFacade;
    @EJB
    private FacturaIngresoFacade ejbFacturaIngresoFacade;
    @EJB
    private FacturaEgresoFacade ejbFacturaEgresoFacade;

    private List<FacturaIngreso> facturaIngresoList;
    private List<FacturaEgreso>facturaEgresoList;
    private Date fechaCaja;
    private String mensaje;
    public CajaBean() {
    }
    @PostConstruct
    public void init(){

    }

    public Date getFechaCaja() {
        return fechaCaja;
    }

    public void setFechaCaja(Date fechaCaja) {
        this.fechaCaja = fechaCaja;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<FacturaIngreso> getFacturaIngresoList() {
        return facturaIngresoList;
    }

    public void setFacturaIngresoList(List<FacturaIngreso> facturaIngresoList) {
        this.facturaIngresoList = facturaIngresoList;
    }

    public List<FacturaEgreso> getFacturaEgresoList() {
        return facturaEgresoList;
    }

    public void setFacturaEgresoList(List<FacturaEgreso> facturaEgresoList) {
        this.facturaEgresoList = facturaEgresoList;
    }
    public void buscarCaja() throws ParseException {
        String fe="2020-07-13T17:24:14";
        LocalDateTime localDateTime = LocalDateTime.parse("2020-07-13T17:24:14");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        /*
        this.fechaCaja=formatter.parse(fe);
        String formatDateTime = localDateTime.format(formatter);
        this.fechaCaja= formatDateTime;
        System.out.println("fecha_a buscar"+formatDateTime);
        //2020-07-13 17:24:14
        Caja caja_buscada=ejbCajaFacade.buscarCajaPorFecha(formatDateTime);
        this.mensaje="Se encuentro la caja";

        String text = date.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);

         */
    }
    public void cerrarCaja(){}
}
