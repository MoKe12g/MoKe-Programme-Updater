import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

public class Upgrade {
	
	public static void startUpgradeCheck() throws IOException {
	System.out.println("Suche nach neuerer Version...");
	try {
		Tools.saveUrl(Start.Pfad + "cache","http://moke12g.de/programme/MoKe-Programme-Updater/index.html");
	} catch (MalformedURLException e) {

		e.printStackTrace();
	} catch (IOException e) {
		System.out.print("Du bist nicht Online oder der Server ist nicht erreichbar.");
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
    	System.out.println("Es gibt eine neuere Version ihres Programmes.");
    	try {
    	int result = JOptionPane.showConfirmDialog(null, "Es ist eine neuere Version deines Programmes verfügbar, willst du sie downloaden?", "Update herunterladen?", JOptionPane.YES_NO_OPTION);
    	if (result == JOptionPane.YES_OPTION) {
    		System.out.println("Benutzer Updatet das Programm");
    		Tools.saveUrl("MoKe-Programme-Updater" + version + ".jar", downloadURL);
    		Runtime.getRuntime().exec(Start.Pfad + "java -jar " + "MoKe-Programme-Updater" + version + ".jar");
    		System.exit(0);
            }
    	else if (result == JOptionPane.NO_OPTION) {
    		System.out.println("Benutzer will das Update jetzt nicht herunterladen.");
    	}
    	}
    	catch(Exception e){
    		System.out.println("Benutzer Updatet das Programm");
    		Tools.saveUrl("MoKe-Programme-Updater" + version + ".jar", downloadURL);
    		System.out.println("Bitte nun \"" + Start.Pfad + "java -jar " + "MoKe-Programme-Updater" + version + ".jar\" ausführen, um das Update abzuschließen.");
    		System.exit(0);
    	}
    }
if(Tools.containsString(Start.Programmversion, version) == true) {
    	System.out.println("Ihr Programm ist aktuell.");
    }
	}
}