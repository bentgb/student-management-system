package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {


    @Inject
    SubjectService subjectService;

    @Path("new")
    @POST
    public Response createSubject(Subject subject) {
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("update")
    @PUT
    public Response updateSubject(Subject subject) {
        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }


    @Path("{id}")
    @GET
    public Response getSubject(@PathParam("id") Long id) throws SubjectNotFoundException {
        Subject foundSubject = subjectService.findSubjectById(id);
        if (foundSubject != null) {
            return Response.ok(foundSubject).build();
        } else {
            throw new SubjectNotFoundException("Subject with ID " + id + " not found.");
        }
    }

    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    public Response deleteSubject(@PathParam("id") Long id) throws SubjectNotFoundException {
        Subject foundSubject = subjectService.findSubjectById(id);
        if (foundSubject != null) {
            subjectService.deleteSubject(id);
            return Response.ok().entity("Subject with ID " + id + " was successfully deleted.").build();
        } else {
            throw new SubjectNotFoundException("Subject with ID " + id + " not found.");
        }
    }


    @Path("getall")
    @GET
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @Path("getbyname_dq/{name}")
    @GET
    public List<Subject> getByNameDQ(@PathParam("name") String name) {
        return subjectService.getByNameDynamicQuery(name);
    }

    @Path("getbyname_np/{name}")
    @GET
    public List<Subject> getByNameNP(@PathParam("name") String name) {
        return subjectService.getByNameNamedParameters(name);
    }

    @Path("getbyname_pp/{name}")
    @GET
    public List<Subject> getByNamePP(@PathParam("name") String name) {
        return subjectService.getByNamePositionalParameters(name);
    }

    @Path("getsorted")
    @GET
    public List<Subject> getAllItemsSortedByName() {
        return subjectService.getAllSubjectsSortedByName();
    }
}