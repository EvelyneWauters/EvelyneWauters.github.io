package ca.evelyne.utilities;

import java.io.*;

public class FileToHexStringConverter {
    public static void main(String[] args) throws IOException {
        // TODO: parameterize filename to args[]
        try(FileInputStream fis = new FileInputStream(new File("images/david-tennant.jpg"))) {
            System.out.print("0x");
            toHexString(fis, System.out);
        }
    }

    static void toHexString(InputStream i, OutputStream o) throws IOException {
        BufferedInputStream in = new BufferedInputStream(i);
        PrintStream out = new PrintStream(new BufferedOutputStream(o));
        int b = in.read();
        while(b != -1) {
            out.printf("%02X", b);
            b = in.read();
        }
        out.flush();
    }
}
