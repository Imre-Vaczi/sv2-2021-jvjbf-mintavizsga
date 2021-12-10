package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OwlCounter {

    private List<String> owlsPerCounty = new ArrayList<>();

    public void readFromFile(Path path) {
        try {
            owlsPerCounty = Files.readAllLines(path);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file.");
        }
    }

    public int getNumberOfOwls(String county) {
        if (!isCountyValid(county)) {
            throw new IllegalArgumentException("No such county in Hungary!");
        }
        int result = 0;
        for (String line : owlsPerCounty) {
            if (line.split("=")[0].equals(county)) {
                result += Integer.parseInt(line.split("=")[1]);
            }
        }
        return result;
    }

    public int getNumberOfAllOwls() {
        int result = 0;
        for (String line : owlsPerCounty) {
                result += Integer.parseInt(line.split("=")[1]);
            }
        return result;
        }

    private boolean isCountyValid(String county) {
        for (String data : owlsPerCounty) {
            if (data.split("=")[0].equals(county)) {
                return true;
            }
        }
        return false;
    }
}
