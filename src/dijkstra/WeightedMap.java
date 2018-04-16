package dijkstra;

public class WeightedMap {

	private int [][] edges;
	private Object[] labels;
	
	public WeightedMap (int n) {
		edges = new int [n][n];
		labels = new Object[n];
	}
	
	public int sizeOfMap(){
		return labels.length;
	}
	
	public void setLabel(int vertex, Object label){
		labels[vertex] = label;
	}
	
	public Object getLabel(int vertex){
		return labels[vertex];
	}
	
	public void addEdge(int start, int finish, int weight){
		edges[start][finish] = weight;
		if (weight < 1){
			System.out.println("Weight cannot be a number below 1");
		}
	}
	
	public boolean isEdge(int start, int finish){
		return edges[start][finish] > 0;
	}
	
	public int getWeight(int start, int finish){
		return edges[start][finish];
	}
	
	public int [] neighbours (int vertex) {
		int count = 0;
		for (int i = 0; i < edges[vertex].length; i++){
			if (edges[vertex][i] > 0){
				count++;
			}
		}
		
		final int[] answer = new int [count];
		count = 0;
		for (int i = 0; i < edges[vertex].length; i++){
			if (edges[vertex][i] > 0){
				answer[count++] = i; 
			}
		}
		
		return answer;
	}
	
	//Print the map
	public void print(){
		for(int i=0; i< edges.length; i++){
			System.out.print(labels[i] + " has connection with"  + ": ");

			System.out.println();
			for(int k=0; k < edges[i].length; k++){
				if(edges[i][k]>0){
					System.out.println(labels[k] + " with weight: " + edges [i][k]);
				}
			}
			System.out.println();
		}
	}
	
	//King's Cross to Waterloo
	public WeightedMap addOption1 (WeightedMap lines){
		
		lines.addEdge(75, 64, 5);
		lines.addEdge(64, 75, 5);
		
		return lines;
	}
	
	//King's Cross to Liverpool Street
	public WeightedMap addOption2 (WeightedMap lines){
		
		lines.addEdge(75, 78, 4);
		lines.addEdge(78, 75, 4);
		
		return lines;
	}
	
	//King's Cross to Victoria
	public WeightedMap addOption3 (WeightedMap lines) {
		
		lines.addEdge(75, 57, 4);
		lines.addEdge(57, 75, 4);
		
		return lines;
	}
	
	//King's Cross to Oxford Cirucs
	public WeightedMap addOption4 (WeightedMap lines) {
		
		lines.addEdge(75, 68, 3);
		lines.addEdge(68, 75, 3);
		
		return lines;
	}
	
	//Waterloo to Liverpool Street
	public WeightedMap addOption5 (WeightedMap lines) {
		
		lines.addEdge(64, 78, 4);
		lines.addEdge(78, 64, 4);
		
		return lines;
	}
	
	//Waterloo to Victoria
	public WeightedMap addOption6 (WeightedMap lines) { 
		
		lines.addEdge(64, 57, 3);
		lines.addEdge(57, 64, 3);
		
		return lines;
	}
	
	//Victoria to Liverpool Street
	public WeightedMap addOption7 (WeightedMap lines) {
		
		lines.addEdge(57, 78, 5);
		lines.addEdge(78, 57, 5);
		
		return lines;
	}
	
