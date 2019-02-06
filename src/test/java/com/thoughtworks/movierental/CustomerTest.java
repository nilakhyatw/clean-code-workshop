package com.thoughtworks.movierental;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;


public class CustomerTest {
    Customer c;

    @Before
    public void setUp() throws Exception {
        this.c = new Customer("testuser");
    }

    @Test
    public void test(){}

    @Test
    public void getNameShouldReturnTypeString(){
        String k = new String();
        assertThat(this.c.getName(), instanceOf(k.getClass()));
    }

    @Test
    public void getNameShouldReturnExactString() {
        assertEquals("testuser", this.c.getName());
    }

    @Test
    public void statementShuldReturnTypeString() {
        String k = new String();
        assertThat(this.c.statement(), instanceOf(k.getClass()));
    }

    @Test
    public void statementShuldReturnExactString() {
        Movie movieObject = new Movie("tezab", 0);
        int daysRented = 5;
        this.c.addRental(new Rental(movieObject, daysRented));
        assertEquals("Rental Record for testuser\n" +
                "\ttezab\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points", this.c.statement());
    }

    @Test
    public void htmlStatementShuldReturnTypeString() {
        String k = new String();
        assertThat(c.htmlStatement(), instanceOf(k.getClass()));
    }

    @Test
    public void htmlStatementShuldReturnExactString() {
        Movie movieObject = new Movie("tezab", 0);
        int daysRented = 5;
        c.addRental(new Rental(movieObject, daysRented));
        assertEquals("<h1>Rental Record for <b>testuser</b></h1><br/>" +
                "<p>tezab<&nbsp>6.5<br/></p>Amount owed is <b>6.5</b><br/>" +
                "You earned <b>1</b> frequent renter points", c.htmlStatement());
    }
}