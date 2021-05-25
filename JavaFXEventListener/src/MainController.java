import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class MainController 
{    
    // Deklaration der initialen Spielerposition, der Matrix zum Speichern der belegten
    // Felder und des Fortschritts der belegten Felder.
    private GameBoardModel gameboard;
    private ProfPeanutModel player;

    @FXML 
    Text txtInput;       

    @FXML 
    Button btnUp, btnDown, btnLeft, btnRight, btnFire;

    @FXML
    GridPane playGrid;

    @FXML
    ImageView imgProfPeanut;

    @FXML
    ProgressBar pbPlayerProgress;

    // Initialisierung der benötigten models
    @FXML
    public void initialize()
    {
        gameboard = new GameBoardModel();
        player = new ProfPeanutModel(); 
        gameboard.initializeBoard(playGrid.getColumnCount(), playGrid.getRowCount());        
    }
   
    // Methode die auf alle Buttons (links, rechts, oben, unten, fire)
    // hört und die entsprechenden Manipulationen der Spielerposition
    // vornimmt und diese anschließend durch den Methodenaufruf 
    // updateCharacterPosition auf dem Brett aktualisiert
    @FXML
    private void buttonPressed(ActionEvent e)
    {
        int currentX = player.getPlayerXPosition();
        int currentY = player.getPlayerYPosition();
        var button = (Button)e.getSource();

        if (button.equals(btnFire))
        {
            placeTowel();
            pbPlayerProgress.setProgress(player.getProgress());
            return;
        }
        else if (button.equals(btnLeft) && currentX - 1 >= 0)        
            player.setPlayerXPosition(currentX - 1);
        
        else if (button.equals(btnRight) && currentX + 1 <= 5)        
            player.setPlayerXPosition(currentX + 1); 
        
        else if (button.equals(btnUp) && currentY - 1 >= 0)        
            player.setPlayerYPosition(currentY - 1); 
        
        else if (button.equals(btnDown) && currentY + 1 <= 6)        
            player.setPlayerYPosition(currentY + 1);
               
        updateCharacterPosition();        
    }

    // analog zur Methode darüber passiert hier das gleiche, allerdings
    // mit einem Eventlistener für alle Keyboardinputs um dem Nutzer
    // alternativ die Möglichkeit zu bieten mit den Tasten zu steuern
    @FXML
    private void getKeyEvents(KeyEvent key)
    {
        int currentX = player.getPlayerXPosition();
        int currentY = player.getPlayerYPosition();
        var keyCode = key.getCode();

        if (keyCode == KeyCode.ENTER || keyCode == KeyCode.SPACE)
        {
            placeTowel();
            pbPlayerProgress.setProgress(player.getProgress());
            return;
        }
        else if (keyCode == KeyCode.LEFT && currentX - 1 >= 0)        
            player.setPlayerXPosition(currentX - 1);
        
        else if (keyCode == KeyCode.RIGHT && currentX + 1 <= 5)        
            player.setPlayerXPosition(currentX + 1);            
        
        else if (keyCode == KeyCode.UP && currentY - 1 >= 0)        
            player.setPlayerYPosition(currentY - 1);            
        
        else if (keyCode == KeyCode.DOWN && currentY + 1 <= 6)        
            player.setPlayerYPosition(currentY + 1);
                
        updateCharacterPosition();
    }

    // Die Position des Bildes (Spieleravatar) wird genutzt um das
    // Bild an der ensprechenden Position im Grid zu platzieren und
    // an der alten Position zu löschen
    private void updateCharacterPosition()
    {
        playGrid.getChildren().remove(imgProfPeanut);       
        playGrid.add(imgProfPeanut, player.getPlayerXPosition(), player.getPlayerYPosition());
    }

    // Methode zum Platzieren des Handtuchs, in der unter anderem
    // geprüft wird, ob an der Stelle im Raster schon ein Handtuch
    // 'liegt'. Dies geschieht anhand der Matrix im Model in der 
    // die Positionen abgebildet sind
    private void placeTowel()
    {
        int currentX = player.getPlayerXPosition();
        int currentY = player.getPlayerYPosition();
        boolean positionBlocked[][] = gameboard.getTowelPositions();
        var image = new Image("ressources\\beach-towel.png", 80, 80, false, false);
        var imgTowel = new ImageView(image);  
        
        if (!positionBlocked[currentX][currentY])
        {
            playGrid.add(imgTowel, currentX, currentY);     
            player.setProgress(player.getProgress() + 0.023809);   
            gameboard.blockPosition(currentX, currentY);
            imgTowel.toBack();
        }
    }  
}
