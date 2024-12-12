package dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.Estudiante;
import exception.DuplicateCedulaException;

import java.util.List;

@Stateless
public class EstudianteDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void registrarEstudiante(Estudiante estudiante) throws DuplicateCedulaException {
        try {
            em.persist(estudiante);
        } catch (jakarta.persistence.EntityExistsException e) {
            throw new DuplicateCedulaException("Cédula ya agregada");
        }
    }

    public List<Estudiante> obtenerEstudiantes() {
        return em.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
    }
}