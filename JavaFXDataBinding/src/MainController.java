import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainController 
{    
    @FXML 
    Text txtShowInput;   

    @FXML
    TextField txtFieldFirstName;

    @FXML
    TextField txtFieldLastName;

    @FXML 
    Button btnDelete;

    // Die Methode überschreibt die initialize() von Java FX
    // und wird automatisch nach dem Konstruktor aufgerufen.
    // Da der Controller automatisch von Java FX aufgerufen 
    // wird, muss das Objekt nicht gebaut werden
    // In der Methode wird einmalig das Data Binding initialisiert

    public void initialize()
    {
        txtShowInput.textProperty().bind(txtFieldFirstName.textProperty().concat(" ").concat(txtFieldLastName.textProperty()));        
    }   

    @FXML
    private void deleteInputs(ActionEvent e)
    {
        txtFieldFirstName.setText("");
        txtFieldLastName.setText("");
    }
}
