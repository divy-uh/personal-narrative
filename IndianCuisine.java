import org.code.theater.*;
import org.code.media.*;

/**
*Scene that represents my connection to Indian cusine
* Displays flag, drinks, and foods using image filters
*/
public class IndianCuisine extends Scene {

  /** 2D array storing all images for this scene */
  private ImageFilter[][] images;

  /** 
  * Constructor
  * Image is initialized and contians ImageFilter objects
  * Instance variable images is set for use in all methods
  */
  public IndianCuisine(ImageFilter[][] images) {
  this.images=images;
  }

  /**
   * Top-level method that controls animation sequence
   * images array is not null
   * all three categories are drawn to the screen
   */
  
  public void drawScene() {
   // methods for drawing the scene 
    playSound("song.wav"); //plays background music
    drawFlag();
    drawDrink();
    drawFood();
  }

  /**
  * Displays flag images and applies motion blur filter
  * images[0] contains ImageFilter objects
  * each flag is displayed with and without filter
  */
  public void drawFlag() {
   for (ImageFilter img : images[0]) {
      clear("white");
      drawImage(img, 0, 0, 400, 400, 0);
setCaptionStyle();
drawText("Indian cuisine is my top 2!", 30, 30);
      pause(1);
      
      img.motionBlur(10, "vertical");
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
  } }
  
/**
* Displays drink images and applies pixelate filter
* images[1] contains ImageFilter objects
* each drink is displayed w/ and w/o filter
*/
    public void drawDrink() {
   for (ImageFilter img : images[1]) {
      clear("white");

      drawImage(img, 0, 0, 400, 400, 0);
     setCaptionStyle();
drawText("My favorite indian drinks!", 30, 30);
      pause(1);
      img.pixelate(10);
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
  } }

/**
* Displays food images and applies threshold filter
* images[2] contains ImageFilter objects
* each food is displayed w/ and w/o filter
*/
          public void drawFood() {
   for (ImageFilter img : images[2]) {
      clear("white");
      drawImage(img, 0, 0, 400, 400, 0);
     setCaptionStyle();
drawText("My favorite indian foods!", 30, 30);
      pause(1);
      
      img.threshold(10);
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
  } }
/**
* Sets text style for captions
* All future texts uses the style of setCaptionStyle
*/
    public void setCaptionStyle() {
    setTextHeight(30);
    setTextColor("black");
    setTextStyle(Font.SANS, FontStyle.ITALIC);
  }

}