	//Method to populate the map
	public WeightedMap fillMap(WeightedMap lines){
		
		//Bakerloo Line:
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
		lines.setLabel(15, "Baker Street (Jubilee)");
		
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
		
		//Victoria Line:
		lines.setLabel(55, "Vauxhall (Victoria)");
		lines.setLabel(56, "Pimlico (Victoria)");
		lines.setLabel(57, "Victoria (Victoria)");
		lines.setLabel(58, "Green Park (Victoria)");
		lines.setLabel(59, "Oxford Circus (Victoria)");
		lines.setLabel(60, "Warren Street (Victoria)");
		lines.setLabel(61, "Euston (Victoria)");
		lines.setLabel(62, "King's Cross St. Pancras (Victoria)");
		
		//Stations (W/o lines):
		lines.setLabel(63, "Elephant and Castle");
		lines.setLabel(64, "Waterloo");
		lines.setLabel(65, "Embankment");
		lines.setLabel(66, "Charing Cross");
		lines.setLabel(67, "Piccadilly Circus");
		lines.setLabel(68, "Oxford Circus");
		lines.setLabel(69, "Baker Street");
		lines.setLabel(70, "London Bridge");
		lines.setLabel(71, "Green Park");
		lines.setLabel(72, "Bond Street");
		lines.setLabel(73, "Leicester Square");
		lines.setLabel(74, "Holborn");
		lines.setLabel(75, "King's Cross St. Pancras");
		lines.setLabel(76, "Tottenham Court Road");
		lines.setLabel(77, "Bank");
		lines.setLabel(78, "Liverpool Street");
		lines.setLabel(79, "Kennington");
		lines.setLabel(80, "Euston");
		lines.setLabel(81, "Warren Street");
		
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
		
		//Victoria connections (Start, Finish, Weight):
		lines.addEdge(55, 56, 1);
		lines.addEdge(56, 55, 1);
		lines.addEdge(56, 57, 2);
		lines.addEdge(57, 56, 2);
		lines.addEdge(57, 58, 2);
		lines.addEdge(58, 57, 2);
		lines.addEdge(58, 59, 2);
		lines.addEdge(59, 58, 2);
		lines.addEdge(59, 60, 2);
		lines.addEdge(60, 59, 2);
		lines.addEdge(60, 61, 1);
		lines.addEdge(61, 60, 1);
		lines.addEdge(61, 62, 2);
		lines.addEdge(62, 61, 2);
		
		//Intersections:
		
		//Elephant and Castle:
		lines.addEdge(0, 46, 1);
		lines.addEdge(0, 63, 1);
		lines.addEdge(46, 0, 1);
		lines.addEdge(46, 63, 1);
		lines.addEdge(63, 0, 1);
		lines.addEdge(63, 46, 1);
		
		//Waterloo:
		lines.addEdge(2, 11, 1);
		lines.addEdge(2, 37, 1);
		lines.addEdge(2, 64, 1);
		lines.addEdge(11, 2, 1);
		lines.addEdge(11, 37, 1);
		lines.addEdge(11, 64, 1);
		lines.addEdge(37, 2, 1);
		lines.addEdge(37, 11, 1);
		lines.addEdge(37, 64, 1);
		lines.addEdge(64, 2, 1);
		lines.addEdge(64, 11, 1);
		lines.addEdge(64, 37, 1);
		
		//Embankment:
		lines.addEdge(3, 38, 1);
		lines.addEdge(3, 65, 1);
		lines.addEdge(38, 3, 1);
		lines.addEdge(38, 65, 1);
		lines.addEdge(65, 3, 1);
		lines.addEdge(65, 38, 1);
		
		//Charing Cross:
		lines.addEdge(4, 39, 1);
		lines.addEdge(4, 66, 1);
		lines.addEdge(39, 4, 1);
		lines.addEdge(39, 66, 1);
		lines.addEdge(66, 4, 1);
		lines.addEdge(66, 39, 1);
		
		//Piccadilly Circus:
		lines.addEdge(5, 17, 1);
		lines.addEdge(5, 67, 1);
		lines.addEdge(17, 5, 1);
		lines.addEdge(17, 67, 1);
		lines.addEdge(67, 5, 1);
		lines.addEdge(67, 17, 1);
		
		//Oxford Circus:
		lines.addEdge(6, 24, 1);
		lines.addEdge(6, 59, 1);
		lines.addEdge(6, 68, 1);
		lines.addEdge(24, 6, 1);
		lines.addEdge(24, 59, 1);
		lines.addEdge(24, 68, 1);
		lines.addEdge(59, 6, 1);
		lines.addEdge(59, 24, 1);
		lines.addEdge(59, 68, 1);
		lines.addEdge(68, 6, 1);
		lines.addEdge(68, 24, 1);
		lines.addEdge(68, 59, 1);
		
		//Baker Street:
		lines.addEdge(8, 15, 1);
		lines.addEdge(8, 69, 1);
		lines.addEdge(15, 8, 1);
		lines.addEdge(15, 69, 1);
		lines.addEdge(69, 8, 1);
		lines.addEdge(69, 15, 1);
		
		//London Bridge:
		lines.addEdge(9, 48, 1);
		lines.addEdge(9, 70, 1);
		lines.addEdge(48, 9, 1);
		lines.addEdge(48, 70, 1);
		lines.addEdge(70, 9, 1);
		lines.addEdge(70, 48, 1);
		
		//Green Park:
		lines.addEdge(13, 16, 1);
		lines.addEdge(13, 58, 1);
		lines.addEdge(13, 71, 1);
		lines.addEdge(16, 13, 1);
		lines.addEdge(16, 58, 1);
		lines.addEdge(16, 71, 1);
		lines.addEdge(58, 13, 1);
		lines.addEdge(58, 16, 1);
		lines.addEdge(58, 71, 1);
		lines.addEdge(71, 13, 1);
		lines.addEdge(71, 16, 1);
		lines.addEdge(71, 58, 1);
		
		//Bond Street:
		lines.addEdge(14, 23, 1);
		lines.addEdge(14, 32, 1);
		lines.addEdge(14, 72, 1);
		lines.addEdge(23, 14, 1);
		lines.addEdge(23, 32, 1);
		lines.addEdge(23, 72, 1);
		lines.addEdge(32, 14, 1);
		lines.addEdge(32, 23, 1);
		lines.addEdge(32, 72, 1);
		lines.addEdge(72, 14, 1);
		lines.addEdge(72, 23, 1);
		lines.addEdge(72, 32, 1);
		
		//Leicester Square:
		lines.addEdge(18, 40, 1);
		lines.addEdge(18, 73, 1);
		lines.addEdge(40, 18, 1);
		lines.addEdge(40, 73, 1);
		lines.addEdge(73, 18, 1);
		lines.addEdge(73, 40, 1);
		
		//Holborn:
		lines.addEdge(20, 26, 1);
		lines.addEdge(20, 74, 1);
		lines.addEdge(26, 20, 1);
		lines.addEdge(26, 74, 1);
		lines.addEdge(74, 20, 1);
		lines.addEdge(74, 26, 1);
		
		//King's Cross St. Pancras:
		lines.addEdge(22, 53, 1);
		lines.addEdge(22, 62, 1);
		lines.addEdge(22, 75, 1);
		lines.addEdge(53, 22, 1);
		lines.addEdge(53, 62, 1);
		lines.addEdge(53, 75, 1);
		lines.addEdge(62, 22, 1);
		lines.addEdge(62, 53, 1);
		lines.addEdge(62, 75, 1);
		lines.addEdge(75, 22, 1);
		lines.addEdge(75, 53, 1);
		lines.addEdge(75, 62, 1);
		
		//Tottenham Court Road:
		lines.addEdge(25, 33, 1);
		lines.addEdge(25, 41, 1);
		lines.addEdge(26, 76, 1);
		lines.addEdge(33, 25, 1);
		lines.addEdge(33, 41, 1);
		lines.addEdge(33, 76, 1);
		lines.addEdge(41, 25, 1);
		lines.addEdge(41, 33, 1);
		lines.addEdge(41, 76, 1);
		lines.addEdge(76, 25, 1);
		lines.addEdge(76, 33, 1);
		lines.addEdge(76, 41, 1);
		
		//Bank:
		lines.addEdge(29, 49, 1);
		lines.addEdge(29, 77, 1);
		lines.addEdge(49, 29, 1);
		lines.addEdge(49, 77, 1);
		lines.addEdge(77, 29, 1);
		lines.addEdge(77, 49, 1);
		
		//Liverpool Street:
		lines.addEdge(30, 35, 1);
		lines.addEdge(30, 78, 1);
		lines.addEdge(35, 30, 1);
		lines.addEdge(35, 78, 1);
		lines.addEdge(78, 30, 1);
		lines.addEdge(78, 35, 1);
		
		//Kennington:
		lines.addEdge(36, 45, 1);
		lines.addEdge(36, 79, 1);
		lines.addEdge(45, 36, 1);
		lines.addEdge(45, 79, 1);
		lines.addEdge(79, 36, 1);
		lines.addEdge(79, 45, 1);
		
		//Euston:
		lines.addEdge(44, 54, 1);
		lines.addEdge(44, 61, 1);
		lines.addEdge(44, 80, 1);
		lines.addEdge(54, 44, 1);
		lines.addEdge(54, 61, 1);
		lines.addEdge(54, 80, 1);
		lines.addEdge(61, 44, 1);
		lines.addEdge(61, 54, 1);
		lines.addEdge(61, 80, 1);
		lines.addEdge(80, 44, 1);
		lines.addEdge(80, 54, 1);
		lines.addEdge(80, 61, 1);
		
		//Warren Street
		lines.addEdge(43, 60, 1);
		lines.addEdge(43, 81, 1);
		lines.addEdge(60, 43, 1);
		lines.addEdge(60, 81, 1);
		lines.addEdge(81, 43, 1);
		lines.addEdge(81, 60, 1);
		
		return lines;
	}
}