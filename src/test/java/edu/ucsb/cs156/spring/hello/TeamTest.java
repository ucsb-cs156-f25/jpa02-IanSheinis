package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_bool() {
        var other = new Team("other");    
        assertTrue(team.equals(team), "setup team should equal setup team");
        assertFalse(team.equals(other), "setup team should not equal other team");
        assertFalse(team.equals("object"), "setup team should not equal other object");
        assertFalse(other.equals(team), "other team should not equal team obj");
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertTrue(t1.equals(t2), "t1 = t2");
        t2.addMember("hi");
        assertFalse(t1.equals(t2), "t1!=t2");
        Team t3 = new Team("j");
        Team t4 = new Team("j");
        Team t5 = new Team("z");
        assertFalse(t5.equals(t4));

    }

    @Test
    public void hashtest_returns_correct_hash() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
        t2.addMember("hi");
        assertNotEquals(t1.hashCode(), t2.hashCode());
        Team t3 = new Team("j");
        Team t4 = new Team("j");
        Team t5 = new Team("z");
        assertNotEquals(t5.hashCode(), t4.hashCode());
    }

   

}
