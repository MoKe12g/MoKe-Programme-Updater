import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	
	static String Programmversion = "0.1a";
	static String os = "noscan";
	static String arch = "noscan";
	static String osversion = "noscan";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Willkommen beim MoKe Programme Programme Updater Version " + Programmversion);
		os = System.getProperty("os.name");
		arch = System.getProperty("os.arch");
		osversion = System.getProperty("os.version");
		System.out.println("You running " + os + " (" + arch + ") Version " + osversion);
		System.out.println();
		System.out.println("Zum Starten eines Programms den ersten Buchstaben eintippen und Enter druecken.");
		System.out.println("Was moechten sie starten?");
		System.out.println("-----------------------\\|/ Buchstabe");
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
		BufferedReader in  = new  BufferedReader (new  InputStreamReader ( System . in ));
		System.out.println("Bitte wähle nun ein Programm.");
		System.out.print("Meine Wahl fällt auf: ");
		String eingabe = in.readLine();
		
		if(eingabe.charAt(0) == 'F' || eingabe.charAt(0) == 'f') FunWriter.startFunWriter();
		if(eingabe.charAt(0) == 'D' || eingabe.charAt(0) == 'd') DataSafe.startDataSafe();
		if(eingabe.charAt(0) == 'Y' || eingabe.charAt(0) == 'y') YouTube_dl_GUI.startYouTube_dl_GUI();
		if(eingabe.charAt(0) == 'M' || eingabe.charAt(0) == 'm') MC_Server_Creator.startMC_Server_Creator();
	}

	private static boolean containsString( String s, String subString ) {
        return s.indexOf( subString ) > -1 ? true : false;
    }

}
