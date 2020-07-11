package ec.edu.ups.ejb;

import ec.edu.ups.entidad_cit_cons_cert.Cita;
import ec.edu.ups.entidad_cit_cons_cert.Cita;
import ec.edu.ups.entidad_cit_cons_cert.Paciente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CitaFacade extends AbstractFacade<Cita>{

    @PersistenceContext(unitName = "Practica03.EJB.JSF.JPA")
    private EntityManager entityManager;

    public CitaFacade() {
        super(Cita.class);
    }

    public List<Cita> buscarCitaPorPaciente(Paciente cedula){
        System.out.println("Cedula del Cita buscado"+cedula);
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Cita> criteriaQuery= criteriaBuilder.createQuery(Cita.class);
        Root<Cita> categoriaRoot= criteriaQuery.from(Cita.class);
        Predicate predicate= criteriaBuilder.equal(categoriaRoot.get("PACIENTE"),cedula);
        criteriaQuery.select(categoriaRoot).where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}