package ca.evelyne.utilities;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static junit.framework.TestCase.assertEquals;

public class FileToHexStringConverterTest {
    @Test
    public void toHexStringStreamsBytesFromInputStreamAsHexStringToOutputStream() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        FileToHexStringConverter.toHexString(new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0x00, (byte) 0xAC, (byte) 0x01}), out);
        assertEquals("FF00AC01", out.toString("UTF-8"));
    }
}
