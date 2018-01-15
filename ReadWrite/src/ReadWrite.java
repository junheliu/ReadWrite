import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadWrite {

	public static void main(String[] args) {
		
		Path file = 
				Paths.get(System.getProperty("user.home"),
						"projects","file","sample.txt");
		
		Path newFile = 
				Paths.get(System.getProperty("user.home"),
						"projects","file", "new.txt");
		
		Charset charset = Charset.forName("US-ASCII");
		
		try {
			
			Files.deleteIfExists(newFile);
			Files.createFile(newFile);
			BufferedWriter writer = 
					Files.newBufferedWriter(newFile, charset,
							StandardOpenOption.WRITE);
			
			BufferedReader reader =
					Files.newBufferedReader(file, charset);
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				writer.write(line);
				writer.write("\n");
			}
			writer.close();
		
					
		}catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	
	}

}

