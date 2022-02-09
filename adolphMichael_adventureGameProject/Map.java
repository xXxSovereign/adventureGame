package adolphMichael_adventureGameProject;

import java.util.Random;

public class Map {

    private String[][] worldMap = new String[7][7];

    private String[][] worldMapDiscovered = new String[7][7];



// color codes: https://www.codeproject.com/Tips/5255355/How-to-Put-Color-on-Windows-Console

    public Map(){

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                worldMap[i][j] = "x";
            }
        }
        worldMap[3][3] = "C";

        String f = "\033[92mf\033[102m"; // forest - Light Green
        String m = "\033[91mm\033[101m"; // mine - Light Red
        String M = "\033[37mM\033[47m"; // Mountain - Light Grey
        String t = "\033t\033"; // town -
        String[] standLocs = {'t', 't', m, m, m, m, m, f, f, f, f, f, f, f, M, M, M, M,
                            'd', 'd', 'T', '%'};
        // locations with weights, that's why there are multiples
        Random rand = new Random();

        for(int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                worldMapDiscovered[i][j] = standLocs[rand.nextInt(standLocs.length)];

            }
        }
        worldMapDiscovered[3][3] = "C";

    }


    void displayMap(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(worldMap[i][j] + " ");
            } System.out.println();
        }
    }

    void displayMapDiscovered(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(worldMapDiscovered[i][j] + " ");
            } System.out.println();
        }
    }
}