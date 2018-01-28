import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	static String Pfad = "";
	static String Programmversion = "0.3f";
	static String os = "noscan";
	static String arch = "noscan";
	static String osversion = "noscan";
	static String eingabe = null;
	public static Boolean selected = false;
	
	public static void main(String[] args) throws IOException {
		Console.Write("Willkommen beim MoKe Programme programme Updater Version " + Programmversion, true, true);
		Console.Write("MoKe Core Version " + MoKe.Version(), true, true);
		os = System.getProperty("os.name");
		arch = System.getProperty("os.arch");
		osversion = System.getProperty("os.version");
		if(Text.containsString(os, "Linux") == true) Console.Write("You running " + os + " (" + arch + ") Kernelversion " + osversion, true, true);
		if(Text.containsString(os, "Linux") == false) Console.Write("You running " + os + " (" + arch + ") Version " + osversion, true, true);
		Pfad = FileTools.Pfad("MoKeProgrammeUpdater");
		File dir = new File(Pfad);
		dir.mkdir();
		try{
			if(args[0] != "") Arguments.init(args);
		
		}
		catch(Exception i){}
		Upgrade.startUpgradeCheck();
		try {
			new SwingMain();
		}
		catch(Exception e){
			
		}
		Console.Write("Zum Starten eines Programms den ersten Buchstaben eintippen und Enter druecken.", true, true);
		Console.Write("Was moechten Sie starten?", true, true);
		Console.Write("-----------------------\\|/ Buchstabe", true, false);

		//Now Check System
		if(Text.containsString( os, "Windows" ) == true && Text.containsString( os, "2000" ) == false && Text.containsString( os, "9" ) == false ){
			System.out.println("FunWriter \t\tF");
		}
		
		if(Text.containsString( os, "Windows" ) == true && Text.containsString( os, "2000" ) == false && Text.containsString( os, "9" ) == false && Text.containsString( arch, "64" ) == true ){
			System.out.println("DataSafe\t\tD");
		}
		
		if(Text.containsString( os, "Windows" ) == true && Text.containsString( os, "2000" ) == false && Text.containsString( os, "9" ) == false ){
			System.out.println("YouTube-dl GUI \t\tY");
		}
		
		if(Text.containsString( os, "Windows" ) == true && Text.containsString( os, "2000" ) == false && Text.containsString( os, "9" ) == false ){
			System.out.println("MC Server Creator \tM");
		}
		System.out.println("Taschenrechner\t\tT");
		//Ready Checked System

		Console.Write("-----------------------/|\\ Buchstabe",true, false);
		Console.Write("Bitte waehlen Sie nun ein Programm.", true, true);
		Console.Write("Meine Wahl faellt auf: ", false, false);
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
		if(eingabe == null) eingabe = in.readLine();
		Console.Write("", true, false);
		
		try{
			
			if(eingabe.charAt(0) == 'F' || eingabe.charAt(0) == 'f') Tools.startandUpdateProgramm("FunWriter", "exe", "http://moke12g.de/programme/FunWriter/index.html", true);
			if(eingabe.charAt(0) == 'D' || eingabe.charAt(0) == 'd') Tools.startandUpdateProgramm("DataSafe", "exe", "http://moke12g.de/programme/DataSafe/index.html", true);
			if(eingabe.charAt(0) == 'Y' || eingabe.charAt(0) == 'y') Tools.startandUpdateProgramm("YouTube_dl_GUI", "exe", "http://moke12g.de/programme/YouTube_dl_GUI/index.html", true);
			if(eingabe.charAt(0) == 'M' || eingabe.charAt(0) == 'm') Tools.startandUpdateProgramm("MCEasy", "exe", "http://moke12g.de/programme/MC_Server_Creator/index.html", true);
			if(eingabe.charAt(0) == 'T' || eingabe.charAt(0) == 't') Tools.startandUpdateProgramm("JTaschenrechner", "jar", "http://moke12g.de/programme/Taschenrechner/index.html", true);

			if(Text.containsString( eingabe, "hi" )) Console.Write("HI!!!! Lust auf Minecraft? ", true, true);
			if(selected == false) Console.Write("Leider wird bei diesem Buchstaben kein Programm gestartet. ", true, true);
		}
			catch(java.lang.StringIndexOutOfBoundsException e){
				Console.Write("Deine Eingabe war nicht korrekt.", true, true);
			}
	}
	
	public static void FunWriter() {
		
	}
}