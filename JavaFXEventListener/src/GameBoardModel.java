public class GameBoardModel 
{
    private boolean[][] towelPositions;
    
    // Initialisierung entsprechend der in der UI festgelegten 
    // Spalten und Zeilenanzahl (variable Spielfeldgröße)
    public void initializeBoard(int columns, int rows)
    {
        towelPositions = new boolean[6][7];
        for (int i = 0; i < 6; i++) 
        {
            for (int j = 0; j < 7; j++) 
            {
                towelPositions[i][j] = false;
            }            
        }
    }

    public boolean[][] getTowelPositions()
    {
        return towelPositions;
    } 

    public void blockPosition(int x, int y)
    {
        towelPositions[x][y] = true;
    }
}
