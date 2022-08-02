package com.juninhoegger.findcep.main;

import com.juninhoegger.findcep.FindCepApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void shouldTestMain() {
        FindCepApplication.main(new String[]{});
        assertTrue(true);
    }

}
