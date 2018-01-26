import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

public class Upgrade {
	
	public static void startUpgradeCheck() throws IOException {
		MoKe.Write("Suche nach neuerer Version...", true, true);
	try {
		Tools.saveUrl(Start.Pfad + "cache","http://moke12g.de/programme/MoKe-Programme-Updater/index.html");
	} catch (MalformedURLException e) {

		e.printStackTrace();
	} catch (IOException e) {
		MoKe.Write("Du bist nicht Online oder der Server ist nicht erreichbar.", true, true);
		e.printStackTrace();
	}
	
	//Lese die Datei
	
	FileReader fr = new FileReader(Start.Pfad + "cache");
    BufferedReader br = new BufferedReader(fr);

    String version = br.readLine();
    String downloadURL = br.readLine();
    File file = new File(Start.Pfad + "cache");
    if(file.exists()) file.delete();
    if(Tools.containsString(Start.Programmversion, version) != true) {
    	MoKe.Write("Es gibt eine neuere Version ihres Programmes.", true, true);
    	try {
    	int result = JOptionPane.showConfirmDialog(null, "Es ist eine neuere Version deines Programmes verf�gbar, willst du sie downloaden?", "Update herunterladen?", JOptionPane.YES_NO_OPTION);
    	if (result == JOptionPane.YES_OPTION) {
    		MoKe.Write("Benutzer Updatet das Programm", true, true);
    		Tools.saveUrl("MoKe-Programme-Updater" + version + ".jar", downloadURL);
    		Runtime.getRuntime().exec(Start.Pfad + "java -jar " + "MoKe-Programme-Updater" + version + ".jar");
    		System.exit(0);
            }
    	else if (result == JOptionPane.NO_OPTION) {
    		MoKe.Write("Benutzer will das Update jetzt nicht herunterladen.", true, true);
    	}
    	}
    	catch(Exception e){
    		MoKe.Write("Benutzer Updatet das Programm", true, true);
    		Tools.saveUrl("MoKe-Programme-Updater" + version + ".jar", downloadURL);
    		MoKe.Write("Bitte nun \"" + Start.Pfad + "java -jar " + "MoKe-Programme-Updater" + version + ".jar\" ausf�hren, um das Update abzuschlie�en.", true, true);
    		System.exit(0);
    	}
    }
if(Tools.containsString(Start.Programmversion, version) == true) {
	MoKe.Write("Ihr Programm ist aktuell.", true, true);
    }
	}
}