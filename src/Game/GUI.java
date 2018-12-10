package Game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI extends JFrame implements MouseListener {
	public BufferedImage image ;
	JMenuItem menuItem;
	JMenuBar menuBar;
	Image packmanImage ,fruitImage;

	boolean packmanORfruit =true;
	int x =-1, y=-1;


	public GUI() {
		startGUI();
		setVisible(true);
		setTitle("Welcome");
		setJMenuBar(menuBar);
		setSize(image.getWidth(),image.getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this); //detect Mouse clicks (not used at the moment)
		this.addComponentListener(new ComponentAdapter() { // detects window changing 
			public void componentResized(ComponentEvent e) {

			}
		});
	}
	private void startGUI() {
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu"); 
		MenuItem item1 = new MenuItem("Run");
		MenuItem item2 = new MenuItem("Save");
		MenuItem item3 = new MenuItem("Save Result");
		MenuItem item4 = new MenuItem("Clear");


		menuBar.add(menu);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		this.setMenuBar(menuBar);
		menu.setFont(new Font("Courier New", Font.ITALIC, 12));
		
		MenuBar menuBar2= new MenuBar();
		Menu menu2 =new Menu("Player Option");
		MenuItem item5=new MenuItem("add fruits");
		MenuItem item6=new MenuItem("add packmans");
		MenuItem item7=new MenuItem("Run as file");
		
		menuBar2.add(menu2);
		menu2.add(item5);
		menu2.add(item6);
		menu2.add(item7);
		this.setMenuBar(menuBar2);
		menu2.setFont(new Font("Courier New", Font.ITALIC, 12));




		try {
			image = ImageIO.read(new File("Ariel1.png"));
			packmanImage=ImageIO.read(new File("Packman1.png"));
			fruitImage =ImageIO.read(new File("Fruit1.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void paint(Graphics g)
	{
		g.drawImage(image, 0, 0,this.getWidth(),this.getHeight(), this);
		if(x!=-1 && y!=-1)
		{
			int r = 20;
			x = x - (r / 2);
			y = y - (r / 2);
			if(packmanORfruit) {
				g.drawImage(packmanImage, x, y,3*r,3*r,this);
			}
			else {
				g.drawImage(fruitImage, x, y,2*r,2*r,this);
				
			}

		}


	}





	@Override
	public void mouseClicked(MouseEvent m) {
		System.out.println("("+ m.getX() + "," + m.getY() +")");
		x = m.getX();
		y = m.getY();
		repaint();

	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	//End of MouseListner implements methods

	public static void main (String [] args) {
		new GUI();	
	}

}
