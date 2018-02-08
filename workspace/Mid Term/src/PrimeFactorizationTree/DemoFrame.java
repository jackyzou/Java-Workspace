
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
package PrimeFactorizationTree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;


public class DemoFrame extends JFrame {

	private int len = 10;
	private static final int STEP = 80;
	private int H = 32 * len;
	private int W = 4* H;
	private static final int LINE_HEIGTH = 48;

	private PrimeFactor rootValue = new PrimeFactor(1 * 1);;

	public DemoFrame() {
		setTitle("PrimeFactory");
		GUI();
	}

	private void GUI() {
		Container contentPane = getContentPane();

		JLabel inputLabel = new JLabel("Type in:");
		inputLabel.setPreferredSize(new Dimension(120, 32));
		final JSpinner input = new JSpinner();
		input.setValue(rootValue.getValue());
		input.setPreferredSize(new Dimension(240, 32));

		JPanel north = new JPanel();
		north.add(inputLabel, BorderLayout.WEST);
		north.add(input, BorderLayout.EAST);
		contentPane.add(north, BorderLayout.NORTH);
		//
		final JButton go = new JButton("Culculate");
		go.setSize(new Dimension(240, 32));
		JPanel center = new JPanel(new BorderLayout(10, 10));
		JLabel fill = new JLabel();
		fill.setPreferredSize(new Dimension(488, 32));
		center.add(fill, BorderLayout.WEST);
		center.add(new JLabel("There're surprises after pressing the Culculate Button"), BorderLayout.EAST);
		center.add(go, BorderLayout.CENTER);
		contentPane.add(center, BorderLayout.CENTER);

		final JComponent out = createDrawPanel();
		out.setPreferredSize(new Dimension(800, 480));
		contentPane.add(out, BorderLayout.SOUTH);

		go.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				DemoFrame.this.rootValue = new PrimeFactor((Integer)input.getValue());

				out.updateUI();
				out.repaint();
			}

		});

	}
//the graph part, the difficult part
	private JComponent createDrawPanel() {
		JComponent container = new JComponent() {

			@Override
			public void paint(Graphics g) {
				super.paintComponents(g);
				if (isOpaque()) {
					g.setColor(getBackground());
					g.fillRect(0, 0, getWidth(), getHeight());
				}
				DemoFrame.this.H = this.getHeight();
				DemoFrame.this.W = this.getWidth();
				draw(g);
			}

		};
		container.setBorder(new LineBorder(Color.red, 1));
		return container;
	}

	private void draw(Graphics graphics) {

		if (graphics == null) {
			return;
		}

		int pos = W / 2;
		draw(this.rootValue, pos, 0, graphics, new Course(0, W));

	}

	private Node draw(PrimeFactor prime, int pos, int line, Graphics g, Course course) {
		Node parent = new Node(prime.getValue(), pos, line);
		parent.draw(g);
		PrimeFactor[] mul = prime.getMultiplicator();
		if (mul != null) {
			int span1 = (pos  - course.from) / 2;
			Node left = draw(mul[0], pos - span1, line + 1, g, new Course(course.from, pos));
			drawLine(parent, left, g);

			int span2 = (course.to - pos) / 2;
			Node right = draw(mul[1], pos + span2, line + 1, g, new Course(pos, course.to));
			drawLine(parent, right, g);
		}
		return parent;
	}

	private void drawLine(Node parent, Node child, Graphics g) {
		g.drawLine((int) parent.rect.getCenterX(),
				(int) (parent.rect.getY() + parent.rect.getHeight()),
				(int) child.rect.getCenterX(), (int) child.rect.getY());

	}

	public static Rectangle rect(int center, int len) {
		return new Rectangle(center - STEP / 2, len * LINE_HEIGTH + 16,
				STEP / 2, 24);
	}

	public static void main(String[] args) {
		DemoFrame demo = new DemoFrame();
		
		demo.setBounds(new Rectangle(32, 64, 1024, 600));
		demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		demo.setVisible(true);

	}
	private static class Course{
		private final int from;
		private final int to;
		public Course(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		
	}
	private static class Factor {
		private final int value;
		private final Factor left;
		private final Factor right;

		public Factor(int value, Factor left, Factor right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public Factor(int value) {
			this(value, null, null);
		}

	}

	private static class Node {
		private final int value;
		private final Rectangle rect;
		private final int position;
		private final int line;

		public Node(int value, int position, int line) {
			this.value = value;
			this.rect = rect(position, line);
			this.position = position;
			this.line = line;

		}

		public void draw(Graphics g) {
			g.setColor(Color.darkGray);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);
			g.setColor(Color.BLUE);
			g.drawString(String.valueOf(value), rect.x + 8, rect.y + 16);
			System.out.println("draw string " + value + " at " + rect);

		}

	}

}
