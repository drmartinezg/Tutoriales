package es.duero4.headfirst.decorator.io;

import java.io.*;

/**
 *
 * @author ramon
 */
public class InputTest {

    public static void main(String[] args) throws IOException {
        int c;
        
        try {
             
            InputStream in = new LowerCaseInputStream(
                                new BufferedInputStream(
                                     new FileInputStream("src/main/resources/test.txt")));
            
            while ((c = in.read()) >= 0) {                
                System.out.print((char) c);
            }
            System.out.println("");
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
