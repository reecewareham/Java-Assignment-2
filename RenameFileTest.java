package com.tests;

import org.junit.Test;
import org.junit.Assert.*;

public class RenameFileTest {
    @Test
    public void renameFileTest() {
        renameFileTest rename = new renameFileTest();
        assertEquals("new name", rename.getName());
    }
}
