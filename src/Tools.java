import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

public class Tools {
	
	public static void startandUpdateProgramm(int programmID, boolean Exit) throws IOException {
		String productName = "NoProduct";
		String extension = "I dont have any idea";
		String URL = "Some whit MoKe in the Text";
		
		if(programmID == 0) {
			productName = "FunWriter";
			extension = "exe";
			URL = "http://moke12g.de/programme/FunWriter/index.html";
		}
		if(programmID == 1) {
			productName = "DataSafe";
			extension = "exe";
			URL = "http://moke12g.de/programme/DataSafe/index.html";
		}
		if(programmID == 2) {
			productName = "YouTube_dl_GUI";
			extension = "exe";
			URL = "http://moke12g.de/programme/YouTube_dl_GUI/index.html";
		}
		if(programmID == 3) {
			productName = "MCEasy";
			extension = "exe";
			URL = "http://moke12g.de/programme/MC_Server_Creator/index.html";
		}
		if(programmID == 4) {
			productName = "JTaschenrechner";
			extension = "jar";
			URL = "http://moke12g.de/programme/Taschenrechner/index.html";
		}
		
		try {
			Website.saveUrl(Start.Pfad + "cache", URL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileReader fr = new FileReader(Start.Pfad + "cache");
	    BufferedReader br = new BufferedReader(fr);
	    
	    String version = br.readLine();
	    String downloadURL = br.readLine();
	    File file = new File(Start.Pfad + "cache");
	    br.close();
	    if(file.exists()) file.delete();
	    Console.Write("Die neuste Version von " + productName + " ist " + version, true, true);
	    Console.Write("Programm wird heruntergeladen...", true, true);
	    Website.saveUrl(Start.Pfad + productName + version + "." + extension, downloadURL);
	    Console.Write("Programm wird gestartet...", true, true);
	    if(extension == "jar") Runtime.getRuntime().exec("java -jar " + Start.Pfad + productName + version + "." + extension);
	    if(extension == "exe") Runtime.getRuntime().exec(Start.Pfad + productName + version + "." + extension);
	    Console.Write("Programm ist gestartet.", true, true);
	    if(Exit == true) System.exit(0);
	}
	
}
