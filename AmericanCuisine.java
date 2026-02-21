import org.code.theater.*;
import org.code.media.*;

/**
* Scene that represents my connection to American cuisine
* Displays flag, drinks, and food using image filters
*/

public class AmericanCuisine extends Scene {

  /** 2D array storing all images for this scene */
  private ImageFilter[][] images2;

  /** 
  * Constructor
  * images2 is initialized 
  * instance variable is set
  */
  public AmericanCuisine(ImageFilter[][] images2) {
this.images2= images2;
  }

  /**
   * Top-level drawScene method draws the whole animation
   * images2 isn't null
   * all categories are drawn
   */
  public void drawScene1() {
// drawing methods
    drawFlag1();
    drawDrink1();
    drawFood1();
  }

  /**
  * Displays USA flag image and applies cancelRed filter
  * images2[0] contains valid ImageFilter objects
  */
  
  public void drawFlag1() {
   for (ImageFilter img : images2[0]) {
      clear("white");
      drawImage(img, 0, 0, 400, 400, 0);
     setCaptionStyle1();
drawText("USA cuisine is also my fav!", 30, 30);
      pause(1);
      
      img.cancelRed();
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
  } }

  /**
  * Displays American drink image and applies pixelate filter
  * images2[1] contain valid ImageFilter objects
  */
  public void drawDrink1() {
   for (ImageFilter img : images2[1]) {
      clear("white");
      drawImage(img, 0, 0, 400, 400, 0);
     setCaptionStyle1();
drawText("My favorite american drinks!", 30, 30);
      pause(1);
      
      img.pixelate(10);
     
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
  } }
  
 /**
  * Displays American food image and applies motion blur filter
  * images2[2] contain valid ImageFilter objects
  */
  public void drawFood1() {
   for (ImageFilter img : images2[2]) {
      clear("white");
      drawImage(img, 0, 0, 400, 400, 0);
    setCaptionStyle1();
drawText("My favorite american foods!", 30, 30);
      pause(1);
      
      img.motionBlur(10, "vertical");
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
  } }
  
/**
* Sets text style for captions in the American cuisine scene
* All future texts uses the style of setCaptionStyle
*/
    public void setCaptionStyle1() {
    setTextHeight(30);
    setTextColor("black");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
  }
  }