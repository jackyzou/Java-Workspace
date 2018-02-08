import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gihan
 */
public class Brightness extends JFrame{
       //globel variables
        BufferedImage bufferedImage;
        String path="/home/gihan/Pictures/nfs_bmw.jpg";// image file path         
        float offset = 170.0f;//change offset to brighten 
        /*keep the value offset = 170.0f; as for a normal image*/
        RescaleOp rescale;
        ImageIcon icon;
        JLabel picLabel=new JLabel();

     public Brightness() {

         JFrame jf=new JFrame();
         JPanel jp=new JPanel();        

         jf.add(jp);
         jp.add(picLabel);

            jf.setVisible(true);
            jf.setSize(550, 550);
            jf.setLocation(200,100);
            jf.setTitle("Gihan¡¯s Image Processing Test Area.. ");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            File file = new File(path);

        try {           
            bufferedImage = ImageIO.read(file); // create a buffered image
        } catch (IOException ex) {
            Logger.getLogger(Brightness.class.getName()).log(Level.SEVERE, null, ex);
        }

         brighten();   
         icon = new ImageIcon(bufferedImage);          
         picLabel.setIcon(icon);       

    }

     private void brighten(){

         rescale();
         icon = new ImageIcon(bufferedImage);          
         picLabel.setIcon(icon); 
         System.out.println("offset :" + offset  );

    }//end  brighten()

     public void rescale() {

        rescale = new RescaleOp(1.0f,offset, null);
        bufferedImage=rescale.filter(bufferedImage,null);//(sourse,destination)

       }//end rescale

}//end class Bright

