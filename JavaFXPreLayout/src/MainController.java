import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MainController 
{
    private int incrementThis = 0;    

    // Deklaration des Textelements, wichtig hier der selbe Name wie die ID
    // in der XML und der Decorator über dem Namen. Das Element muss in der
    // Controllerklasse deklariert werden, die dieser Scene in der XML zuge-
    // wiesen wird.
    @FXML 
    Text txtIncrement;

    // Deklaration des Eventlisteners, auch hier muss der Name unbedingt 
    // mit dem in der XML definierten übereinstimmen!
    @FXML
    private void buttonClick(ActionEvent e)
    {
        incrementThis++;
        txtIncrement.setText(String.valueOf(incrementThis));
    }    
}
