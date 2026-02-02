package com.example.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class VariableStoreTest {
    private VariableStore store;

    @BeforeEach 
    void setUp() {
        store = new VariableStore();
    }

    @Test
    void testVariableStore() {
        store.set("x", 10);
        store.set("y", 20);

        assertEquals(10L, (long) store.get("x"));
        assertEquals(20L, (long) store.get("y"));
        assertEquals("(x=10,y=20)", store.toString());
    }
}
