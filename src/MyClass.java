import parcs.*;

import java.util.ArrayList;
import java.util.List;

public class MyClass implements AM {
    public void run(AMInfo info) {
        Node node = (Node)info.parent.readObject();
        System.out.println("Build started.");
        long s = System.nanoTime();
        List<String> a = decode(node.data);
        node.data = a;
        System.out.println("ans is " + a);
        System.out.println("Build finished in " + (System.nanoTime() - s) / 1000000 + " ms");
        info.parent.write(node);
    }

    private List<String> decode(List<String> node) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < node.size(); i++) {
            ans.add(decode(node.get(i)));
        }
        return ans;
    }

        private String decode(String node) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < node.length(); i++) {
            char c = node.charAt(i);
            char ans = (char)(((c - 'A') * 9 + 7) % 26);
            sb.append(ans);
        }
        return sb.toString();
    }

}
