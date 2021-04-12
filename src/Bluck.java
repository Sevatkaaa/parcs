import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import parcs.*;

public class Bluck {


    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("MyClass.jar");
        List<String> data = readData(curtask.findFile("input"));
        int n = data.size();

        AMInfo info = new AMInfo(curtask, null);
        List<channel> channels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            point p = info.createPoint();
            channel c = p.createChannel();
            channels.add(c);
            p.execute("MyClass");
        }
        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            channels.get(i).write(data.get(i));
        }

        System.out.println(((System.nanoTime() - startTime) / 1000000) + " ms took");

        for (int i = 0; i < n; i++) {
            String ans = (String) channels.get(i).readObject();
            System.out.println(ans);
        }
        long stopTime = System.nanoTime();
        System.out.println("End of task");
        curtask.end();
    }

    public static List<String> readData(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));
        List<String> data = new ArrayList<>();
        while (sc.hasNext()) {
            data.add(sc.next());
        }
        return data;
    }
}
