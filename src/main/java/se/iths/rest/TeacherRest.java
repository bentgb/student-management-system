package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;


    @Path("teacher")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public class TeacherRest {

        @Inject
        TeacherService teacherService;


        @Path("getstudentsforsubject/{teacherName}/{subjectName}")
        @GET
        public Set<Student> getSpecificStudentsForSubject(@PathParam("teacherName") String teacherName, @PathParam("subjectName") String subjectName) {
            return teacherService.getSpecificStudentsForSubject(teacherName, subjectName);
        }
        @Path("getAll")
        @GET
        public List<Teacher> getAllTeachers() {
            return teacherService.getAllTeachers();
        }
    }

