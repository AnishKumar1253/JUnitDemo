package com.masai.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactManagerTest {
private static ContactManager manager = null;
@BeforeAll
public static void setUp() {
    manager = new ContactManager();
}

@Test
@DisplayName("Should Create Contact")
public void testCreateContact() {
    manager.addContact("John", "Doe", "1234567890");
    assertNotNull(manager.getAllContacts());
}

@Test
@DisplayName("Should Not Create Contact When First Name is Null")
public void testCreateContactWithNullFirstName() {
    try {
        manager.addContact("", "Doe", "1234567890");
        fail("Exception expected");
    } catch (Exception ex) {
        assertEquals("First Name Cannot be null or empty", ex.getMessage());
    }
}

@Test
@DisplayName("Phone Number should start with 0")
public void testPhoneNumberStartWith0() {
    try {
        manager.addContact("John", "Doe", "1234567890");
        fail("Exception expected");
    } catch (Exception ex) {
        assertEquals("Phone Number Should Start with 0", ex.getMessage());
    }
}

@Test
@DisplayName("Should Not Create Contact When Contact Already Exists")
public void testCreateContactWhenContactAlreadyExists() {
    manager.addContact("John", "Doe", "0123456789");
    try {
        manager.addContact("John", "Doe", "0123456789");
        fail("Exception expected");
    } catch (Exception ex) {
        assertEquals("Contact Already Exists", ex.getMessage());
    }
}

@Test
@DisplayName("Should Not Create Contact When Phone Number is Empty")
@Disabled
public void testCreateContactWithEmptyPhoneNumber() {
    try {
        manager.addContact("John", "Doe", "");
        fail("Exception expected");
    } catch (Exception ex) {
        assertEquals("Phone Name Cannot be null or empty", ex.getMessage());
    }
}

@AfterAll
public static void cleanUp() {
    manager = null;
}
}

