import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Solution extends Application 
{
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException 
    {        
        Parent root = FXMLLoader.load(getClass().getResource("layoutDataBindingSolution.fxml"));
        primaryStage.setScene(new Scene(root));        
        primaryStage.show();       
    }
}