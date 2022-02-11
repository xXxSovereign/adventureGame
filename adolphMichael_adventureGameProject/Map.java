package adolphMichael_adventureGameProject;

import java.util.Random;
import java.util.Hashtable;
import java.util.concurrent.BlockingDeque;

public class Map {

    private String[][] worldMap = new String[11][11];

    private String[][] worldMapDiscovered = new String[11][11];


// color codes: https://www.codeproject.com/Tips/5255355/How-to-Put-Color-on-Windows-Console

    public Map() {

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                worldMap[i][j] = "x";
            }
        }
        worldMap[5][5] = "\033[97mC";

        String f = "\033[92mf"; // forest - Light Green
        String m = "\033[91mm"; // mine - Light Red
        String M = "\033[37mM"; // Mountain - Light Grey
        String t = "\033[93mt"; // town - Light Yellow
        String T = "\033[97mT"; // Temple - White
        String p = "\033[97m%"; // % - White
        String d = "\033[94md"; // den - Light Blue

        String[] standLocs = {t, t, m, m, f, f, f, f, f, f, f, f, M, M, M, M,
                d, d, d, d, d, T, p};
        // locations with weights, that's why there are multiples
        Random rand = new Random();

        String locChoice;

        Hashtable<String, Integer> counts = new Hashtable<String, Integer>();
        counts.put("forest", 0);
        counts.put("mine", 0);
        counts.put("Mountain", 0);
        counts.put("town", 0);
        counts.put("Special", 0);
        counts.put("den", 0);

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                locChoice = standLocs[rand.nextInt(standLocs.length)];
                switch (locChoice) {
                    case "\033[92mf" -> counts.put("forest", counts.get("forest") + 1);
                    case "\033[91mm" -> counts.put("mine", counts.get("mine") + 1);
                    case "\033[93mt" -> counts.put("town", counts.get("town") + 1);
                    case "\033[94md" -> counts.put("den", counts.get("den") + 1);
                }

                if ((locChoice.equals("\033[97mT") || locChoice.equals("\033[97m%")) && (counts.get("Special") < 4)) {
                    counts.put("Special", counts.get("Special") + 1);
                    System.out.println(locChoice + " : " + counts.get("Special"));
                    worldMapDiscovered[i][j] = locChoice;
                    continue;

                } else if ((locChoice.equals("\033[97mT") || locChoice.equals("\033[97m%")) && (counts.get("Special") >= 4)) {
                    j--;
                    continue;
                }
                worldMapDiscovered[i][j] = locChoice;
            }
            worldMapDiscovered[5][5] = "\033[97m\033[4mC\033[24m";

        }
        counts.forEach(
                (k, v) -> System.out.println("Key : " + k + ", Value : " + v));
    }

    void displayMap(){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                System.out.print(worldMap[i][j] + " ");
            } System.out.println();
        }
    }

    void displayMapDiscovered(){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                System.out.print(worldMapDiscovered[i][j] + " ");
            } System.out.println();
        }
    }
}