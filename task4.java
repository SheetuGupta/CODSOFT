import java.util.Scanner;

public class task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available currencies: USD, EUR, INR");

        System.out.print("Enter base currency: ");
        String base = scanner.next().toUpperCase();

        System.out.print("Enter target currency: ");
        String target = scanner.next().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        double rate = getExchangeRate(base, target);

        if (rate == 0.0) {
            System.out.println("Conversion rate not available.");
        } else {
            double converted = amount * rate;
            System.out.printf("Converted Amount: %.2f %s\n", converted, target);
        }

        scanner.close();
    }

 
    public static double getExchangeRate(String from, String to) {
        if (from.equals("USD") && to.equals("INR")) {
            return 83.0;}
        if (from.equals("INR") && to.equals("USD")) {
            return 0.012;}
        if (from.equals("USD") && to.equals("EUR")) {
            return 0.91;}
        if (from.equals("EUR") && to.equals("USD")) {
            return 1.10;}
        if (from.equals("INR") && to.equals("EUR")){
            return 0.011;}
        if (from.equals("EUR") && to.equals("INR")) {
            return 90.0;}

        return 0.0; 
    }
}
