import java.awt.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.awt.geom.*;
import java.awt.image.*;

public class Menu extends JFrame implements ActionListener, KeyListener{

	/**Attributes*/

	Rectangle Ecran;
	Font police50 = new Font("STENCIL",Font.BOLD,50);
	Font police42 = new Font("STENCIL",Font.PLAIN,22);

	/*Main Window*/
	JButton btStart;
	JButton btHelp;
	JButton btOptions;
	JLabel TitleLab;
	JPanel panMainWind;

	/*Help Window*/
	JDialog winHelp;
	JTextArea textHelp;

	/*Options Window*/
	JLabel labChar;
	JLabel labUsername;
	JLabel labImChar;
	JTextField textUsername;
	JButton btRightArrow;
	JButton btLeftArrow;
	JButton btOk;
	JPanel panOptionsWind;

	/*Buffer*/
	Graphics buffer;
	BufferedImage ArrierePlan;


	/*Timer*/
	int TempsTimer_ms= 100;
	Timer MonTimer;
	long Temps;

	/*Images*/
	/*Avatars*/
	/**Image Anonymous_run;
	Image Bunny_run;
	Image Chicken_run;
	Image Chipmunk_run;
	Image Cowboy_run;
	Image Fox_run;
	Image Girl_Future_run;
	Image Jocker_run;
	Image Cat_run;
	Image Manga_Girl_run;
	Image Ninja_run;
	Image Roadrunner_run;
	Image Sony_run;
	Image Squirel_run;
	Image SuperHero_Man_run;*/
	/*Backgrounds*/
	ImageIcon Background_Menu;
	/*Sprites*/
	Image Girl_stand;
	Image Girl_walk;
	Image PapiMario_stand;
	Image PapiMario_right;
	Image PapiMario_left;
	/*Buttons*/
	Image Start;
	Image Options;
	Image Help;
	Image RightArrow;
	Image LeftArrow;
	Image OK;

	/**Constructor*/
	public Menu(){
		super("Tresure hUNT £ mENU");

		/**Girl_walk = T.getImage("Girl_walk.gif");
        PapiMario_left = T.getImage("PapiMario_left.gif");
        PapiMario_right = T.getImage("PapiMario_right.gif");*/
		//Create double array with all the images of the avatars and their names associated with them

		/** Fix window*/
		this.setTitle("Treasure Hunt -- Menu");
		this.setLayout(null);
		this.setBounds(300, 50, 600, 600);
		/**JLabel labelCentre;
        labelCentre = new JLabel(Background_Menu);
        this.add(labelCentre, BorderLayout.CENTER);*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		//Put the Object class from the Asteroid Game in the same folder as this code in order to use Ecran etc.
		//Screen = new Rectangle (0, 0, getSize().width, getSize().height);

		MonTimer = new Timer(100,this);

		/**create Buffer**/
		//ArrierePlan= new BufferedImage(Ecran.width,Ecran.height,BufferedImage.TYPE_INT_RGB);
		//buffer = ArrierePlan.getGraphics();

		MainWind();
		MonTimer.start();
		this.setVisible(true);
	}

	//public void paint (Graphics g){
	/**Paint background image on window*/
	//buffer.drawImage(background_Night, 0, 0, this);
	//}

	public void MainWind(){

		/**Find image files and associate them as type Image**/
		Toolkit T=Toolkit.getDefaultToolkit();

		Start = T.getImage("StartBt.png");
		Options = T.getImage("OptionsBt.png");
		Help = T.getImage("HelpBt.png");
		Background_Menu = new ImageIcon("backgroundMen.jpg");


		/**Creation of button bt1 with text "START"**/
		btStart = new JButton ();
		btStart.setOpaque(false);
		btStart.setBorderPainted(false);
		btStart.setContentAreaFilled(false);
		btStart.setIcon(new ImageIcon(Start));
		btStart.setBounds (175,200,250,50);
		btStart.addActionListener(this);

		/**Creation of button bt2 with text "HELP"**/
		btHelp = new JButton ();
		btHelp.setOpaque(false);
		btHelp.setBorderPainted(false);
		btHelp.setContentAreaFilled(false);
		btHelp.setIcon(new ImageIcon(Help));
		btHelp.setBounds (175,300,250,50);
		btHelp.addActionListener(this);

		/**Creation of button bt3 with text "OPTIONS"**/
		btOptions = new JButton ();
		btOptions.setBorderPainted(false);
		btOptions.setContentAreaFilled(false);
		btOptions.setIcon(new ImageIcon(Options));
		btOptions.setBounds (175,400,250,50);
		btOptions.addActionListener(this);

		/**Creation of the label with the Title**/
		TitleLab = new JLabel();
		TitleLab.setBounds(210,75,250,100);
		TitleLab.setBackground(Color.white);
		TitleLab.setForeground(Color.black);
		TitleLab.setText("-MENU-");
		TitleLab.setFont(police50);

		/**Creation of the panel with everything inside**/
		panMainWind = new JPanel();
		panMainWind.setBounds(0, 0, 600, 600);
		panMainWind.setLayout(null);
		panMainWind.setBackground(Color.white);

		//Put a background image
		panMainWind.add (btStart);
		panMainWind.add (btOptions);
		panMainWind.add (btHelp);
		panMainWind.add (TitleLab);
		this.setContentPane(panMainWind);
	}

