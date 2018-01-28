import java.io.IOException;

public class Arguments {
	
	public static void init(String[] args) throws IOException {

		if(Text.containsString( args[0], "--ea" ) == true) extractall();
		if(Text.containsString( args[0], "--debug" ) == true) Arguments.debug(args);
		if(Text.containsString( args[0], "--choose" ) == true) Start.eingabe = args[1];
		if(Text.containsString( args[0], "help" ) == true) help(args);
	}
	
	static void debug(String[] args){
		Console.Write("Manipuliere Daten...", true, true);
		Start.os = "Windows 10";
		Start.arch = "amd64";
		Start.osversion = "10.0";
		Console.Write("You actualy running " + Start.os + " (" + Start.arch + ") Version " + Start.osversion, true, true);
	}
	
	public static void help(String[] args) {
		Console.Write("Mögliche Argumente", true, false);
		Console.Write("------------------", true, false);
		Console.Write("Hilfe\t\t--help", true, false);
		Console.Write("Extract all\t--ea", true, false);
		Console.Write("Schnellwahl\t--choose + Buchstabe", true, false);
		Console.Write("Debug\t\t--debug", true, false);
		System.exit(0);
	}
	
	public static void extractall() throws IOException {
		Tools.startandUpdateProgramm("FunWriter", "exe", "http://moke12g.de/programme/FunWriter/index.html", false);
		Tools.startandUpdateProgramm("DataSafe", "exe", "http://moke12g.de/programme/DataSafe/index.html", false);
		Tools.startandUpdateProgramm("YouTube_dl_GUI", "exe", "http://moke12g.de/programme/YouTube_dl_GUI/index.html", false);
		Tools.startandUpdateProgramm("MCEasy", "exe", "http://moke12g.de/programme/MC_Server_Creator/index.html", false);
		Tools.startandUpdateProgramm("JTaschenrechner", "jar", "http://moke12g.de/programme/Taschenrechner/index.html", true);
	}
}
