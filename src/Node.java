import java.io.Serializable;

public class Node implements Serializable {
    int f;
    int l;

    int[] ans;

    public Node(int f, int l) {
        this.f = f;
        this.l = l;
    }
}
