import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {

    private boolean checkFile() {
        File file = new File(FileReader.folderPath, FileReader.fileName);
        return file.exists();
    }

    private double parseFile(String line, String regexLine) {
        Pattern pattern = Pattern.compile(regexLine);
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            return Double.parseDouble(matcher.group(1));
        } else {
            return -1;
        }
    }
    public void readFile(String inputString) {
        double dollarCourse = 0;
        double rubleCourse = 0;
        String dollar;
        String ruble;

        if (!checkFile()) {
            System.out.println(fileError);
            System.exit(0);
        }

        try (Scanner scanner = new Scanner(new File(folderPath, fileName))) {
            if (scanner.hasNextLine()) {
                dollar = scanner.nextLine();
                dollarCourse = parseFile(dollar, regexDollar);
            }

            if (scanner.hasNextLine()) {
                ruble = scanner.nextLine();
                rubleCourse = parseFile(ruble, regexRuble);
            }

            Calculator converter = new Calculator(dollarCourse, rubleCourse, inputString);
            converter.convert();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String folderPath = "C:\\Users\\pr0st04uvak\\Desktop\\modsen\\src";
    private static final String fileName = "course.txt";
    private static final String fileError = "File doesn't exist";
    private static final String regexRuble = "^\\р(\\d+(\\.\\d+)?)$";
    private static final String regexDollar = "^\\$(\\d+(\\.\\d+)?)$";
}