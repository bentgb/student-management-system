package se.iths.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class SubjectNotFoundException extends Throwable {
    public SubjectNotFoundException(String s) {
        super(String.valueOf(Response.status(Response.Status.NOT_FOUND)
                .entity(s).type(MediaType.TEXT_PLAIN).build()));
    }
}
