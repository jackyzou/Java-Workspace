

import com.aspose.j2me.barcode.generation.BarCodeBuilder;
import com.aspose.j2me.barcode.generation.Symbology;
import com.aspose.j2me.barcode.generation.GraphicsUnit;


import javax.microedition.lcdui.CustomItem;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * Sample class for using Aspose.BarCode for J2ME
 * Shows how to create a CustomItem to paint barcodes.
 */
public class SampleBarCodeItem extends CustomItem {
    protected SampleBarCodeItem(String s) {
        super(s);

    }


    protected int getMinContentWidth() {
        return 200;
    }

    protected int getMinContentHeight() {
        return 200;
    }

    protected int getPrefContentWidth(int i) {
        return i;
    }

    protected int getPrefContentHeight(int i) {
        return i;
    }
    private String _codeText = "12345";
    private long _symbology = Symbology.CODABAR;
    private Image _img = null;
    public void setCodeText(String code)
    {
        this._codeText = code;
    }
    public void setSymbology(long sym)
    {
        this._symbology = sym;
    }
    private BarCodeBuilder b;
    protected void paint(Graphics g, int w, int h) {

        if(b == null)
        {
            b =  new BarCodeBuilder(_symbology,_codeText);
        }
        else
        {
            b.setSymbology(_symbology);
            b.setCodeText(_codeText);
        }
        b.setGraphicsUnit(GraphicsUnit.PIXEL);
        b.setXDimension(2);
        b.setBarHeight(50);
        b.setWideNarrowRatio(2);
        b.setBorderVisible(false);
        b.setCodeTextVisible(true);


        if(_img == null)
        {
            _img = Image.createImage(w,h);
        }

        Graphics g1 = _img.getGraphics();

        g1.setColor(0xFFFFFFFF);
        g1.fillRect(0,0,w,h);

        b.render(g1);
        g.drawImage(_img,0,0,Graphics.TOP | Graphics.LEFT);
    }


    public void repaitBarCode() {
        this.repaint();
    }

    public Image getImage() {
        return this._img;
    }
}