import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

public class Upgrade {
	
	public static void startUpgradeCheck() throws IOException {
		Console.Write("Suche nach neuerer Version...", true, true);
	try {
		Website.saveUrl(Start.Pfad + "cache","http://moke12g.de/programme/MoKe-Programme-Updater/index.html");
	} catch (MalformedURLException e) {

		e.printStackTrace();
	} catch (IOException e) {
		Console.Write("Du bist nicht Online oder der Server ist nicht erreichbar.", true, true);
		e.printStackTrace();
	}
	
	//Lese die Datei
	
	FileReader fr = new FileReader(Start.Pfad + "cache");
    BufferedReader br = new BufferedReader(fr);

    String version = br.readLine();
    String downloadURL = br.readLine();
    File file = new File(Start.Pfad + "cache");
    br.close();
    if(file.exists()) file.delete();
    if(Text.containsString(Start.Programmversion, version) != true) {
    	Console.Write("Es gibt eine neuere Version ihres Programmes.", true, true);
    	try {
    	int result = JOptionPane.showConfirmDialog(null, "Es ist eine neuere Version deines Programmes verfügbar, willst du Sie downloaden?", "Update herunterladen?", JOptionPane.YES_NO_OPTION);
    	if (result == JOptionPane.YES_OPTION) {
    		Console.Write("Benutzer Updatet das Programm", true, true);
    		Website.saveUrl("MoKe-Programme-Updater" + version + ".jar", downloadURL);
    		Runtime.getRuntime().exec(Start.Pfad + "java -jar " + "MoKe-Programme-Updater" + version + ".jar");
    		System.exit(0);
            }
    	else if (result == JOptionPane.NO_OPTION) {
    		Console.Write("Benutzer will das Update jetzt nicht herunterladen.", true, true);
    	}
    	}
    	catch(Exception e){
    		Console.Write("Benutzer Updatet das Programm", true, true);
    		Website.saveUrl("MoKe-Programme-Updater" + version + ".jar", downloadURL);
    		Console.Write("Bitte nun \"java -jar " + "MoKe-Programme-Updater" + version + ".jar\" ausführen, um das Update abzuschließen.", true, true);
    		System.exit(0);
    	}
    }
if(Text.containsString(Start.Programmversion, version) == true) {
	Console.Write("Ihr Programm ist aktuell.", true, true);
    }
	}
}