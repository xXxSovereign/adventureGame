package adolphMichael_adventureGameProject;

public class main {
    public static void main(String[] args) {
        Weapon sword = new Weapon(5, "Sharp", "Blunt Sword");
        Player player = new Player("Jogn");

        for (int i = 0; i < 2589; i++){
            System.out.print("");
        }
        Map map = new Map(39);
        map.displayMapDiscovered();



    }

}
