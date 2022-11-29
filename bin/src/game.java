import java.util.ArrayList;
import java.util.Random;

public class game {

    private int[][] gameBoard;
    private Random r=new Random();

    public game(){
        gameBoard=new int[4][4];
        addNewNumbers();
        addNewNumbers();
    }

    public int[][] getGameBoard(){
        return gameBoard;
    }

    public void printArray(){
        for(int[] x:gameBoard)
            System.out.format("%6d%6d%6d%6d%n", x[0],x[1],x[2],x[3]);

        System.out.format("%n");
    }

    public void addNewNumbers() {
        ArrayList<Integer> emptySpacesX = new ArrayList<Integer>();
        ArrayList<Integer> emptySpacesY = new ArrayList<Integer>();
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
             if(gameBoard[x][y]==0){
                 emptySpacesX.add(new Integer(x));
                 emptySpacesY.add(new Integer(y));
             }
            }
        }
        int choice = r.nextInt(emptySpacesX.size());
        int numberChooser =r.nextInt(10);//value 0-9
        int newNumber =1;
        if(numberChooser == 0) newNumber=2;

        int X=emptySpacesX.get(choice);
        int Y=emptySpacesY.get(choice);
        gameBoard[X][Y]= newNumber;

    }
    public void pushUp()
    {
        System.out.println("Pushing Up...");


        for (int y = 0 ; y < 4 ; y++)
        {
            boolean[] alreadyCombined = {false, false, false, false};
            for(int x = 1 ; x < 4 ; x++)
            {
               if(gameBoard[x][y] != 0)
               {
                   int value = gameBoard[x][y];
                   int X=x-1;
                   while((X>=0) && (gameBoard[X][y]==0)){
                       X--;
                   }
                   if (X==-1){
                       gameBoard[0][y]=value;
                       gameBoard[x][y]=0;

                   } else if (gameBoard[X][y] != value) {
                       gameBoard[x][y] = 0;
                       gameBoard[X+1][y]=value;


                   }
                   else {
                       if(alreadyCombined[X]){
                           gameBoard[x][y] = 0;
                           gameBoard[X+1][y]=value;
                          // gameBoard[x][y]=0;
                       }
                       else {
                           gameBoard[x][y] = 0;
                           gameBoard[X][y] *= 2;
                           alreadyCombined[X] = true;
                         //  gameBoard[x][y] = 0;
                       }
                   }
               }
            }
        }
    }

    public void pushDown()
    {
        System.out.println("Pushing Down...");

        for (int y = 0 ;y < 4; y++)
        {
            boolean[] alreadyCombined = { false, false, false, false };
            for(int x = 2;x > -1 ; x--)
            {
                if(gameBoard[x][y] != 0)
                {
                    int value=gameBoard[x][y];
                    int X=x+1;
                    while((X<=3) && (gameBoard[X][y]==0)){
                        X++;
                    }
                    if (X==4){
                        gameBoard[3][y]=value;
                        gameBoard[x][y]=0;
                    } else if (gameBoard[X][y]!= value) {
                        gameBoard[x][y] = 0;
                        gameBoard[X-1][y]=value;
                       // gameBoard[x][y]=0;

                    }
                    else {
                        if(alreadyCombined[X]){
                           // System.out.println("i combined");
                           // System.out.println(X);
                            gameBoard[x][y] = 0;
                            gameBoard[X-1][y]=value;
                           // gameBoard[x][y]=0;
                        }
                        else {
                            gameBoard[x][y] = 0;
                            gameBoard[X][y] *= 2;
                            alreadyCombined[X] = true;
                           // System.out.println("i true");
                            //gameBoard[x][y] = 0;
                        }
                    }
                }
            }
        }
    }

    public void pushLeft()
    {
        System.out.println("Pushing Left...");
        for (int x = 0 ;x < 4; x++)
        {
            boolean[] alreadyCombined = { false, false, false, false };

            for(int y = 1 ;y < 4 ; y++)
            {
                if(gameBoard[x][y] != 0)
                {
                    int value=gameBoard[x][y];
                    int Y = y - 1;
                    while((Y >= 0) && (gameBoard[x][Y] == 0)){
                        Y--;
                    }
                    if (Y == -1){
                        gameBoard[x][0]=value;
                        gameBoard[x][y]=0;
                    } else if (gameBoard[x][Y] != value) {
                        gameBoard[x][y] = 0;
                        gameBoard[x][Y+1]=value;
                       // gameBoard[x][y]=0;

                    }
                    else {
                        if(alreadyCombined[Y]){
                            // System.out.println("i combined");
                            // System.out.println(X);
                            gameBoard[x][y] = 0;
                            gameBoard[x][Y + 1]=value;
                         //   gameBoard[x][y]=0;
                        }
                        else {
                            gameBoard[x][y] = 0;
                            gameBoard[x][Y] *= 2;
                            alreadyCombined[Y] = true;
                            // System.out.println("i true");
                            //gameBoard[x][y] = 0;
                        }
                    }
                }
            }
        }
    }

    public void pushRight()
    {
        System.out.println("Pushing Right...");
        for (int x = 0 ;x < 4; x++)
        {
            boolean[] alreadyCombined = { false, false, false, false };

            for(int y = 2 ;y > -1 ; y--)
            {
                if(gameBoard[x][y] != 0)
                {
                    int value=gameBoard[x][y];
                    int Y=y + 1;
                    while((Y<=3) && (gameBoard[x][Y]==0)){
                        Y++;
                    }
                    if (Y==4){
                        gameBoard[x][3]=value;
                        gameBoard[x][y]=0;
                    } else if (gameBoard[x][Y] != value) {
                        gameBoard[x][y] = 0;
                        gameBoard[x][Y-1]=value;
                        //gameBoard[x][y]=0;

                    }
                    else {
                        if(alreadyCombined[Y]){
                            // System.out.println("i combined");
                            // System.out.println(X);
                            gameBoard[x][y] = 0;
                            gameBoard[x][Y - 1]=value;
                           // gameBoard[x][y]=0;
                        }
                        else {
                            gameBoard[x][y] = 0;
                            gameBoard[x][Y] *= 2;
                            alreadyCombined[Y] = true;
                            // System.out.println("i true");
                          //  gameBoard[x][y] = 0;
                        }
                    }
                }
            }
        }
    }



}
