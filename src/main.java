import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		TubeMap map = new TubeMap("Map.txt");
		
		System.out.println(map.getLines());
		
		final WeightedMap lines = new WeightedMap(23);
		lines.setLabel(1, "Waterloo");
		lines.setLabel(2, "Embankment");
		lines.setLabel(3, "Charing Cross");
		lines.setLabel(4, "Piccadilly Circus");
		lines.setLabel(5, "Oxford Circus");
		lines.setLabel(6, "Regent's Park");
		lines.setLabel(7, "Baker Street");
		lines.setLabel(8, "Westminster");
		lines.setLabel(9, "Green Park");
		lines.setLabel(10, "Bond Street");
		lines.setLabel(11, "Tottenham Court Road");
		lines.setLabel(12, "Holborn");
		lines.setLabel(13, "Chancery Lane");
		lines.setLabel(14, "St. Paul's");
		lines.setLabel(15, "Bank");
		lines.setLabel(16, "Liverpool Street");
		lines.setLabel(17, "Leicester Sqaure");
		lines.setLabel(18, "Covent Garden");
		lines.setLabel(19, "Russel Square");
		lines.setLabel(20, "King's Cross St. Pancras");
		lines.setLabel(21, "Paddington");
		lines.setLabel(22, "Farrington");
		lines.addEdge(1, 2, 1);
		lines.addEdge(1, 8, 1);
		lines.addEdge(2, 1, 1);
		lines.addEdge(2, 3, 1);
		lines.addEdge(3, 2, 1);
		lines.addEdge(3, 4, 1);
		lines.addEdge(4, 3, 1);
		lines.addEdge(4, 5, 1);
		lines.addEdge(4, 9, 1);
		lines.addEdge(4, 17, 1);
		lines.addEdge(5, 4, 1);
		lines.addEdge(5, 6, 1);
		lines.addEdge(5, 10, 1);
		lines.addEdge(5, 11, 1);
		lines.addEdge(6, 5, 1);
		lines.addEdge(6, 7, 1);
		lines.addEdge(7, 6, 1);
		lines.addEdge(7, 10, 1);
		lines.addEdge(8, 1, 1);
		lines.addEdge(8, 9, 1);
		lines.addEdge(9, 4, 1);
		lines.addEdge(9, 8, 1);
		lines.addEdge(9, 10, 1);
		lines.addEdge(10, 5, 1);
		lines.addEdge(10, 7, 1);
		lines.addEdge(10, 9, 1);
		lines.addEdge(10, 11, 1);
		lines.addEdge(10, 21, 1);
		lines.addEdge(11, 5, 1);
		lines.addEdge(11, 10, 1);
		lines.addEdge(11, 12, 1);
		lines.addEdge(11, 22, 1);
		lines.addEdge(12, 11, 1);
		lines.addEdge(12, 13, 1);
		lines.addEdge(12, 18, 1);
		lines.addEdge(12, 19, 1);
		lines.addEdge(13, 12, 1);
		lines.addEdge(13, 14, 1);
		lines.addEdge(14, 13, 1);
		lines.addEdge(14, 15, 1);
		lines.addEdge(15, 14, 1);
		lines.addEdge(15, 16, 1);
		lines.addEdge(16, 15, 1);
		lines.addEdge(16, 22, 1);
		lines.addEdge(17, 4, 1);
		lines.addEdge(17, 18, 1);
		lines.addEdge(18, 12, 1);
		lines.addEdge(18, 17, 1);
		lines.addEdge(19, 12, 1);
		lines.addEdge(19, 20, 1);
		lines.addEdge(20, 19, 1);
		lines.addEdge(21, 10, 1);
		lines.addEdge(22, 11, 1);
		lines.addEdge(22, 16, 1);
		lines.print();

	}

}