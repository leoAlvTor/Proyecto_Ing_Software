package ec.edu.ups.controlador;

import ec.edu.ups.ejb.ColaboradorFacade;
import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.entidad_cit_cons_cert.Colaborador;
import ec.edu.ups.entidad_cit_cons_cert.Rol;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class AdministradorBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombreRol,descripcion,nombreRolSelect;
    private List<Rol> listaRoles;
    private Rol rol;
    private Map<String,Integer> mapaRoles;
    @EJB
    private RolFacade rolFacade;
    @EJB
    private ColaboradorFacade colaboradorFacade;

    /*variables de personaColaborador*/
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;



    public AdministradorBean(){

    }

    @PostConstruct
    public void init(){
        this.listaRoles=rolFacade.findAll();
        mapaRoles=new HashMap<>();
        for (Rol roles:listaRoles
             ) {
            mapaRoles.put(roles.getNombre(),roles.getCodigo());
        }

    }
    /*Metodos para persistencia Rol*/
    public String addRol(){
        System.out.println(nombreRol.toUpperCase()+" "+descripcion.toUpperCase());
        rolFacade.create(new Rol(this.nombreRol.toUpperCase(),this.descripcion.toUpperCase()));
        this.listaRoles=rolFacade.findAll();
        limpiarCampos();
        return null;
    }

    public void limpiarCampos(){
        this.nombreRol="";
        this.descripcion="";
        this.nombreRolSelect="";
    }


    /*Metodos para persistencia Colaborador*/

    public void addColaborador(){
        Colaborador c=new Colaborador();
        c.setNombre(this.nombre.toUpperCase());
        c.setApellido(this.apellido.toUpperCase());
        c.setCedula(this.cedula);
        c.setCorreo(this.correo);
        c.setPassword(this.password);
        Rol r=rolFacade.find(mapaRoles.get(this.nombreRolSelect));
        c.setRol(r);
        colaboradorFacade.create(c);
        limpiarCamposColab();
    }

    public void limpiarCamposColab(){
        this.nombre="";
        this.cedula="";
        this.apellido="";
        this.correo="";
        this.password="";
    }


    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreRolSelect() {
        return nombreRolSelect;
    }

    public void setNombreRolSelect(String nombreRolSelect) {
        this.nombreRolSelect = nombreRolSelect;
    }

    public Rol[] getListaRoles() {
                /*   public Bodega[] getBodegas() {
        return bodegas.toArray(new Bodega[0]);
    }*/
        return listaRoles.toArray(new Rol[0]);
    }

    public void setListaRoles(List<Rol> listaRoles) {

        this.listaRoles = listaRoles;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Map<String, Integer> getMapaRoles() {
        return mapaRoles;
    }

    public void setMapaRoles(Map<String, Integer> mapaRoles) {
        this.mapaRoles = mapaRoles;
    }

    /*metodos*/
    public String [] listaRolesForSelect(){
        String[] list = new String[listaRoles.size()];
        list[0]="elegir";
        for (int i = 1; i < listaRoles.size(); i++){
            list[i] = listaRoles.get(i).getNombre();
        }
        return list;
    }

    /*PersonaColaborador*/

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
}
