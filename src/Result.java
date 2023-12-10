import java.text.DecimalFormat;

public class Result {
    public Result(String calcString, String CurrencyString) {
    }

    public void output(String calcString, String CurrencyString) {
        String tempString = calcString
                .replaceAll(substringToRemove1, substringToReplaceWith)
                .replaceAll(substringToRemove2, substringToReplaceWith)
                .replaceAll(substringToRemove3, substringToReplaceWith)
                .replaceAll(substringToRemove4, substringToReplaceWith)
                .replaceAll(substringToRemove5, substringToReplaceWith)
                .replaceAll(regexRubleSymbol, substringToReplaceWith);
        tempString = tempString.replaceAll(regexEmptySymbol, substringToReplaceWith);
        String[] splitString = tempString.split(regexMathSymbols);
        double result = Double.parseDouble(splitString[0]);

        for (int i = 1; i < splitString.length; i++) {
            char operator = splitString[i].charAt(0);
            double operand = Double.parseDouble(splitString[i].substring(1));

            if (operator == operatorPlus) {
                result += operand;
            } else if (operator == operatorMinus) {
                result -= operand;
            }
        }

        DecimalFormat format = new DecimalFormat(decimalFormat);
        String formattedResult = format.format(result);

        if (CurrencyString.startsWith(currencyDollar)) {
            System.out.println(resultString + regexDollarSymbol + formattedResult);
        }
        if (CurrencyString.startsWith(currencyRuble)) {
            System.out.println(resultString + formattedResult + regexRubleSymbol);
        }
    }

    private static final String substringToRemove1 = "toRuble";
    private static final String substringToRemove2 = "toDollar";
    private static final String substringToRemove3 = "\\(";
    private static final String substringToRemove4 = "\\)";
    private static final String substringToRemove5 = "\\$";
    private static final String substringToReplaceWith = "";
    private static final String regexEmptySymbol = "\\s";
    private static final String regexMathSymbols = "(?=[-+])";
    private static final char operatorPlus = '+';
    private static final char operatorMinus = '-';
    private static final String currencyDollar = "Dollar";
    private static final String currencyRuble = "Ruble";
    private static final String regexRubleSymbol = "р";
    private static final String regexDollarSymbol = "$";
    private static final String resultString = "Result: ";
    private static final String decimalFormat = "#.##";
}