import org.code.theater.*;
import org.code.media.*;

/**
* The ImageFilter class extends ImagePlud and provides custom image
* processing algorithms that modify the pixel 2D array to create visual effects
* such as pixelation, motion blur, thresholding, and color removal
* All filters directly change the RGB values of the image pixels
*/
public class ImageFilter extends ImagePlus {

  
  /**  Constructor for the ImageFilter class  */
  public ImageFilter(String fileName) {
    super(fileName);
  }

  /**
  * Theshold filter method
  * Converts the image to black and white based on a brightness value
  * Each pixel turned either full black or fully white depending
  * on whether its greyscale value is below or above the threshold
  */
   public void threshold(int value) {
    Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
        
        // calculate the avg RBG values
        int totalRGB = currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue();
        int grayValue = totalRGB / 3;

        // checks if the value is under the minimum
        if (grayValue < value) {
          currentPixel.setColor(Color.BLACK);
        }
        else {
          currentPixel.setColor(Color.WHITE);
        }
      }
    }    
  }
  
/** 
* Motion blur filter method.
* Averages the RGB values of pixels in a specified direction 
* over a given length to create that blur effect 
*/ 
   public void motionBlur(int length, String direction) {
    Pixel[][] pixels = getImagePixels();

    // traverse all pixels
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        
        // variables to total RBG valuse
        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;

        /** 
        * Bluring in a direction, chosen variables 
        * go back to the area we will total RBG value
        */
        int x = col;
        int y = row;
        int count = 0; // use to repeat the length number of times

        // complex conditional to keep in bounds of width/height
        while (count < length && x < getWidth() && y < getHeight()) {
          // add RGB to the variables
          Pixel currentPixel = pixels[y][x];
          totalRed += currentPixel.getRed();
          totalGreen += currentPixel.getGreen();
          totalBlue += currentPixel.getBlue();
          // increase count to move to ending condition of count < length
          count++;
          // update x & y based on the definition of the bluring
          if (direction.equals("horizontal")) {
            x++;
          }
          else if (direction.equals("vertical")) {
            y++;
          }
          else if (direction.equals("diagonal")) {
            x++;
            y++;
          }
        }

        // calculate avg RBG
        int avgRed = totalRed / count;
        int avgGreen = totalGreen / count;
        int avgBlue = totalBlue / count;
        
        // update RBG values
        Pixel currentPixel = pixels[row][col];
        currentPixel.setRed(avgRed);
        currentPixel.setGreen(avgGreen);
        currentPixel.setBlue(avgBlue);
      }
    }
  }

/**
  * Cancel red filter method. 
  * Removes all red from the image by setting the red value of every pixel to 0.
  */
  public void cancelRed() {
    Pixel[][] pixels= getImagePixels();

      for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) { 
      Pixel currentPixel = pixels[row][col];
        currentPixel.setRed(0); 
      }
    }
  }

  /**
  * Pixelate filter method. 
  * Divides the image into square sections based on the grid size 
  * Calculates the avg RGB values for each section 
  * Then assigns that color to all pixels in the section 
  */
 public void pixelate(int gridSize) {

    Pixel[][] pixels=getImagePixels();

    for(int r=0; r < pixels.length; r+= gridSize) {
    for(int c=0; c< pixels[0].length; c+= gridSize) {

    int endRow = Math.min(r + gridSize, pixels.length);
    int endColumn= Math.min(c + gridSize, pixels[0].length);
        
    int totalRed = 0;
    int totalGreen = 0;
    int totalBlue = 0;
  
      // Calculate totals
    for(int r2=r; r2 < endRow; r2++) {
    for(int c2=c ; c2 < endColumn; c2++) {
    
    totalRed+= pixels[r2][c2].getRed();
    totalGreen+= pixels[r2][c2].getGreen();
    totalBlue+= pixels[r2][c2].getBlue();
          }
        }

    int totalPixels = (endRow - r) * (endColumn - c);
    int avgRed = totalRed / totalPixels;
    int avgGreen = totalGreen / totalPixels;
    int avgBlue = totalBlue / totalPixels;
    
      // Set pixels to average color
    for(int r2=r; r2 < endRow; r2++) {
    for(int c2=c ; c2 < endColumn; c2++) {
            // add the value of RGB
            pixels[r2][c2].setRed(avgRed);
            pixels[r2][c2].setGreen(avgGreen);
            pixels[r2][c2].setBlue(avgBlue);
          }
        }
      }
    }   
  }
  
}