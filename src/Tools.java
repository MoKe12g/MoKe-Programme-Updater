import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

public class Tools {
	
	public static void startandUpdateProgramm(String productName, String extension, String URL) throws IOException {
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
	    Website.saveUrl(Start.Pfad + productName + version + "." + extension, downloadURL);
	    if(extension == "jar") Runtime.getRuntime().exec("java -jar " + Start.Pfad + productName + version + "." + extension);
	    if(extension == "exe") Runtime.getRuntime().exec(Start.Pfad + productName + version + "." + extension);
	    System.exit(0);
	}
	
}
