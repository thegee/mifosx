package org.mifosplatform.infrastructure.core.exceptionmapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.mifosplatform.infrastructure.core.data.ApiGlobalErrorResponse;
import org.mifosplatform.infrastructure.core.exception.PlatformDataIntegrityException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * An {@link ExceptionMapper} to map {@link PlatformDataIntegrityException}
 * thrown by platform into a HTTP API friendly format.
 * 
 * The {@link PlatformDataIntegrityException} is thrown when modifying api call
 * result in data integrity checks to be fired.
 */
@Provider
@Component
@Scope("singleton")
public class PlatformDataIntegrityExceptionMapper implements ExceptionMapper<PlatformDataIntegrityException> {

    @Override
    public Response toResponse(PlatformDataIntegrityException exception) {

        ApiGlobalErrorResponse dataIntegrityError = ApiGlobalErrorResponse.dataIntegrityError(exception.getGlobalisationMessageCode(),
                exception.getDefaultUserMessage(), exception.getParameterName(), exception.getDefaultUserMessageArgs());

        return Response.status(Status.FORBIDDEN).entity(dataIntegrityError).type(MediaType.APPLICATION_JSON).build();
    }
}