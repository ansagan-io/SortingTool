import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hh = scanner.nextLine();
        Scanner hher = new Scanner(hh);
        while (hher.hasNext()) {
            System.out.println(hher.next());
        }
    }
}