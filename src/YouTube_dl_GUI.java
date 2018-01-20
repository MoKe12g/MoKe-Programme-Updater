import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

public class YouTube_dl_GUI {
	
	public static void startYouTube_dl_GUI() throws IOException {
		Start.selected = true;
		String productName = "YouTube_dl_GUI";
		String extension = "exe";
		try {
			Upgrade.saveUrl(Start.Pfad + "cache","http://moke12g.de/programme/YouTube_dl_GUI/index.html");
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
	    if(file.exists()) file.delete();
	    Upgrade.saveUrl(Start.Pfad + productName + version + "." + extension, downloadURL);
	    if(extension == "jar") Runtime.getRuntime().exec(Start.Pfad + "java -jar " + productName + version + "." + extension);
	    if(extension == "exe") Runtime.getRuntime().exec(Start.Pfad + productName + version + "." + extension);
	    System.exit(0);
	}
}
