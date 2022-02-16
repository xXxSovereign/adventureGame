package adolphMichael_adventureGameProject;

import java.util.Random;
import java.util.Hashtable;
import java.util.Collections;

public class Map {

    private String[][] worldMap;

    private String[][] worldMapDiscovered;


// color codes: https://www.codeproject.com/Tips/5255355/How-to-Put-Color-on-Windows-Console

    public Map(int size) {

        worldMap = new String[size][size];
        worldMapDiscovered = new String[size][size];

        for (int i = 1; i < worldMap.length - 2; i++) {
            for (int j = 1; j < worldMap.length - 2; j++) {
                worldMap[i][j] = "x";
            }
        }
        worldMap[(worldMap.length - 2)/2][(worldMap.length - 2)/2] = "\033[97mC";

        String f = "\033[92mf"; // forest - Light Green
        String m = "\033[91mm"; // mine - Light Red
        String M = "\033[95mM"; // Mega-building - Light Magenta
        String t = "\033[93mt"; // town - Light Yellow
        String T = "\033[97mT"; // Temple - White
        String p = "\033[97m%"; // % - White
        String d = "\033[94md"; // den - Light Blue


        // locations with weights, that's why there are multiples
        Random rand = new Random();
        String locChoice;
        String[] outerLocs = {"\033[95mX"};

        Hashtable<String, Integer> counts = new Hashtable<String, Integer>();

        counts.put("Mega-building", 0);
        counts.put("Special", 0);


        for (int i = 1; i < worldMap.length - 1; i++) {
            for (int j = 1; j < worldMap.length - 1; j++) {
                locChoice = outerLocs[rand.nextInt(outerLocs.length)];
                switch (locChoice) {
                    case "\033[95mM" -> counts.put("Mega-building", counts.get("Mega-building") + 1);
                }

                if (i == (worldMap.length - 2)/2 && j == (worldMap.length-2)/2) { continue; }

                if ((locChoice.equals("\033[97mT") || locChoice.equals("\033[97m%")) && (counts.get("Special") < 9)) {
                    counts.put("Special", counts.get("Special") + 1);
                    System.out.println(locChoice + " : " + counts.get("Special"));
                    worldMapDiscovered[i][j] = locChoice;
                    continue;

                } else if ((locChoice.equals("\033[97mT") || locChoice.equals("\033[97m%")) && (counts.get("Special") >= 9)) {
                    j--;
                    continue;
                }
                worldMapDiscovered[i][j] = locChoice;
            }

        }
        //for (int i = 0; i < 5; i++){ shuffle(worldMapDiscovered); }
        //worldMapDiscovered[(worldMap.length - 1)/2][(worldMap.length - 1)/2] = "\033[97m\033[4mC\033[24m";

        for (int i = 1; i < worldMap.length - 1; i++){
            for (int j = 1; j < worldMap.length - 1; j++){
                if (worldMapDiscovered[i][j] == null){
                    worldMapDiscovered[i][j] = outerLocs[rand.nextInt(outerLocs.length)];
                }
            }
        }

        for (int i = 0; i < worldMap.length; i++){
            for (int j = 0; j < worldMap.length; j++){
                if (worldMapDiscovered[i][j] == null){
                    worldMapDiscovered[i][j] = "\033[30m\u2588\033[30m\u2588";
                }
            }
        }

        counts.forEach(
                (k, v) -> System.out.println("Key : " + k + ", Value : " + v));
    }

    void displayMap(){
        for (String[] strings : worldMap) {
            for (int j = 0; j < worldMap.length; j++) {
                System.out.print(strings[j] + "  ");
            }
            System.out.println();
        }
    }

    void displayMapDiscovered(){
        for(int i = 0; i < worldMap.length; i++){
            for(int j = 0; j < worldMap.length; j++){
                if (i == 0 || i > 37) {System.out.print("\033[30m\u2588\033[30m\u2588\033[30m\u2588"); continue;}
                System.out.print(worldMapDiscovered[i][j] + "  ");
            } System.out.println();
        }
    }

    void shuffle(String[][] a) {
        Random random = new Random();

        for (int i = a.length - 1; i > 0; i--) {
            for (int j = a[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);

                String temp = a[i][j];
                a[i][j] = a[m][n];
                a[m][n] = temp;
            }
        }
    }
}