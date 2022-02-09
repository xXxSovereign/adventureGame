package adolphMichael_adventureGameProject;

public class main {
    public static void main(String[] args) {
        testProj test = new testProj(7, 3, "Bobby");
        System.out.println(test.sum() + "\n" + test.getName());

        testProj test2 = new testProj(4, 1, "LOL");
        System.out.println(test2.sum() + "\n" + test2.getName());

    }

}
