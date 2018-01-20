import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	
	static String Pfad = System.getProperty("user.home");
	static String Programmversion = "0.2b";
	static String os = "noscan";
	static String arch = "noscan";
	static String osversion = "noscan";
	public static Boolean selected = false;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Willkommen beim MoKe Programme programme Updater Version " + Programmversion);
		os = System.getProperty("os.name");
		arch = System.getProperty("os.arch");
		osversion = System.getProperty("os.version");
		System.out.println("You running " + os + " (" + arch + ") Version " + osversion);
		Pfad = Pfad + "\\MoKe-Programme-Updater\\";
		File dir = new File(Pfad);
		dir.mkdir();
		try{
		if(containsString( args[0], "debug" ) == true) debug(args);
		}
		catch(Exception i){}
		System.out.println();
		Upgrade.startUpgradeCheck();
		System.out.println();
		System.out.println("Zum Starten eines Programms den ersten Buchstaben eintippen und Enter druecken.");
		System.out.println("Was moechten sie starten?");
		System.out.println("-----------------------\\|/ Buchstabe");

		//Now Check System
		if(containsString( os, "Windows" ) == true && containsString( os, "2000" ) == false && containsString( os, "9" ) == false ){
			System.out.println("FunWriter \t\tF");
		}
		
		if(containsString( os, "Windows" ) == true && containsString( os, "2000" ) == false && containsString( os, "9" ) == false && containsString( arch, "64" ) == true ){
			System.out.println("DataSafe\t\tD");
		}
		
		if(containsString( os, "Windows" ) == true && containsString( os, "2000" ) == false && containsString( os, "9" ) == false ){
			System.out.println("YouTube-dl GUI \t\tY");
		}
		
		if(containsString( os, "Windows" ) == true && containsString( os, "2000" ) == false && containsString( os, "9" ) == false ){
			System.out.println("MC Server Creator \tM");
		}
		System.out.println("Taschenrechner\t\tT");
		//Ready Checked System

		System.out.println("-----------------------/|\\ Buchstabe");
		System.out.println("Bitte waehlen sie nun ein Programm.");
		System.out.print("Meine Wahl faellt auf: ");
		String eingabe = "";
		BufferedReader in  = new  BufferedReader (new  InputStreamReader ( System . in ));
		eingabe = in.readLine();
		
		try{
			if(eingabe.charAt(0) == 'F' || eingabe.charAt(0) == 'f') FunWriter.startFunWriter(args);
			if(eingabe.charAt(0) == 'D' || eingabe.charAt(0) == 'd') DataSafe.startDataSafe();
			if(eingabe.charAt(0) == 'Y' || eingabe.charAt(0) == 'y') YouTube_dl_GUI.startYouTube_dl_GUI();
			if(eingabe.charAt(0) == 'M' || eingabe.charAt(0) == 'm') MC_Server_Creator.startMC_Server_Creator();
			if(eingabe.charAt(0) == 'T' || eingabe.charAt(0) == 't') Taschenrechner.startTaschenrechner();

			if(containsString( eingabe, "hi" )) System.out.println("HI!!!! Lust auf Minecraft? ");
			if(selected == false) System.out.println("Leider wird bei diesem Buchstaben kein Programm gestartet. ");
		}
			catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println("Deine Eingabe war nicht korrekt.");
			}
	}

	static boolean containsString(String s, String subString) {
        return s.indexOf( subString ) > -1 ? true : false;
    }

	private static void debug(String[] args){
		System.out.println("Manipuliere Daten...");
		os = "Windows 10";
		arch = "amd64";
		osversion = "10.0";
		System.out.println("You actualy running " + os + " (" + arch + ") Version " + osversion);
	}

}