package service;

import dao.EstudianteDAO;
import exception.DuplicateCedulaException;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Estudiante;

import java.util.List;

@Path("/estudiantes")
public class EstudianteService {
    @Inject
    private EstudianteDAO estudianteDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarEstudiante(Estudiante estudiante) {
        try {
            estudianteDAO.registrarEstudiante(estudiante);
            return Response.status(Response.Status.CREATED).build();
        } catch (DuplicateCedulaException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiante> obtenerEstudiantes() {
        return estudianteDAO.obtenerEstudiantes();
    }
}