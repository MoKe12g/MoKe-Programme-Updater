import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class Upgrade {
	
	public static void startUpgradeCheck() throws IOException {
	System.out.println("Suche nach neuerer Version...");
	try {
		saveUrl(Start.Pfad + "cache","http://moke12g.de/programme/MoKe-Programme-Updater/index.html");
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
    if(Start.containsString(Start.Programmversion, version) != true) {
    	System.out.println("Es gibt eine neuere Version ihres Programmes.");
    	int result = JOptionPane.showConfirmDialog(null, "Es ist eine neuere Version deines Programmes verfügbar, willst du sie downloaden?", "Update herunterladen?", JOptionPane.YES_NO_OPTION);
    	if (result == JOptionPane.YES_OPTION) {
    		System.out.println("Benutzer Updatet das Programm");
    		saveUrl("MoKe-Programme-Updater" + version + ".jar", downloadURL);
    		Runtime.getRuntime().exec(Start.Pfad + "java -jar " + "MoKe-Programme-Updater" + version + ".jar");
    		System.exit(0);
            }
    	else if (result == JOptionPane.NO_OPTION) {
    		System.out.println("Benutzer will das Update jetzt nicht herunterladen.");
    	} 
    }
if(Start.containsString(Start.Programmversion, version) == true) {
    	System.out.println("Ihr Programm ist aktuell.");
    }
	}

public static void saveUrl(final String filename, final String urlString)
        throws MalformedURLException, IOException {
    BufferedInputStream in = null;
    FileOutputStream fout = null;
    try {
        in = new BufferedInputStream(new URL(urlString).openStream());
        fout = new FileOutputStream(filename);

        final byte data[] = new byte[1024];
        int count;
        while ((count = in.read(data, 0, 1024)) != -1) {
            fout.write(data, 0, count);
        }
    } finally {
        if (in != null) {
            in.close();
        }
        if (fout != null) {
            fout.close();
        }
    }
}
}