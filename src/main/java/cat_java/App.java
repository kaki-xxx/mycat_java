package cat_java;

public class App {
    public static void main(String[] args) {
        var dc = new DoerCat();
        if (args.length < 1) {
            System.err.println("required: least one file path");
            System.exit(-1);
        }
        dc.do_cat(args);
    }
}
