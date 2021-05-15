package cat_java;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("required: least one file path");
            System.exit(-1);
        }
        DoerCat.do_cat(args[0]);
    }
}
