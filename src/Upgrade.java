import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JOptionPane;

public class Upgrade {
	
	public static void startUpgradeCheck() throws IOException {
	System.out.println("Suche nach neuerer Version...");
	try {
		saveUrl("cache","https://sites.google.com/view/moke12g/programme/moke-programme-software-updater");
	} catch (MalformedURLException e) {

		e.printStackTrace();
	} catch (IOException e) {
		System.out.print("Du bist nicht Online oder der Server ist nicht erreichbar.");
		e.printStackTrace();
	}
	
	//Lese die Datei
	
	FileReader fr = new FileReader("cache");
    BufferedReader br = new BufferedReader(fr);

    String website = br.readLine();
    br.close();
    File file = new File("cache");
    if(file.exists()) file.delete();
    if(containsString(website, Start.Programmversion) == false) {
    	System.out.println("Es gibt eine neuere Version ihres Programmes.");
    	int result = JOptionPane.showConfirmDialog(null, "Es ist eine neuere Version deines Programmes verfügbar, willst du sie downloaden?", "Update herunterladen?", JOptionPane.YES_NO_OPTION);
    	if (result == JOptionPane.YES_OPTION) {
    		System.out.println("Benutzer Updatet das Programm");
    		//Webseite zum Downloaden öffnen
    		URL url = null;
            try {
                url = new URL("https://sites.google.com/view/moke12g/programme/moke-programme-software-updater");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            if(Desktop.isDesktopSupported()){
                try {
                    Desktop.getDesktop().browse(url.toURI());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
    	} else if (result == JOptionPane.NO_OPTION) {
    		System.out.println("Benutzer will das Update jetzt nicht herunterladen.");
    	} 
    }
if(containsString(website, Start.Programmversion) == true) {
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

private static boolean containsString(String s, String subString) {
    return s.indexOf( subString ) > -1 ? true : false;
}
}