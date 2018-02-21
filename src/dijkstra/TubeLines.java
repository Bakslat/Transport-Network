package dijkstra;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TubeLines {
	
	private String name;
	private List<Station> TubeStations;
	
	public TubeLines(String nameAndStation){
		TubeStations = new ArrayList<Station>();
		Scanner scanner = new Scanner (nameAndStation);
		name = scanner.next();
		
		while (scanner.hasNext()){
			TubeStations.add(new Station(scanner.next()));
		}
		scanner.close();
		
	}
	
	public String toString(){
		return "Underground line: " + name + " with " + "stations: " + TubeStations;
	}
	
	public String getName(){
		return name;
	}

}