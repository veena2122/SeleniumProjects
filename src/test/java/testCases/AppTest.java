package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import genericUtility.StringUtil;

class AppTest {

    @Test
    void shouldConvertToTitleCase() {
        assertEquals("Hello World", StringUtil.toTitleCase("hello world"));
    }

    @Test
    void shouldDetectBlankString() {
        assertTrue(StringUtil.isBlank("   "));
        assertFalse(StringUtil.isBlank("ProjectNew"));
    }
}
