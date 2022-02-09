package adolphMichael_adventureGameProject;

public class main {
    public static void main(String[] args) {
        Weapon sword = new Weapon(5, "Sharp", "Blunt Sword");
        Player player = new Player("Jogn");

        Map map = new Map();
        map.displayMap();
        System.out.println("\n\n\n");
        map.displayMapDiscovered();

    }

}
