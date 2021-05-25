import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Main extends Application 
{
    private int incrementThis = 0;
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Anlegen der Objekte die in diesem Fenster verwendet werden 
        StackPane root = new StackPane();
        Button btnIncrement = new Button();
        Text txtIncrement = new  Text();

        // Dem Textelement wird ein oberer Abstand von 50px zugewiesen
        // Dem Button wird eine Farbe als Hexwert in CSS Syntax und ein Text zugewiesen
        StackPane.setMargin(txtIncrement, new Insets(50,0,0,0));
        btnIncrement.setStyle("-fx-background-color: #A7CE9B;");  
        btnIncrement.setText("+1");        

        // Die Interaktion mit dem Button wird registriert und ein Eventhandler definiert
        btnIncrement.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                incrementThis++;
                txtIncrement.setText(String.valueOf(incrementThis));
            }
        });
        
        // Die Elemente werden nach dem Schema Stage, Scene, Nodes 'zusammengebaut'
        // und die Values für das Hauptfenster gesetzt. An Ende muss mit .show() 
        // das Programm 'gestartet' werden
        root.getChildren().addAll(btnIncrement, txtIncrement);         
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}