package ec.edu.ups.controlador;


import ec.edu.ups.ejb.ColaboradorFacade;
import ec.edu.ups.ejb.MedicoFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.entidad_cit_cons_cert.Colaborador;
import ec.edu.ups.entidad_cit_cons_cert.Medico;
import ec.edu.ups.entidad_cit_cons_cert.Paciente;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class InicioSesionBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /*VARIABLE DE LA VISTA*/
    private String correo, password;
    /*facades*/
    @EJB
    private ColaboradorFacade colaboradorFacade;
    @EJB
    private MedicoFacade medicoFacade;
    @EJB
    private PacienteFacade pacienteFacade;



    /*METODOS*/
    @PostConstruct
    public void init(){

    }

    public List<Paciente> findPacientes(){
       return pacienteFacade.findAll();
    }
    public List<Colaborador> findColaboradores(){
       return colaboradorFacade.findAll();
    }
    public List<Medico> findMedicos(){
       return medicoFacade.findAll();
    }

    public void validar(){
        List<Paciente> listPaciente=findPacientes();
        boolean band=false;
        for (Paciente p: listPaciente) {
            if (p.getCorreo().equals(this.correo) && p.getPassword().equals(this.password)){
                System.out.println("=======================================");
                System.out.println("===================ENCONTRADO PACIENTE====================");
                band=true;
                break;
            }
        }
        if (band==false)
            validarMedicos();
    }

    private void validarMedicos() {
        List<Medico> listMedicos=findMedicos();
        boolean band=false;
        for (Medico m: listMedicos) {
            if (m.getCorreo().equals(this.correo) && m.getPassword().equals(this.password)){
                System.out.println("=======================================");
                System.out.println("===================ENCONTRADO mEDICO====================");
                band=true;
                break;
            }
        }
        if (band==false)
            validarColaboradores();

    }

    private void validarColaboradores() {
        List<Colaborador> listColaboradores=findColaboradores();
        for (Colaborador c: listColaboradores) {
            if (c.getCorreo().equals(this.correo) && c.getPassword().equals(this.password)){
                System.out.println("=======================================");
                System.out.println("===================ENCONTRADO COLABORADOR====================");
                break;
            }
        }
        System.out.println("===================USER NO ENCONTRADO!!!!!!!1====================");
    }


    /*SET Y GET*/

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
}
