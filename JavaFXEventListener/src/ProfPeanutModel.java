public class ProfPeanutModel 
{
    // Spielerposition am Anfang auf Spalte 0, Reihe 0
    private int[] playerPosition = {0, 0};
    private double progress = 0;

    public int getPlayerXPosition()
    {
        return playerPosition[0];
    }

    public int getPlayerYPosition()
    {
        return playerPosition[1];
    }

    public double getProgress()
    {
        return progress;
    }

    public void setPlayerXPosition(int xPosition)
    {
        playerPosition[0] = xPosition;
    }

    public void setPlayerYPosition(int yPosition)
    {
        playerPosition[1] = yPosition;
    }  

    public void setProgress(double progress)
    {
        this.progress = progress;
    }
}
