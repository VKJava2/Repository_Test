import java.util.Random;
import java.util.Scanner;

public class Ugadajka {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner scanner = new Scanner(System.in);
		int chislo = r.nextInt(101);
		int maxOgranichitelj = 100;
		int minOgranichitelj = 1;
		String s;

		do {
			System.out.println("Vi zagadali eto chislo? = " + chislo);
			s = scanner.nextLine();
			if (s.equals(">")) {
				chislo = r.nextInt((maxOgranichitelj - chislo) + 1) + chislo;
			} else if (s.equals("<")) {
				chislo = r.nextInt((chislo - minOgranichitelj) + 1);
			}

		} while (!s.equals("="));

		System.out.print("Chislo ugadano!: " + chislo);
		scanner.close();
	}
}
