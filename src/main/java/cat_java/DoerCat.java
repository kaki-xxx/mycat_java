package cat_java;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DoerCat {
    private Boolean _dispLineNum;
    private int _lineNum;
    DoerCat(Boolean lineNum) {
        _dispLineNum = lineNum;
        _lineNum = 1;
    }
    public void do_cat(String[] paths) {
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
                do_cat_file(br);
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }
        }
    }

    public void do_cat_file(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            if (_dispLineNum) {
                System.out.printf("%6d  ", _lineNum);
                _lineNum++;
            }
            System.out.println(line);
        }
    }
}
