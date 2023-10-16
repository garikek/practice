import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final double EXCHANGE_RATE = 60.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input example: $10 + 500p - $15 rubles");
        String[] input = scanner.nextLine().split(" ");

//        String tempe=input[0];
//        String[] temp =tempe.split(" ");
//        double dollars = Double.parseDouble(temp[0].substring(1));
//        double rubles=dollars*EXCHANGE_RATE;
//        System.out.println(Double.toString(rubles));
//        input[0] = toRubles(input[0]);
//        System.out.println(input[0]);

//        System.out.println(Arrays.toString(temps));

        if (Objects.equals(input[input.length-1], "rubles")) {
            for (int i = 0; i < input.length - 1; i += 2) {
                if(input[i].startsWith("$")){
                    input[i] = toRubles(input[i]);
                }
            }
        } else if (Objects.equals(input[input.length-1], "dollars")) {
            for (int i = 0; i < input.length - 2; i += 2) {
                if (input[i].endsWith("p")){
                    input[i]= toDollars(input[i]);
                }
            }
        } else {
            System.out.println("Invalid input on conversion");
            return;
        }

        Double result=0.0;


        for (int i=1;i< input.length-2;i+=2){
            if (Objects.equals(input[i], "+")){
                result+=addition(input[i-1], input[i+1]);
                if(Objects.equals(input[input.length-1], "rubles")){
                    input[i+1]=Double.toString(result)+"p";
                }
                else {
                    input[i+1]="$"+Double.toString(result);
                }
            } else if (Objects.equals(input[i], "-")) {
                result-=subtraction(input[i-1], input[i+1]);
                if(Objects.equals(input[input.length-1], "rubles")){
                    input[i+1]=Double.toString(result)+"p";
                }
                else {
                    input[i+1]="$"+Double.toString(result);
                }
            }
            else {
                System.out.println("Invalid input on addition/subtraction");
                return;
            }
        }

        System.out.println("result:");
        System.out.println(result);

    }

    public static String toRubles(String str){
        String[] temp =str.split(" ");
        double dollars = Double.parseDouble(temp[0].substring(1));
        double rubles=dollars*EXCHANGE_RATE;
        return Double.toString(rubles);
    }

    public static String toDollars(String str){
        String[] temp =str.split(" ");
        double rubles = Double.parseDouble(temp[0].substring(0, temp[0].length() - 1));
        double dollars=rubles/EXCHANGE_RATE;
        return Double.toString(dollars);
    }

    public static double addition(String str1, String str2){
        String[] temp1 =str1.split(" ");
        String[] temp2 =str2.split(" ");
        if(str1.startsWith("$")){
            double value1=Double.parseDouble(temp1[0].substring(1));
            double value2=Double.parseDouble(temp2[0].substring(1));
            return value1+value2;
        } else {
            double value1=Double.parseDouble(temp1[0].substring(0, temp1[0].length() - 1));
            double value2=Double.parseDouble(temp2[0].substring(0, temp2[0].length() - 1));
            return value1+value2;
        }
//        else {
//            System.out.println("Addition error");
//            System.out.println(Double.toString(Double.parseDouble(temp1[0].substring(0, temp1[0].length() - 1))));
//            System.out.println(Double.toString(Double.parseDouble(temp2[0].substring(0, temp2[0].length() - 1))));
//            return 666;
//        }

    }

    public static double subtraction(String str1, String str2){
        String[] temp1 =str1.split(" ");
        String[] temp2 =str2.split(" ");
        if(str1.startsWith("$")){
            double value1=Double.parseDouble(temp1[0].substring(1));
            double value2=Double.parseDouble(temp2[0].substring(1));
            return value1-value2;
        } else {
            double value1=Double.parseDouble(temp1[0].substring(0, temp1[0].length() - 1));
            double value2=Double.parseDouble(temp2[0].substring(0, temp2[0].length() - 1));
            return value1-value2;
        }
//        else {
//            System.out.println("Subtraction error");
//            return 666;
//        }
    }
}