import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestCustomer {
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void testDeposit() {
        assertEquals(0, customer.deposit(-100, new Date(), Customer.CHECKING), 0);
        assertEquals(0, customer.deposit(200, new Date(), "Hello"), 0);
        assertEquals(500, customer.deposit(300, new Date(), Customer.CHECKING), 0);
        assertEquals(500, customer.deposit(300, new Date(), Customer.SAVING), 0);
    }

    @Test
    public void testWithdraw() {
        assertEquals(-101, customer.withdraw(-100, new Date(), Customer.CHECKING), 0);
        assertEquals(-101, customer.withdraw(100, new Date(), "Hello"), 0);
        assertEquals(-101, customer.withdraw(301, new Date(), Customer.CHECKING), 0);
        assertEquals(-101, customer.withdraw(301, new Date(), Customer.SAVING), 0);
        assertEquals(150, customer.withdraw(50, new Date(), Customer.CHECKING), 0);
        assertEquals(150, customer.withdraw(50, new Date(), Customer.SAVING), 0);
    }
}
