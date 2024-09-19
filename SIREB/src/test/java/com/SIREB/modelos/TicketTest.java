package com.SIREB.modelos;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Marcelo Llanes
 */
public class TicketTest {
 
  public TicketTest() {
  }

  /**
   * Test of getTicket method, of class Ticket.
   */
  @Test
  public void testGetTicket() {
    System.out.println("getTicket");
    Ticket instance = new Ticket();
    String expResult = "0311220";
    String result = instance.getTicket();
    assertEquals(expResult, result);

  }
  
}
