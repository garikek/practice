import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        System.out.print("Input: ");
        String inputString = scannerString.nextLine();
        FileReader file = new FileReader();
        file.readFile(inputString);
    }
}
//toDollar(1234р + toRuble($56.78))