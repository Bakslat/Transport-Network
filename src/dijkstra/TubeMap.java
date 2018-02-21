package dijkstra;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TubeMap {

	private List<TubeLines> lines;
	public TubeMap(String path) throws FileNotFoundException {
		lines = new ArrayList<TubeLines>();
		Scanner scanner = new Scanner (new File(path));
		
		while (scanner.hasNextLine()){
			lines.add(new TubeLines(scanner.nextLine()));
		}
		
		scanner.close();
	}
	
	public String toString (){
		return "Map " + lines;
	}
	
	public List<TubeLines> getLines() {
		return lines;
	}
}