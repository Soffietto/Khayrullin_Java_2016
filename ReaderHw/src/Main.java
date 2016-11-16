import java.io.*;

/**
 * Created by soffietto on 15.11.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/file.txt");
        Reader is = new LowerToUpperAndUppertToLowerReader(new FileReader(file));
        int c;
        while ((c = is.read()) != -1){
            System.out.print((char)c);
        }
        System.out.println("");
    }

}
