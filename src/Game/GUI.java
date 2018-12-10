package Game;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI extends JFrame implements MouseListener {
	public BufferedImage image ;
	JMenuItem menuItem;
	JMenuBar menuBar;
	Image packmanImage ,fruitImage;
	Game game =new Game();
	Iterator<Packman> itPac= game.packmans.iterator();
	Iterator<Fruit> itFru = game.fruits.iterator();
	boolean packmanORfruit ;
	boolean enableAdd;
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
		//defining "Menu" menu titles
		Menu menu = new Menu("Menu"); 
		MenuItem item1 = new MenuItem("Load File");
		MenuItem item2 = new MenuItem("Run");
		MenuItem item3 = new MenuItem("Clear");
		MenuItem item4 = new MenuItem("Save Result");
		//setting main menu "Menu"
		menuBar.add(menu);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		this.setMenuBar(menuBar);
		menu.setFont(new Font("Courier New", Font.ITALIC, 12));
		//defining "insert" menu titles
		Menu menu2 =new Menu("Insert");
		MenuItem item5=new MenuItem("Add Fruits");
		MenuItem item6=new MenuItem("Add Packmans");
		//setting "insert" menu
		menuBar.add(menu2);
		menu2.add(item5);
		menu2.add(item6);
		menu2.setFont(new Font("Courier New", Font.ITALIC, 12));
		//Load File button Listener
		item1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				loadFile();
				
			}
		});
		//Clear Method from the "Menu" menu
		item3.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				x=-1;
				y=-1;
				enableAdd=false;
				packmanORfruit=false;
				
				game.packmans.clear(); //not sure what to fill inside the 
				game.fruits.clear();
				repaint();
			}
		});
		//Adding packmans Listener through "Insert" menu
		item5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enableAdd=true;
				if(packmanORfruit==true) packmanORfruit= false;
			}

		});

		//Adding fruits Listener through "Insert" menu
		item6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				enableAdd=true;
				if(packmanORfruit==false) packmanORfruit=true;

			}

		});




		try {
			image = ImageIO.read(new File("Ariel1.png"));
			packmanImage=ImageIO.read(new File("packman1.png"));
			fruitImage =ImageIO.read(new File("fruit1.png"));

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
			x = x - (r / 2+10);
			y = y - (r / 2+10);
			if(packmanORfruit&&enableAdd) {
				Packman p = new Packman(x,y);    //need to add Packman (need to change pixels to deg)
				game.packmans.add(p);            //add the fruit to the game 
			}
			else if(enableAdd) {
				Fruit f = new Fruit(x,y);
				game.fruits.add(f);
			}//END INNER IF	
			itPac= game.packmans.iterator();  //for the repaint we need to draw every packman again
			while(itPac.hasNext()) {
				Packman pTemp = itPac.next();
				g.drawImage(packmanImage,(int)pTemp.getLocationInPixels().x(),(int)pTemp.getLocationInPixels().y(),2*r,2*r,this);
			}
			itFru= game.fruits.iterator();
			while(itFru.hasNext()) {
				Fruit fTemp= itFru.next();
				g.drawImage(fruitImage,(int)fTemp.getLocationInPixels().x(),(int)fTemp.getLocationInPixels().y(),2*r,2*r,this);
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
	public void loadFile() {
//		try read from the file (Copied code from elizabeth )
        FileDialog fd = new FileDialog(this, "Open text file", FileDialog.LOAD);
        fd.setFile("*.csv");
        fd.setDirectory("C:");
        fd.setFilenameFilter(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".csv");
            }
        });
        fd.setVisible(true);
        String folder = fd.getDirectory();
        String fileName = fd.getFile();
        if(fileName!=null) {
        System.out.println("The file that opened is: "+folder+fileName);
        game.buildAgame(folder + fileName);
        x=1;
        y=1;
        repaint();
        }
	}
	public static void main (String [] args) {
		new GUI();	
	}

}
