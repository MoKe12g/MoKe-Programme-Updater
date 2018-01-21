import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Tools {
	
	static boolean containsString(String s, String subString) {
        return s.indexOf( subString ) > -1 ? true : false;
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
	
	public static void startandUpdateProgramm(String productName, String extension, String URL) throws IOException {
		try {
			Tools.saveUrl(Start.Pfad + "cache", URL);
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
	    Tools.saveUrl(Start.Pfad + productName + version + "." + extension, downloadURL);
	    if(extension == "jar") Runtime.getRuntime().exec(Start.Pfad + "java -jar " + productName + version + "." + extension);
	    if(extension == "exe") Runtime.getRuntime().exec(Start.Pfad + productName + version + "." + extension);
	    System.exit(0);
	}
	
}
