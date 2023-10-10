package playfair;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static PlayFairKodolo pfKodolo = null;

    public static void main(String[] args) {
        try {
            pfKodolo = new PlayFairKodolo("kulcstabla.txt");
        } catch (IOException e) {
            System.out.println("Hibás fájl!");
            throw new RuntimeException(e);
        }

        System.out.print("6. feladat: Kérek egy nagybetűt: ");
        Scanner sc = new Scanner(System.in);
        String beKarakter = sc.nextLine();
        System.out.println("A karakter sorának indexe: " + pfKodolo.sorIndex(beKarakter.charAt(0)));
        System.out.println("A karakter oszlopának indexe: " + pfKodolo.oszlopIndex(beKarakter.charAt(0)));

        System.out.print("8. feladat: Kérek egy karakterpárt: ");
        String beKarPar = sc.nextLine();
        System.out.println("Kódolva: " + pfKodolo.kodolBetuPar(beKarPar));
    }
}
