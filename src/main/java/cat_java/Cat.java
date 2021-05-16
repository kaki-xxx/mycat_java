package cat_java;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Cat {
    private Boolean dispLineNum;
    private int lineNum;
    Cat(Boolean displineNum) {
        this.dispLineNum = displineNum;
        this.lineNum = 1;
    }
    public void doCat(String[] paths) {
        for (var path: paths) {
            var file = new File(path);
            FileReader fr = null;
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }
            try (var br = new BufferedReader(fr)) {
                doCatFile(br);
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }
        }
    }

    public void doCatFile(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            if (dispLineNum) {
                System.out.printf("%6d  ", lineNum);
                lineNum++;
            }
            System.out.println(line);
        }
    }
}
