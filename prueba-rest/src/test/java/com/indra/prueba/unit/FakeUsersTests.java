package com.indra.prueba.unit;


import com.indra.prueba.util.FakeUsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FakeUsersTests {

    @Test
    public void it_should_exist(){
        Assertions.assertTrue(FakeUsers.exist("david"));
    }

    @Test
    public void it_should_not_exist(){
        Assertions.assertFalse(FakeUsers.exist("pepe"));
    }

}
