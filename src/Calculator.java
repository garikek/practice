import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public Calculator(double dollarCourse, double rubleCourse, String inputString) {
        this.dollarCourse = dollarCourse;
        this.rubleCourse = rubleCourse;
        this.inputString = inputString;
    }

    private void toDollar() {
        String calcString = inputString;
        Pattern pattern = Pattern.compile(rublePattern);
        Matcher matcher = pattern.matcher(calcString);

        while (matcher.find()) {
            String match = matcher.group();
            if (match.endsWith(rubleSymbol)) {
                int amount = Integer.parseInt(match.substring(0, match.length() - 1));
                calcString = calcString.replace(match, String.valueOf(amount * rubleCourse));
            }
        }

        Result result = new Result(calcString, currencyDollar);
        result.output(calcString, currencyDollar);
    }

    private void toRuble() {
        String calcString = inputString;
        Pattern pattern = Pattern.compile(dollarPattern);
        Matcher matcher = pattern.matcher(calcString);

        while (matcher.find()) {
            String match = matcher.group();
            if (match.startsWith(dollarSymbol)) {
                int amount = Integer.parseInt(match.substring(1));
                calcString = calcString.replace(match, String.valueOf(amount * dollarCourse));
            }
        }

        Result result = new Result(calcString, currencyRuble);
        result.output(calcString, currencyRuble);
    }

    public void convert() {
        double result;
        if (inputString.startsWith(dollarLine)) {
            toDollar();
        } else if (inputString.startsWith(rubleLine)) {
            toRuble();
        } else {
            System.out.println(inputError);
        }
    }
    private final double dollarCourse;
    private final double rubleCourse;
    private final String inputString;
    private static final String dollarLine = "toDollar";
    private static final String rubleLine = "toRuble";
    private static final String inputError = "Input error";
    private static final String currencyDollar = "Dollar";
    private static final String currencyRuble = "Ruble";
    private static final String dollarPattern = "\\$\\d+";
    private static final String rublePattern = "\\d+р";
    private static final String rubleSymbol = "р";
    private static final String dollarSymbol = "$";
}