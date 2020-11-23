package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("new")
    @POST
    public Response createStudent(Student student) {
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student) {
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @GET
    public Response getItem(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null) {
            return Response.ok(foundStudent).build();
        } else {
            throw new StudentNotFoundException("Student with ID " + id + " not found.");
        }
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null) {
            studentService.deleteStudent(id);
            return Response.ok().entity("Student with ID " + id + " was successfully deleted.")
                    .type(MediaType.TEXT_PLAIN).build();
        } else {
            throw new StudentNotFoundException("Student with ID " + id + " not found.");
        }
    }


    @Path("getall")
    @GET
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();    }



    @Path("getbyname/{lastname}")
    @GET
    public List<Student> getByNameNP(@PathParam("lastname") String lastname) {
        return studentService.getByNameNamedParameters(lastname);
    }

    @Path("getAllStudentsBySubject/{subjectName}")
    @GET
    public Set<Student> getSpecificStudentsBySubject(@PathParam("subjectName") String subjectName) {
        return studentService.getAllStudentsBySubject(subjectName);
    }


}
