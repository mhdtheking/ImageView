/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2fx;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author mhd
 */
public class Hw2Fx extends Application {

     int i = 0;
    //Creating an image 
    Image[] image;
    //Setting the image view 
    ImageView imageView;

    Group root;
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

       
        //image = new Image(new FileInputStream("D:\\projects_java\\Hw2Fx\\Image\\0.jpg"));
       // imageView = new ImageView(image);
        File f = new File("Image\\");
       // FileInputStream in = new FileInputStream(f);
        
        String[] s = f.list();
         image =new Image[s.length];
        
             image[i]=new Image(new FileInputStream("Image\\" + s[i]));
             imageView = new ImageView(image[i]);
        
       
          
        
        
        
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        
        
        Button right = new Button(">");
        right.setPrefSize(50, 25);
        Button left = new Button("<");
        left.setPrefSize(50, 25);
        Button close = new Button("Close");

        //Setting the position of the image 
        imageView.setX(50);
        imageView.setY(50);

        //setting the fit height and width of the image view 
        //imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        //Setting the preserve ratio of the image view 
        imageView.setPreserveRatio(true);

        right.setOnAction((ActionEvent event) -> {
            try {
                
                i++;
               
                 if(i==s.length || i==-1)
                {
                    i=0;
                }
                 
                image[i] = new Image(new FileInputStream("Image\\" + s[i]));
                imageView = new ImageView(image[i]);

                //Setting the position of the image 
                imageView.setX(50);
                imageView.setY(50);

                //setting the fit height and width of the image view 
                imageView.setFitHeight(455);
                imageView.setFitWidth(500);

                //Setting the preserve ratio of the image view 
                imageView.setPreserveRatio(true);
                root.getChildren().add(imageView);
                System.out.println("name of image : "+ s[i]);
                System.out.println("i = "+i);         
                

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        left.setOnAction((ActionEvent event) -> {

            try {
                i--;
                if(i==-1)
                {
                    i=s.length -1;
                }
                image[i] = new Image(new FileInputStream("Image\\" + s[i]));
                imageView = new ImageView(image[i]);

                //Setting the position of the image 
                imageView.setX(50);
                imageView.setY(50);

                //setting the fit height and width of the image view 
                imageView.setFitHeight(455);
                imageView.setFitWidth(500);

                //Setting the preserve ratio of the image view 
                imageView.setPreserveRatio(true);
                root.getChildren().add(imageView);
               // System.out.println(s[i]);
                System.out.println("name of image : "+ s[i]);
                 System.out.println("i = "+i);  
                
                
                

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        });
        
        
        
        
         close.setOnAction((ActionEvent event) -> {

            
                       System.exit(0);
        });


        root = new Group();

        root.getChildren().add(imageView);
        
        root.getChildren().add(right);
        right.setTranslateX(550);
        right.setTranslateY(250);
        root.getChildren().add(left);
       // left.setTranslateX(230);
        left.setTranslateY(250);
        root.getChildren().add(close);
        close.setTranslateX(500);

        Scene scene = new Scene(root, 600, 500);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
