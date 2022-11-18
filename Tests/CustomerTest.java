package application.Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private Customer customer;

	@Before
	public void setUp() throws Exception {
		this.customer=new Customer("Hamza","Mehmood",2345,"Clare Street",
				"Northamtpon","23","NN14HN","malikhamza6787@yahoo.com");
	}

	@After
	public void tearDown() throws Exception {
		this.customer=null;
	}

	@Test
	public void testCustomerId() {
		customer.setCustomerid(2345);
		assertEquals(2345, customer.getCustomerid());
		

	}
	
	@Test
	public void testCustomerEmail() {
		customer.setEmail("malikhamza1525@gmai.com");
		assertEquals("malikhamza1525@gmai.com", customer.getEmail());
		

	}
	



}
