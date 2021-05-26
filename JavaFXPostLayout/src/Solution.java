import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Solution extends Application 
{
    private int incrementThis = 0;
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        StackPane root = new StackPane();
        Button btnIncrement = new Button();
        Button btnDecrement = new Button();
        Text txtIncrement = new Text();
       
        StackPane.setMargin(txtIncrement, new Insets(100,0,0,0));
        StackPane.setMargin(btnDecrement, new Insets(0,0,0,50));
        StackPane.setMargin(btnIncrement, new Insets(0,50,0,0));

        btnIncrement.setStyle("-fx-background-color: #FF0003;");
        btnDecrement.setStyle("-fx-background-color: #A7CE9B;"); 

        // relative und absolute Änderung der Größe
        btnIncrement.setScaleX(1.5);
        btnIncrement.setScaleY(1.5);
        btnDecrement.setMinSize(50, 40);        

        btnIncrement.setText("+1");   
        btnDecrement.setText("-1");     

        // Listener hier nur zur Vereinfachung doppelt eingebaut, 
        // macht man eigentlich in einem 
        btnIncrement.setOnAction(new EventHandler<ActionEvent>() 
        {            
            @Override
            public void handle(ActionEvent event) 
            {
                incrementThis++;
                txtIncrement.setText(String.valueOf(incrementThis));
                if (incrementThis >= 10)
                {
                    btnIncrement.setDisable(true);
                    btnIncrement.setVisible(false);
                }
            }
        });

        btnDecrement.setOnAction(new EventHandler<ActionEvent>() 
        {            
            @Override
            public void handle(ActionEvent event) 
            {
                incrementThis--;
                txtIncrement.setText(String.valueOf(incrementThis));
                if (incrementThis >= 10)
                {
                    btnIncrement.setDisable(true);
                    btnIncrement.setVisible(false);
                }
            }
        });
        
        root.getChildren().addAll(btnIncrement, btnDecrement, txtIncrement);         
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}