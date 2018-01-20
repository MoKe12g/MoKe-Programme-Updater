import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	
	static String Pfad = System.getProperty("user.home");
	static String Programmversion = "0.2e";
	static String os = "noscan";
	static String arch = "noscan";
	static String osversion = "noscan";
	public static Boolean selected = false;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Willkommen beim MoKe Programme programme Updater Version " + Programmversion);
		os = System.getProperty("os.name");
		arch = System.getProperty("os.arch");
		osversion = System.getProperty("os.version");
		if(Tools.containsString(os, "Linux") == true) System.out.println("You running " + os + " (" + arch + ") Kernelversion " + osversion);
		if(Tools.containsString(os, "Linux") == false) System.out.println("You running " + os + " (" + arch + ") Version " + osversion);
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
			JForm1 show = new JForm1(args);
			show.show();
		}
		catch(Exception e){
			
		}
		System.out.println();
		System.out.println("Zum Starten eines Programms den ersten Buchstaben eintippen und Enter druecken.");
		System.out.println("Was moechten sie starten?");
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
		System.out.println("Bitte waehlen sie nun ein Programm.");
		System.out.print("Meine Wahl faellt auf: ");
		BufferedReader in  = new  BufferedReader (new  InputStreamReader ( System . in ));
		if(eingabe == null) eingabe = in.readLine();
		
		try{
			if(eingabe.charAt(0) == 'F' || eingabe.charAt(0) == 'f') FunWriter.startFunWriter(args);
			if(eingabe.charAt(0) == 'D' || eingabe.charAt(0) == 'd') DataSafe.startDataSafe();
			if(eingabe.charAt(0) == 'Y' || eingabe.charAt(0) == 'y') YouTube_dl_GUI.startYouTube_dl_GUI();
			if(eingabe.charAt(0) == 'M' || eingabe.charAt(0) == 'm') MC_Server_Creator.startMC_Server_Creator();
			if(eingabe.charAt(0) == 'T' || eingabe.charAt(0) == 't') Taschenrechner.startTaschenrechner();

			if(Tools.containsString( eingabe, "hi" )) System.out.println("HI!!!! Lust auf Minecraft? ");
			if(selected == false) System.out.println("Leider wird bei diesem Buchstaben kein Programm gestartet. ");
		}
			catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println("Deine Eingabe war nicht korrekt.");
			}
	}

	private static void debug(String[] args){
		System.out.println("Manipuliere Daten...");
		os = "Windows 10";
		arch = "amd64";
		osversion = "10.0";
		System.out.println("You actualy running " + os + " (" + arch + ") Version " + osversion);
	}

}