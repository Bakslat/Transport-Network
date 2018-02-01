import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		TubeMap map = new TubeMap("Map.txt");
		
		System.out.println(map.getLines());
		
		final WeightedMap lines = new WeightedMap(55);
		
		// Bakerloo Line:
		lines.setLabel(0, "Elephant and Castle (Bakerloo)");
		lines.setLabel(1, "Lamberh North (Bakerloo)");
		lines.setLabel(2, "Waterloo (Bakerloo)");
		lines.setLabel(3, "Embankment (Bakerloo)");
		lines.setLabel(4, "Charing Cross (Bakerloo)");
		lines.setLabel(5, "Piccadilly Circus (Bakerloo)");
		lines.setLabel(6, "Oxford Circus (Bakerloo)");
		lines.setLabel(7, "Regent's Park (Bakerloo)");
		lines.setLabel(8, "Baker Street (Bakerloo)");

		//Jubilee Line:
		lines.setLabel(9, "London Bridge (Jubilee)");
		lines.setLabel(10, "Southwark (Jubilee)");
		lines.setLabel(11, "Waterloo (Jubilee)");
		lines.setLabel(12, "Westminster (Jubilee)");
		lines.setLabel(13, "Green Park (Jubilee)");
		lines.setLabel(14, "Bond Street (Jubilee)");
		lines.setLabel(15, "(Baker Street (Jubilee)");
		
		//Piccadilly Line:
		lines.setLabel(16, "Green Park (Piccadilly)");
		lines.setLabel(17, "Piccadilly Circus (Piccadilly)");
		lines.setLabel(18, "Leicester Square (Piccadilly)");
		lines.setLabel(19, "Covent Garden (Piccadilly)");
		lines.setLabel(20, "Holborn (Piccadilly)");
		lines.setLabel(21, "Russel Square (Piccadilly)");
		lines.setLabel(22, "King's Cross St. Pancras (Piccadilly)");
		
		//Central Line:
		lines.setLabel(23, "Bond Street (Central)");
		lines.setLabel(24, "Oxford Circus (Central)");
		lines.setLabel(25, "Tottenham Court Road (Central)");
		lines.setLabel(26, "Holborn (Central)");
		lines.setLabel(27, "Chancery Lane (Central)");
		lines.setLabel(28, "St. Paul's (Central)");
		lines.setLabel(29, "Bank (Central)");
		lines.setLabel(30, "Liverpool Street (Central)");

		//Elizabeth Line:
		lines.setLabel(31, "Paddington (Elizabet)");
		lines.setLabel(32, "Bond Street (Elizabet)");
		lines.setLabel(33, "Tottenham Court Road (Elizabet)");
		lines.setLabel(34, "Farrington (Elizabet)");
		lines.setLabel(35, "Liverpool Street (Elizabet)");
		
		//Northern Line (via Charing Cross)
		lines.setLabel(36, "Kennington (Northern via Charing Cross)");
		lines.setLabel(37, "Waterloo (Northern via Charing Cross)");
		lines.setLabel(38, "Embankment (Northern via Charing Cross)");
		lines.setLabel(39, "Charing Cross (Northern via Charing Cross)");
		lines.setLabel(40, "Leicester (Northern via Charing Cross)");
		lines.setLabel(41, "Tottenham Court Road (Northern via Charing Cross)");
		lines.setLabel(42, "Goodge Street (Northern via Charing Cross)");
		lines.setLabel(43, "Warrent Street (Northern via Charing Cross)");
		lines.setLabel(44, "Euston (Northern via Charing Cross)");
		
		//Northern Line (via Bank)
		lines.setLabel(45, "Kennington (Northern via Bank)");
		lines.setLabel(46, "Elephant and Castle (Northern via Bank)");
		lines.setLabel(47, "Borough (Northern via Bank)");
		lines.setLabel(48, "London Bridge (Northern via Bank)");
		lines.setLabel(49, "Bank (Northern via Bank)");
		lines.setLabel(50, "Moorgate (Northern via Bank)");
		lines.setLabel(51, "Old Street (Northern via Bank)");
		lines.setLabel(52, "Angel (Northern via Bank)");
		lines.setLabel(53, "King's Cross St. Pancras (Northern via Bank)");
		lines.setLabel(54, "Euston (Northern via Bank)");
		
		//Bakerloo Connections (Start, Finish, Weight):
		lines.addEdge(0, 1, 2);
		lines.addEdge(1, 0, 2);
		lines.addEdge(1, 2, 2);
		lines.addEdge(2, 1, 2);
		lines.addEdge(2, 3, 1);
		lines.addEdge(3, 2, 1);
		lines.addEdge(3, 4, 1);
		lines.addEdge(4, 3, 1);
		lines.addEdge(4, 5, 2);
		lines.addEdge(5, 4, 2);
		lines.addEdge(5, 6, 2);
		lines.addEdge(6, 5, 2);
		lines.addEdge(6, 7, 2);
		lines.addEdge(7, 6, 2);
		lines.addEdge(7, 8, 2);
		lines.addEdge(8, 7, 2);
		
		//Jubilee Connections (Start, Finish, Weight):
		lines.addEdge(9, 10, 2);
		lines.addEdge(10, 9, 2);
		lines.addEdge(10, 11, 1);
		lines.addEdge(11, 10, 1);
		lines.addEdge(11, 12, 2);
		lines.addEdge(12, 11, 2);
		lines.addEdge(12, 13, 3);
		lines.addEdge(13, 12, 3);
		lines.addEdge(13, 14, 2);
		lines.addEdge(14, 13, 2);
		lines.addEdge(14, 15, 3);
		lines.addEdge(15, 14, 3);
		
		//Piccadilly Connections (Start, Finish, Weight):
		lines.addEdge(16, 17, 1);
		lines.addEdge(17, 16, 1);
		lines.addEdge(17, 18, 2);
		lines.addEdge(18, 17, 2);
		lines.addEdge(18, 19, 1);
		lines.addEdge(19, 18, 1);
		lines.addEdge(19, 20, 2);
		lines.addEdge(20, 19, 2);
		lines.addEdge(20, 21, 1);
		lines.addEdge(21, 20, 1);
		lines.addEdge(21, 22, 2);
		lines.addEdge(22, 21, 2);
		
		//Central Connections (Start, Finish, Weight):
		lines.addEdge(23, 24, 2);
		lines.addEdge(24, 23, 2);
		lines.addEdge(24, 25, 1);
		lines.addEdge(25, 24, 1);
		lines.addEdge(25, 26, 2);
		lines.addEdge(26, 25, 2);
		lines.addEdge(26, 27, 2);
		lines.addEdge(27, 26, 2);
		lines.addEdge(27, 28, 2);
		lines.addEdge(28, 27, 2);
		lines.addEdge(28, 29, 2);
		lines.addEdge(29, 28, 2);
		lines.addEdge(29, 30, 2);
		lines.addEdge(30, 29, 2);
		
		//Elizabeth Connections (Start, Finish, Weight):
		lines.addEdge(31, 32, 3);
		lines.addEdge(32, 31, 3);
		lines.addEdge(32, 33, 3);
		lines.addEdge(33, 32, 3);
		lines.addEdge(33, 34, 3);
		lines.addEdge(34, 35, 3);
		lines.addEdge(35, 34, 3);
		
		//Northern (via Charing Cross) (Start, Finish, Weight):
		lines.addEdge(36, 37, 3);
		lines.addEdge(37, 36, 3);
		lines.addEdge(37, 38, 2);
		lines.addEdge(38, 37, 2);
		lines.addEdge(38, 39, 1);
		lines.addEdge(39, 38, 1);
		lines.addEdge(39, 40, 2);
		lines.addEdge(40, 39, 2);
		lines.addEdge(40, 41, 1);
		lines.addEdge(41, 40, 1);
		lines.addEdge(41, 42, 1);
		lines.addEdge(42, 41, 1);
		lines.addEdge(42, 43, 2);
		lines.addEdge(43, 42, 2);
		lines.addEdge(43, 44, 1);
		lines.addEdge(44, 43, 1);
		
		//Northern (via Bank) (Start, Finish, Weight):
		lines.addEdge(45, 46, 2);
		lines.addEdge(46, 45, 2);
		lines.addEdge(46, 47, 2);
		lines.addEdge(47, 46, 2);
		lines.addEdge(47, 48, 1);
		lines.addEdge(48, 47, 1);
		lines.addEdge(48, 49, 2);
		lines.addEdge(49, 48, 2);
		lines.addEdge(49, 50, 2);
		lines.addEdge(50, 49, 2);
		lines.addEdge(50, 51, 2);
		lines.addEdge(51, 50, 2);
		lines.addEdge(51, 52, 3);
		lines.addEdge(52, 51, 3);
		lines.addEdge(52, 53, 2);
		lines.addEdge(53, 52, 2);
		lines.addEdge(53, 54, 2);
		lines.addEdge(54, 53, 2);
		
		
		
		//Print the map
		lines.print();

	}

}