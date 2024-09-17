package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import main.Product;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Product("123456", "Sanity", "Mental health", 9.99);
    }

    @Test
    public void testGetID() {
        assertEquals("123456", product.getID());
    }

    @Test
    public void testGetName() {
        assertEquals("Sanity", product.getName());
    }

    @Test
    public void testSetName() {
        product.setName("New Name");
        assertEquals("New Name", product.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Mental health", product.getDescription());
    }

    @Test
    public void testSetDescription() {
        product.setDescription("New Description");
        assertEquals("New Description", product.getDescription());
    }

    @Test
    public void testGetCost() {
        assertEquals(9.99, product.getCost(), 0.01);
    }

    @Test
    public void testSetCost() {
        product.setCost(19.99);
        assertEquals(19.99, product.getCost(), 0.01);
    }

    @Test
    public void testToString() {
        assertEquals("Product [ID=123456, name=Sanity, description=Mental health, cost=9.99]", product.toString());
    }

    @Test
    public void testToCSV() {
        assertEquals("123456,Sanity,Mental health,9.99", product.toCSV());
    }

    @Test
    public void testEquals() {
        Product product1 = new Product("123456", "Sanity", "Mental health", 9.99);
        Product product2 = new Product("123456", "Sanity", "Mental health", 9.99);
        assertTrue(product1.equals(product2));
    }

    @Test
    public void testNotEquals() {
        Product product1 = new Product("123456", "Sanity", "Mental health", 9.99);
        Product product2 = new Product("654321", "Sanity", "Mental health", 9.99);
        assertFalse(product1.equals(product2));
    }
}
