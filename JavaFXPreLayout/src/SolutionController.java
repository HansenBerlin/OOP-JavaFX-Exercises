import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class SolutionController 
{
    private int incrementThis = 0;    

    @FXML 
    Text txtIncrement;
    
    @FXML
    private void buttonClickOne(ActionEvent e)
    {        
        incrementThis++;
        txtIncrement.setText(String.valueOf(incrementThis));
    }   
    
    @FXML
    private void buttonClickTwo(ActionEvent e)
    {        
        incrementThis*=2;
        txtIncrement.setText(String.valueOf(incrementThis));
    }   
}
