import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import  javafx.scene.shape.* ;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map extends Pane {
    private final int unit = 30 ;
    private int size ;
    private int[][] map ;
    private Position start ;
    private int numOfR ; 
    private int numOfCol ; 
    public Map(String filename ) {
        File file  = new File(filename) ;
        if (!file.exists()) {
            System.out.println("The file " + filename + " does not exist.");
            System.exit(2);
        }
        String s = " " ;
        try (
                Scanner in = new Scanner(file);
        ) {
            while (in.hasNext()) {
                s+= " " + in.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        s =  s.replaceAll("\\s","");
      
        size = Character.getNumericValue(s.charAt(0)) ;
        s = s.substring(1 , s.length()) ;

        map = new int[size][size] ;

        int k = 0 ;
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                map[i][j] = Character.getNumericValue(s.charAt(k)) ;
                k++ ;
            }
        }

        GridPane pane = new GridPane() ;
         
        
   
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(map[i][j] == 0 ){
                    Rectangle rect = new Rectangle(unit ,unit , Color.WHITE) ; 
                    rect.setStrokeWidth(1) ;
                    rect.setStroke(Color.BLACK) ; 
                    pane.add(rect , j , i ) ;
                }
                else if (map[i][j] == 2){
                    numOfR = i  ; 
                    numOfCol = j ;  
                    Rectangle rect = new Rectangle(unit ,unit , Color.WHITE) ; 

                    rect.setStroke(Color.BLACK) ; 
                    pane.add(rect , j , i ) ;
                }
                else
                    pane.add(new Rectangle(unit ,unit , Color.BLACK) , j , i ) ;


            }
                         
            
        }
            start = new Position( numOfR , numOfCol  ) ; 
            
            
            getChildren().add(pane) ; 
         
          

    
    }
    public int getUnit() {
        return unit;
    }

    public int getSize() {
        return size;
    }
    public int getValue(int raw , int col ){
        if(raw < 0 || col < 0 || raw > size || col > size){
            return -1 ; 
         }
        return map[raw][col] ; 

    }
    public Position getStartPosition(){
        return  start  ;
    }
}
