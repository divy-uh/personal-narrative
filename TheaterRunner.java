import org.code.theater.*;
import org.code.media.*;

/**
* Driver class for the animation
* Creates the 2D datasets, instantiates the Scene subclasses, 
* and plays them in the Theater
*/
public class TheaterRunner {
  public static void main(String[] args) {

    /**
    * 2D dataset representing my indian cuisine preferences
    * rows = categories (flag, drinks, food)
    * columns = images in each category
    */
ImageFilter[][] images= {
// 2D array of images
  {new ImageFilter("Flag_of_India.svg.png"), new ImageFilter("Flag_of_India.svg.png")},
  {new ImageFilter("mangolassi.jpg"),new ImageFilter("indian-masala-chai-tea.jpg")},
  {new ImageFilter("chickentikkamasala.jpg"), new ImageFilter("dosa.jpg")}
};
    /**
    * 2D dataset representing my American cuisine preferences
    * rows = categories (flag, drinks, food)
    * columns = images in each category
    */
ImageFilter[][] images2= {
// 2D array of images
  {new ImageFilter("usaa.jpeg"), new ImageFilter("usaa.jpeg")},
  {new ImageFilter("Pink-Lemonade-1-500x500.jpg"), new ImageFilter("coca.jpg")},
  {new ImageFilter("grilledchickenn.jpg"), new ImageFilter("macncheese.jpg")}
  
};
    // Instantiate Scene subclass objects
    IndianCuisine scene1 = new IndianCuisine(images);
    AmericanCuisine scene2 = new AmericanCuisine(images2);
    
    // Call drawScene animation methods
    scene1.drawScene();
    scene2.drawScene1();
    
    // Play scenes in Theater 
    Theater.playScenes(scene1, scene2);
    
   
  }
}