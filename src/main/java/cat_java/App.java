package cat_java;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

public class App {
    public static void main(String[] args) {
        var options = new Options();
        options.addOption("n", false, "number all output lines");
        options.addOption(null, "help", false, "display this help and exit");
        CommandLine cmd = null;
        try {
            cmd = new DefaultParser().parse(options, args);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        if (cmd.hasOption("help")) {
            var formatter = new HelpFormatter();
            formatter.setOptionComparator(null);
            String usage = "java -jar target/cat_java-0.1-jar-with-dependencies.jar [OPTION]... [FILE]...";
            String header = "Concatenate FILE(s) to standard output.";
            formatter.printHelp(usage, header, options, null);
            System.exit(0);
        }
        var dc = new DoerCat(cmd.hasOption("n"));
        if (args.length < 1) {
            System.err.println("required: least one file path");
            System.exit(-1);
        }
        dc.do_cat(cmd.getArgs());
    }
}
