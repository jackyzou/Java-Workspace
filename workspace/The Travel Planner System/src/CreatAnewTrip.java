import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CreatAnewTrip {

	public static void main(String[] args) {
		
				JDesktopPane desktopPane = new JDesktopPane();
				JInternalFrame intFrame = new JInternalFrame(
						"Select a place to go first!");

				intFrame.setMaximizable(true);
				intFrame.setIconifiable(true);
				intFrame.setResizable(true);
				intFrame.setClosable(true);
				intFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
				intFrame.add(new JLabel(new ImageIcon("world-map(gold ext).png")));
				intFrame.setSize(1000, 480);
				// intFrame.pack();
				intFrame.setVisible(true);

				desktopPane.add(intFrame);

				JFrame frame = new JFrame();
				frame.add(desktopPane);
				frame.setTitle("To Create a New Trip...");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(1200, 650);
				frame.setVisible(true);

	}
}