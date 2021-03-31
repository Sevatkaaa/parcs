import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import parcs.*;

public class Bluck {

    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("MyClass.jar");
        int n = readData(curtask.findFile("input"));

        List<channel> channels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            AMInfo info = new AMInfo(curtask, null);
            point p = info.createPoint();
            channel c = p.createChannel();
            p.execute("MyClass");
            channels.add(c);
            c.write(i);
        }

        for (int i = 0; i < channels.size(); i++) {
            channel channel = channels.get(i);
            System.out.println(channel.readInt());
        }
        curtask.end();
    }

    public static int readData(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));
        return sc.nextInt();
    }
}
