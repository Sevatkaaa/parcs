import parcs.*;

public class MyClass implements AM {
    public void run(AMInfo info) {
        int n = info.parent.readInt();
        System.out.println("Build started.");
        System.out.println("Build finished.");
        if (isPal(n)) {
            info.parent.write(n);
        }
    }

    private boolean isPal(int n) {
        String s = String.valueOf(n);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