	public void HelpWind (){

		winHelp = new JDialog(this,"HELP");
		winHelp.setSize(600, 600);
		winHelp.setLocationRelativeTo(null);
		winHelp.setResizable(false);

		textHelp=new JTextArea(
				"GOAL"+"\n"+
						"Find the treasure"+"\n"+"\n"+
						"GAME COMMANDS"+"\n"+
						"Right Arrow: go to the right"+"\n"+
						"Left Arrow: go to the left"+"\n"+
						"Up Arrow: go upwards"+"\n"+
						"Down Arrow: go downwards"+"\n"+"\n"+
						"Before starting the game, go in the options menu to chose your character and your username"
				);
		textHelp.setEditable(false);
		winHelp.add(textHelp);
		winHelp.setVisible(true);
	}

	public void OptionsWind() throws ParseException{

		Toolkit T=Toolkit.getDefaultToolkit();

		RightArrow = T.getImage("right_Arrow.png");
		LeftArrow = T.getImage("left_Arrow.png");
		OK = T.getImage("OkButton.png");
		Girl_stand = T.getImage("Girl_stand.gif");
		PapiMario_stand = T.getImage("PapiMario_stand.gif");



		btRightArrow = new JButton();
		btRightArrow.setOpaque(false);
		btRightArrow.setBorderPainted(false);
		btRightArrow.setContentAreaFilled(false);
		btRightArrow.setIcon(new ImageIcon(RightArrow));
		btRightArrow.addActionListener(this);
		btRightArrow.setBounds(510,260,60,60);
		btRightArrow.addActionListener(this);

		btLeftArrow = new JButton();
		btLeftArrow.setOpaque(false);
		btLeftArrow.setBorderPainted(false);
		btLeftArrow.setContentAreaFilled(false);
		btLeftArrow.setIcon(new ImageIcon(LeftArrow));
		btLeftArrow.addActionListener(this);
		btLeftArrow.setBounds(60,260,60,60);
		btLeftArrow.addActionListener(this);

		btOk = new JButton();
		btOk.setOpaque(false);
		btOk.setBorderPainted(false);
		btOk.setContentAreaFilled(false);
		btOk.setIcon(new ImageIcon(OK));
		btOk.addActionListener(this);
		btOk.setBounds(460,20,120,40);
		btOk.addActionListener(this);


		labChar = new JLabel();
		labChar.setText("Please select your character"+"\n"+ "using the arrows");
		labChar.setFont(police42);
		labChar.setBounds(20, 20, 270, 100);

		labUsername = new JLabel();
		labUsername.setBounds(180,480,250,50);
		labUsername.setFont(police42);
		labUsername.setText("Please type your username:");

		textUsername =  new JFormattedTextField(new MaskFormatter("**********"));
		textUsername.setBounds(100, 520, 400, 20);
		textUsername.setIgnoreRepaint(false);
		textUsername.setEditable(true);

		labImChar = new JLabel();
		labImChar.setBounds(160,100,300, 340);
		labImChar.setIcon(new ImageIcon(PapiMario_stand));

		panOptionsWind = new JPanel();
		panOptionsWind.setBounds(0, 0, 600, 600);
		panOptionsWind.setLayout(null);
		panOptionsWind.setBackground(Color.white);

		panOptionsWind.add(labImChar);
		panOptionsWind.add(textUsername);
		panOptionsWind.add(labUsername);
		panOptionsWind.add(labChar);
		panOptionsWind.add(btOk);
		panOptionsWind.add(btLeftArrow);
		panOptionsWind.add(btRightArrow);

		this.setContentPane(panOptionsWind);

		this.repaint();

	}

	public void StartWind(){

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btHelp){
			HelpWind();
		}
		if (e.getSource()==btStart){
			this.repaint();
			StartWind();
		}
		if (e.getSource()==btOptions){
			this.repaint();
			try {
				OptionsWind();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()==btOk){
			StartWind();
		}
		/**2 options:
		 * 1- create an array of images and when clicking on the arrows,
		 * we change the number in the array
		 * or 2- we name the images for eg "Im1", "Im2" etc
		 * and we display the images "Im"+n and the n changes at each click**/
		if (e.getSource()==btRightArrow){

		}
		if (e.getSource()==btLeftArrow){

		}
	}

	public static void main (String[] args){
		Menu MainMenuWindow = new Menu();
	}
}

