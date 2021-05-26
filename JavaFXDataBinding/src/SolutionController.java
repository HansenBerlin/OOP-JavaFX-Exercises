import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SolutionController 
{    
    private boolean isBoundToAlternative = false;

    @FXML 
    Text txtShowInput, txtSecondLine;   

    @FXML
    TextField txtFieldFirstName, txtFieldLastName, txtFieldAlternativeName;    

    @FXML 
    Button btnDelete, btnReset;

    public void initialize()
    {
        txtShowInput.textProperty().bind(txtFieldFirstName.textProperty().concat(" ").concat(txtFieldLastName.textProperty()));
        txtSecondLine.textProperty().bind(txtShowInput.textProperty()); 
    }   

    @FXML
    private void deleteInputs(ActionEvent e)
    {
        txtFieldFirstName.setText("");
        txtFieldLastName.setText("");
        txtFieldAlternativeName.setText("");
    }

    @FXML
    private void resetBinding(ActionEvent e)
    {
        if (isBoundToAlternative)
        {
            txtShowInput.textProperty().bind(txtFieldFirstName.textProperty()
                .concat(" ").concat(txtFieldLastName.textProperty()));
            isBoundToAlternative = false;
        }
        else
        {
            txtShowInput.textProperty().bind(txtFieldAlternativeName.textProperty());        
            isBoundToAlternative = true;
        }
    }
}
