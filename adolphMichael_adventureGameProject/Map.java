public class Map{
  private char[5][5] worldMap = { 'x', 'x', 'x', 'x', 'x' },
                        { 'x', 'x', 'x', 'x', 'x' },
                        { 'x', 'x', 'C', 'x', 'x' },
                        { 'x', 'x', 'x', 'x', 'x' },
                        { 'x', 'x', 'x', 'x', 'x' };
  

  void displayMap(){

    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        System.out.print(worldMap[i][j])
      } System.out.println();
    }   

  }

}