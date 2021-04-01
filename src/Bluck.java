import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import parcs.*;

public class Bluck {

    private static final int NODES = 2;

    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("MyClass.jar");
        int n = readData(curtask.findFile("input"));

        AMInfo info = new AMInfo(curtask, null);
        List<channel> channels = new ArrayList<>();
        for (int i = 0; i < NODES; i++) {
            point p = info.createPoint();
            channel c = p.createChannel();
            channels.add(c);
            p.execute("MyClass");
        }

        channels.get(0).write(new int[]{1, n / 2});
        channels.get(1).write(new int[]{n / 2 + 1, n});

        for (int i = 0; i < channels.size(); i++) {
            channel channel = channels.get(i);
            int[] ans = (int[])channel.readObject();
            for (int j = 0; j < ans.length; j++) {
                System.out.println(ans[i]);
            }
        }
        curtask.end();
    }

    public static int readData(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));
        return sc.nextInt();
    }
}
