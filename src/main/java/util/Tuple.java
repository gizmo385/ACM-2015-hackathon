package util;

/**
 * Created by jkoike on 4/10/15.
 */
public class Tuple<S, U> {
    public final S one;
    public final U two;
    public Tuple(S one, U two){
        this.one = one;
        this.two = two;
    }
}
