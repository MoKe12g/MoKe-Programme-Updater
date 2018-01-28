import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingMain extends javax.swing.JFrame {
	private static final long serialVersionUID = 2031355551531380425L;
	public static final String ButtonLauscher = null;
	public static JLabel label1 = new JLabel();
	public static JButton startFunWriter = new JButton();
	public static JButton startYouTube_dl_GUI = new JButton();
	public static JButton startMCEasy = new JButton();
	public static JButton startJTaschenrechner = new JButton();
	public static JButton startDataSafe = new JButton();
	
	public SwingMain() {
		setTitle("MoKe-Programme-Updater " + Start.Programmversion);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		label1.setText("Bitte wähle ein Programm: \n");
		
		startFunWriter.setText("FunWriter");
		this.add(startFunWriter);
		
		startYouTube_dl_GUI.setText("YouTube-dl_GUI");
		this.add(startYouTube_dl_GUI);
		
		startMCEasy.setText("MCEasy");
		this.add(startMCEasy);
		
		startJTaschenrechner.setText("JTaschenrechner");
		this.add(startJTaschenrechner);
		
		startDataSafe.setText("DataSafe");
		this.add(startDataSafe);
		
		panel.add(label1);
		//Now Check System
		if(Text.containsString( Start.os, "Windows" ) == true && Text.containsString( Start.os, "2000" ) == false && Text.containsString( Start.os, "9" ) == false ){
			panel.add(startFunWriter);
		}
		
		if(Text.containsString( Start.os, "Windows" ) == true && Text.containsString( Start.os, "2000" ) == false && Text.containsString( Start.os, "9" ) == false && Text.containsString( Start.arch, "64" ) == true ){
			panel.add(startDataSafe);
		}
		
		if(Text.containsString( Start.os, "Windows" ) == true && Text.containsString( Start.os, "2000" ) == false && Text.containsString( Start.os, "9" ) == false ){
			panel.add(startYouTube_dl_GUI);
		}
		
		if(Text.containsString( Start.os, "Windows" ) == true && Text.containsString( Start.os, "2000" ) == false && Text.containsString( Start.os, "9" ) == false ){
			panel.add(startMCEasy);
		}
		
		panel.add(startJTaschenrechner); //Runns
		
		
		this.initListeners();
		
		this.add(panel);
		this.pack();
		int x = 0, y = 0, width = this.getWidth(), height = this.getHeight();
		Dimension d = Screen.getScreenResolution();
		x = (d.width - width) /2;
		y = (d.height - height) /2;
		setBounds(x, y, width, height);
		this.setMaximumSize(this.getSize());
		this.setMinimumSize(this.getSize());
		setVisible(true);
	}
	
	private void initListeners() {
		startFunWriter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tools.startandUpdateProgramm("FunWriter", "exe", "http://moke12g.de/programme/FunWriter/index.html");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		
		startDataSafe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tools.startandUpdateProgramm("DataSafe", "exe", "http://moke12g.de/programme/DataSafe/index.html");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		
		startYouTube_dl_GUI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tools.startandUpdateProgramm("YouTube_dl_GUI", "exe", "http://moke12g.de/programme/YouTube_dl_GUI/index.html");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		
		startMCEasy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tools.startandUpdateProgramm("MCEasy", "exe", "http://moke12g.de/programme/MC_Server_Creator/index.html");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		
		startJTaschenrechner.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tools.startandUpdateProgramm("JTaschenrechner", "jar", "http://moke12g.de/programme/Taschenrechner/index.html");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
	}
	
	public void startFunWriterEvent() {
		
	}
}
