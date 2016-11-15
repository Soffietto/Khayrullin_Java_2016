import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by soffietto on 15.11.16.
 */
public class LowerToUpperAndUppertoLowerInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerToUpperAndUppertoLowerInputStream(InputStream in) {
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
