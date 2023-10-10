package playfair;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PlayFairKodolo {
    private char[][] kodtabla;

    public PlayFairKodolo(String fajlNev) throws IOException {
        kodtabla = new char[5][5];
        BufferedReader br = new BufferedReader(new FileReader(fajlNev));
        for (int i = 0; i < 5; i++) {
            String sor = br.readLine();
            for (int j = 0; j < sor.length(); j++) {
                kodtabla[i][j] = sor.charAt(j);
            }
        }
        br.close();
    }

    public int sorIndex(char keres) {
        int ered = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (kodtabla[i][j] == keres) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int oszlopIndex(char keres) {
        int ered = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (kodtabla[i][j] == keres) {
                    return j;
                }
            }
        }
        return -1;
    }

    private int kovetkezo(int index) {
        index++;
        if (index > 4) {
            return 0;
        }
        return index;
    }

    public String kodolBetuPar(String bp) {
        String ered = "";
        char betu1 = bp.charAt(0);
        char betu2 = bp.charAt(1);
        int sorB1 = sorIndex(betu1);
        int oszlopB1 = oszlopIndex(betu1);
        int sorB2 = sorIndex(betu2);
        int oszlopB2 = oszlopIndex(betu2);

        if (sorB1 == sorB2) {
            ered += kodtabla[sorB1][kovetkezo(oszlopB1)];
            ered += kodtabla[sorB1][kovetkezo(oszlopB2)];
        } else if (oszlopB1 == oszlopB2) {
            ered += kodtabla[kovetkezo(sorB1)][oszlopB1];
            ered += kodtabla[kovetkezo(sorB2)][oszlopB1];
        } else {
            ered += kodtabla[sorB1][oszlopB2];
            ered += kodtabla[sorB2][oszlopB1];
        }
        return ered;
    }
}
