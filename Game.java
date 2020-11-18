import java.util.*;
import java.io.File;
import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode ;

public class Game extends Application {
    private Map map ;
    private Player player ;
    private Food food ;

    public static void main(String[] args){
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        final Parameters params = getParameters();
        final List<String> parameters = params.getRaw();
        final String filename = !parameters.isEmpty() ? parameters.get(0) : "";

        map = new Map(filename) ;
        MyPlayer pl = new MyPlayer(map) ;
        food = new Food(map , pl) ; 
        
       Scene scene = new Scene(map, 500 , 500) ; 
        scene.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.DOWN){
                pl.moveDown();
            }
            else if (e.getCode() == KeyCode.UP ){
                pl.moveUp();
            }
            else if (e.getCode() == KeyCode.LEFT ){
                pl.moveLeft() ; 
            }
            else if (e.getCode() == KeyCode.RIGHT ){
                
                pl.moveRight() ; 
            }
        
        });
       
        System.out.println(map.getSize());
         primaryStage.setTitle("Eater") ;       
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
