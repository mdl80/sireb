package com.SIREB.ControladorAvanzado;

import com.SIREB.modelos.Token;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 *
 * @author Marcelo Llanes
 */
@ControllerAdvice
public class ControladorHeaders {

  @ModelAttribute
  public Token addToken(@RequestHeader(value = "sirebtoken") String token) {
    Token securityHeaders = new Token();
    securityHeaders.setLlave(token);
    return securityHeaders;
  }

}
