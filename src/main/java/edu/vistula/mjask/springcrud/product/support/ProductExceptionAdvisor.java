package edu.vistula.mjask.springcrud.product.support;

import ch.qos.logback.classic.Logger;
import edu.vistula.mjask.springcrud.shared.api.response.ErrorMessageResponse;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ProductExceptionAdvisor {

    private final static Logger log = (Logger) LoggerFactory.getLogger(ProductExceptionAdvisor.class);

    public ErrorMessageResponse productNotFound(Exception e) {
        log.error(e.getMessage(), e);
        return new ErrorMessageResponse(e.getLocalizedMessage());
    }
}
