///////////////////
/// Date: 2010-4-25
/// Time: 17:48:54
//////////////////////

import com.aspose.j2me.barcode.generation.Symbology;
import com.aspose.j2me.barcode.recognition.BarCodeReadType;
import com.aspose.j2me.barcode.recognition.BarCodeReader;
import com.aspose.j2me.barcode.License;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.lcdui.*;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

/**
 * A Sample Midlet of Aspose.BarCode for J2ME
 * 
 */
public class J2MEBarCodeDemoMIDlet extends MIDlet
        implements CommandListener {
    Display display;
    Form mainForm;
    StringItem tx,result;

    private SampleBarCodeItem bc;
    private long[] symbologies = {Symbology.CODE39STANDARD,
            Symbology.BOOKLANDEAN, Symbology.CODABAR, Symbology.CODE11, Symbology.CODE128, Symbology.CODE39EXTENDED,
            Symbology.CODE93EXTENDED, Symbology.CODE93STANDARD, Symbology.DeutschePostIdentcode, Symbology.EAN128,
            Symbology.EAN13, Symbology.EAN14, Symbology.EAN8, Symbology.INTERLEAVED2OF5, Symbology.ITF14,
            Symbology.Matrix2of5, Symbology.MSI, Symbology.PZN, Symbology.SSCC18, Symbology.STANDARD2OF5,
            Symbology.UPCA, Symbology.UPCE,

            Symbology.AustraliaPost, Symbology.ONECODE, Symbology.PLANET, Symbology.POSTNET,

            Symbology.AZTEC, Symbology.DATAMATRIX, Symbology.PDF417, Symbology.MACROPDF417, Symbology.QR

    };
    private String[] symNames = {"CODE39STANDARD",
            "BOOKLANDEAN", "CODABAR", "CODE11", "CODE128", "CODE39EXTENDED",
            "CODE93EXTENDED", "CODE93STANDARD", "DeutschePostIdentcode", "EAN128",
            "EAN13", "EAN14", "EAN8", "INTERLEAVED2OF5", "ITF14",
            "Matrix2of5", "MSI", "PZN", "SSCC18", "STANDARD2OF5",
            "UPCA", "UPCE",

            "AustraliaPost", "ONECODE", "PLANET", "POSTNET",


            "DATAMATRIX", "PDF417", "MACROPDF417", "QR"

    };
    private BarCodeReadType[] types = {BarCodeReadType.Code39Standard,
            BarCodeReadType.BooklandEAN, BarCodeReadType.Codabar, BarCodeReadType.Code11, BarCodeReadType.Code128, BarCodeReadType.Code39Extended,
            BarCodeReadType.Code93Extended, BarCodeReadType.Code93Standard, BarCodeReadType.DeutschePostIdentcode, BarCodeReadType.EAN128,
            BarCodeReadType.EAN13, BarCodeReadType.EAN14, BarCodeReadType.EAN8, BarCodeReadType.Interleaved2Of5, BarCodeReadType.ITF14,
            BarCodeReadType.Matrix2of5, BarCodeReadType.MSI, BarCodeReadType.PZN, BarCodeReadType.SSCC18, BarCodeReadType.Standard2of5,
            BarCodeReadType.UPCA, BarCodeReadType.UPCE,
            BarCodeReadType.AustraliaPost, BarCodeReadType.OneCode, BarCodeReadType.Planet, BarCodeReadType.Postnet,
            BarCodeReadType.Code11,
            BarCodeReadType.DataMatrix, BarCodeReadType.Pdf417, BarCodeReadType.MacroPdf417, BarCodeReadType.QR
    };
    private long[] exList =
            {

            };
    private int currentIndex = 0;
    private long currentSymbology = Symbology.CODE39STANDARD;


    public J2MEBarCodeDemoMIDlet() {
//        this.setLicense();
        this.mainForm = new Form("Barcode examples");

        this.mainForm.setCommandListener(this);
        this.mainForm.addCommand(new Command("Read", 1, 1));
        this.mainForm.addCommand(new Command("Exit", Command.EXIT, 2));
        this.mainForm.addCommand(new Command("Set License", 1, 5));        

        for (int i = 0; i < this.symNames.length; i++) {
            this.mainForm.addCommand(new Command(symNames[i], 1, 10 + i));
        }

        bc = new SampleBarCodeItem("Aspose-BarCode Generation ");
        bc.setSymbology(this.symbologies[0]);
        this.mainForm.append(bc);
        bc.setPreferredSize(300, 200);

        tx = new StringItem("Current Type:", this.types[this.currentIndex].toString());
        this.mainForm.append(tx);

        result = new StringItem("Result:","");
        this.mainForm.append(result);




    }

    protected void startApp() throws MIDletStateChangeException {
        display = Display.getDisplay(this);
        this.display.setCurrent(this.mainForm);
    }

    protected void pauseApp() {

    }

    protected void destroyApp(boolean b) throws MIDletStateChangeException {

    }

    public void commandAction(Command command, Displayable displayable) {
        int p = command.getPriority();
        switch (p) {
            case 1:
                this.result.setText("Trying Read....[" + this.types[this.currentIndex] + "]...");
                read();
                break;
            case 2:
                break;
            case 5:
                setLicense();
                break;

            default:
                build(p - 10);
                break;

        }
    }

    private void build(int i) {
        this.currentIndex = i;
        this.currentSymbology = this.symbologies[i];
        this.bc.setSymbology(this.currentSymbology);
        if(this.currentSymbology == Symbology.ONECODE)
        {
            this.bc.setCodeText("01234567094987654321");
        }
        else
        {
            this.bc.setCodeText("12345");
        }
        this.bc.repaitBarCode();
        tx.setText(this.types[this.currentIndex].toString());

    }



    private void read() {
        long s = symbologies[this.currentIndex];
        for (int j = 0; j < exList.length; j++) {
            if (exList[j] == s) {
                return;
            }
        }
        Image img = this.bc.getImage();
        if (img != null) {
            BarCodeReader r = new BarCodeReader(img, types[this.currentIndex]);
            this.result.setText("Reading...");
            boolean bResult = r.read();
            if (bResult) {
              this.result.setText("Found [" + r.getCodeText() + "] of {" + r.getReadType() + "}");
            } else {
                this.result.setText("Read failed.");
            }
        }
    }

    private boolean licensed = false;

    private void setLicense() {
        if (!licensed) {
            MyLicense ml = new MyLicense();
            License lic = new License();
            InputStream is = new ByteArrayInputStream(ml.licenseContent.getBytes(), 0, ml.licenseContent.length());
            try {
                lic.setLicense(is);
                this.licensed = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}