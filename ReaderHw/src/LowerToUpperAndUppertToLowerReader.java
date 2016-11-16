import java.io.*;

/**
 * Created by soffietto on 15.11.16.
 */
public class LowerToUpperAndUppertToLowerReader extends FilterReader {

    protected LowerToUpperAndUppertToLowerReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if(c <=90 && c >=65){
            return Character.toLowerCase(c);
        }else if(c <=122 && c>=97) {
            return Character.toUpperCase(c);
        }
        return c;
    }
}
