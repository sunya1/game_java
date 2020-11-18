

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color ; 
public class MyPlayer implements  Player{
    private Circle ball ;
    private  Map map ;
    private  Position position ;

    public MyPlayer(Map map){
        this.map = map ; // we have created the ball and gave the centerX and centerY coordinates by this formula (map.getStartPosition().getX()  + 1) * map.getUnit()) / 2 why because out position saves index of the cell where is the ball staying so to save in appropirate coordinate we should convert it by the formula that i wrote befor
        ball = new Circle(((map.getStartPosition().getX()  + 1) * map.getUnit()) / 2 , ((map.getStartPosition().getY() + 1)* map.getUnit()) / 2 ,  map.getUnit() / 2 - 1 , Color.RED) ; 
        position = map.getStartPosition() ; // we are equating the positon to the start postion of ball

        map.getChildren().add(ball) ;   
    
    }

    @Override
    public void moveRight() {
            //if we pressed RIGHT this method is called in this method we are giving new centerX coordinate because when the ball moves to the right only X changes and we move him by UNIT to the right by centerX(of ball) + unit 
            if(!(position.getX() + 1 >= map.getSize()) && ( map.getValue( position.getY()  ,position.getX() + 1  ) == 2 || map.getValue( position.getY() , position.getX()  + 1 ) == 0 )){
                position.setX(position.getX() + 1)  ;
                ball.setCenterX(ball.getCenterX() +  map.getUnit() + 1) ; 
            }
            else
                System.out.println("Invalid Position");       
        //and we have some condition if out X(our coordinate of position)  > 8 it means that we cant move there and if map.getValue(row , col) != 0 or != 2 so it means there is wall and we cant move there 
    }

    @Override
    public void moveLeft() {
         //if we pressed LEFT this method is called in this method we are giving new centerX coordinate because when the ball moves to the left only X changes and we move him by UNIT to the left by centerX(of ball) - unit 
        if(position.getX() - 1 >= 0  && (map.getValue( position.getY() , position.getX() - 1) == 2 || map.getValue( position.getY() , position.getX() - 1) == 0)){
                position.setX(position.getX() - 1)  ;
                ball.setCenterX(ball.getCenterX() -  map.getUnit() - 1) ; 
            }
             else
                System.out.println("Invalid Position");   
      //and we have some condition if our X(our coordinate of position)  >= 0 it means that we can move there and if map.getValue(row , col) != 0 or != 2 so it means there is wall and we cant move there 
    }


    @Override
    public void moveUp() {
     //if we pressed UP this method is called in this method we are giving new centerY coordinate because when the ball moves to the top only Y changes and we move him by UNIT to the right by centerY(of ball) - unit 
         if(position.getY() - 1 >= 0 && (map.getValue(position.getY() - 1 , position.getX() ) == 2 || map.getValue( position.getY() - 1 , position.getX()  ) == 0)){
                position.setY(position.getY() - 1)  ;
                ball.setCenterY(ball.getCenterY() -  map.getUnit() - 1) ; 
            }     
             else
                System.out.println("Invalid position"); 
              //and we have some condition if out Y(our coordinate of position)  < 0 it means that we cant move there and if map.getValue(row , col) != 0 or != 2 so it means there is wall and we cant move there 
    
    }

    @Override
    public void moveDown() {
   //if we pressed DOWN this method is called in this method we are giving new centerY coordinate because when the ball moves to the bottom only Y changes and we move him by UNIT to the bottom by centerY(of ball) + unit 
         
        if(!(position.getY() + 1 >= map.getSize()) && (map.getValue( position.getY()  + 1 , position.getX()  ) == 2 || map.getValue( position.getY() + 1 , position.getX() ) == 0)){
                position.setY(position.getY() + 1)  ;
                ball.setCenterY(ball.getCenterY() +  map.getUnit() + 1) ; 
            } 
             else
                System.out.println("Invalid position"); 
    }     //and we have some condition if out Y(our coordinate of position)  > 8 it means that we cant move there and if map.getValue(row , col) != 0 or != 2 so it means there is wall and we cant move there 
    

    @Override
    public Position getPosition() {
        return position;
    }
}
