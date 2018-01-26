import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Start {
	
	static JFrame meinJFrame = new JFrame();
	static JButton startFunWriter = new JButton();
	
	static String Pfad = System.getProperty("user.home");
	static String Programmversion = "0.2f";
	static String os = "noscan";
	static String arch = "noscan";
	static String osversion = "noscan";
	public static Boolean selected = false;
	
	public static void main(String[] args) throws IOException {
		MoKe.Write("Willkommen beim MoKe Programme programme Updater Version " + Programmversion, true, true);
		MoKe.Write("MoKe Core Version " + MoKe.Version(), true, true);
		os = System.getProperty("os.name");
		arch = System.getProperty("os.arch");
		osversion = System.getProperty("os.version");
		if(Tools.containsString(os, "Linux") == true)MoKe.Write("You running " + os + " (" + arch + ") Kernelversion " + osversion, true, true);
		if(Tools.containsString(os, "Linux") == false) MoKe.Write("You running " + os + " (" + arch + ") Version " + osversion, true, true);
		Pfad = Pfad + "\\MoKe-Programme-Updater\\";
		File dir = new File(Pfad);
		dir.mkdir();
		String eingabe = null;
		try{
			
		if(Tools.containsString( args[0], "debug" ) == true) debug(args);
		if(Tools.containsString( args[0], "choose" ) == true) eingabe = args[1];
		
		}
		catch(Exception i){}
		System.out.println();
		Upgrade.startUpgradeCheck();
		System.out.println();
		try {
			JPanel panel = new JPanel();
	 
	        // JButton mit Text "Drück mich" wird erstellt
	        startFunWriter.addInputMethodListener(ButtonLauscher.startFunWriter);
	        startFunWriter.setText("FunWriter");
	 
	        // JButton wird dem Panel hinzugefügt
	        panel.add(startFunWriter);
	 
	        meinJFrame.add(panel);
	 
	        // Fenstergröße wird so angepasst, dass 
	        // der Inhalt reinpasst
	        meinJFrame.pack();
	 
	        meinJFrame.setVisible(true);
		}
		catch(Exception e){
			
		}
		System.out.println();
		MoKe.Write("Zum Starten eines Programms den ersten Buchstaben eintippen und Enter druecken.", true, true);
		MoKe.Write("Was moechten Sie starten?", true, true);
		System.out.println("-----------------------\\|/ Buchstabe");

		//Now Check System
		if(Tools.containsString( os, "Windows" ) == true && Tools.containsString( os, "2000" ) == false && Tools.containsString( os, "9" ) == false ){
			System.out.println("FunWriter \t\tF");
		}
		
		if(Tools.containsString( os, "Windows" ) == true && Tools.containsString( os, "2000" ) == false && Tools.containsString( os, "9" ) == false && Tools.containsString( arch, "64" ) == true ){
			System.out.println("DataSafe\t\tD");
		}
		
		if(Tools.containsString( os, "Windows" ) == true && Tools.containsString( os, "2000" ) == false && Tools.containsString( os, "9" ) == false ){
			System.out.println("YouTube-dl GUI \t\tY");
		}
		
		if(Tools.containsString( os, "Windows" ) == true && Tools.containsString( os, "2000" ) == false && Tools.containsString( os, "9" ) == false ){
			System.out.println("MC Server Creator \tM");
		}
		System.out.println("Taschenrechner\t\tT");
		//Ready Checked System

		System.out.println("-----------------------/|\\ Buchstabe");
		MoKe.Write("Bitte waehlen sie nun ein Programm.", true, true);
		System.out.print("Meine Wahl faellt auf: ");
		BufferedReader in  = new  BufferedReader (new  InputStreamReader ( System . in ));
		if(eingabe == null) eingabe = in.readLine();
		
		try{
			
			if(eingabe.charAt(0) == 'F' || eingabe.charAt(0) == 'f') Tools.startandUpdateProgramm("FunWriter", "exe", "http://moke12g.de/programme/FunWriter/index.html");
			if(eingabe.charAt(0) == 'D' || eingabe.charAt(0) == 'd') Tools.startandUpdateProgramm("DataSafe", "exe", "http://moke12g.de/programme/DataSafe/index.html");
			if(eingabe.charAt(0) == 'Y' || eingabe.charAt(0) == 'y') Tools.startandUpdateProgramm("YouTube_dl_GUI", "exe", "http://moke12g.de/programme/YouTube_dl_GUI/index.html");
			if(eingabe.charAt(0) == 'M' || eingabe.charAt(0) == 'm') Tools.startandUpdateProgramm("MCEasy", "exe", "http://moke12g.de/programme/MC_Server_Creator/index.html");
			if(eingabe.charAt(0) == 'T' || eingabe.charAt(0) == 't') Tools.startandUpdateProgramm("JTaschenrechner", "jar", "http://moke12g.de/programme/Taschenrechner/index.html");

			if(Tools.containsString( eingabe, "hi" )) MoKe.Write("HI!!!! Lust auf Minecraft? ", true, true);
			if(selected == false) MoKe.Write("Leider wird bei diesem Buchstaben kein Programm gestartet. ", true, true);
		}
			catch(java.lang.StringIndexOutOfBoundsException e){
				MoKe.Write("Deine Eingabe war nicht korrekt.", true, true);
			}
	}

	private static void debug(String[] args){
		MoKe.Write("Manipuliere Daten...", true, true);
		os = "Windows 10";
		arch = "amd64";
		osversion = "10.0";
		MoKe.Write("You actualy running " + os + " (" + arch + ") Version " + osversion, true, true);
	}
	
	public static void FunWriter() {
		
	}
}