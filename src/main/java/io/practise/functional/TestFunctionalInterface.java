package io.practise.functional;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestFunctionalInterface {

    @Test
    public void testMapComputeIfAbsent() {
        Map<String, String> names = new HashMap<>();

        names.put("1", "Sourav");
        names.put("2", "Vishal");

        assertEquals("SOURAV", names.computeIfAbsent("1", val -> val.toUpperCase()));
    }


}
