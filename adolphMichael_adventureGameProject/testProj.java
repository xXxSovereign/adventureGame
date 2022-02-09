package adolphMichael_adventureGameProject;

public class testProj {
    private int x,y;
    private String name;

    public testProj(int n, int n2, String str){

        x = n;
        y = n2;
        name = str;
    }

    int sum(){
        return x + y;
    }

    void changeX(int n){
        x = n;
    }

    void changeY(int n){
        y = n;
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }

    String getName(){
        return name;
    }

}
