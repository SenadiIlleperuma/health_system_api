//@author Senadi Illeperuma
//IIT no: 20220678 

package exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {

    private static final Logger LOGGER= LoggerFactory.getLogger(UserNotFoundExceptionMapper.class);


    @Override
    public Response toResponse(UserNotFoundException exception) {
       LOGGER.error("UserNotFoundException caught: {}",exception.getMessage(),exception);

        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
