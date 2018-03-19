package dijkstra;
import java.util.ArrayList;

public class Dijkstra {

	public static int [] dijkstra (WeightedMap Map, int start){
		final int [] distance = new int [Map.sizeOfMap()];
		final int [] previous = new int [Map.sizeOfMap()];
		final boolean [] visited = new boolean [Map.sizeOfMap()]; 
		
		for (int i = 0; i < distance.length; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[start] = 0;
		
		for(int i = 0; i < distance.length; i++){
			final int next = minVertex (distance, visited);
			visited[next] = true;
			
			final int [] nex = Map.neighbours(next);
			for(int k = 0; k < nex.length; k++){
				final int v = nex[k];
				final int d = distance[next] + Map.getWeight(next, v);
				if(distance[v] > d){
					distance[v] = d;
					previous[v] = next;
				}	
			}
		}
		
		return previous;
	}
	
	
	
	public static int minVertex(int [] distance, boolean [] visit){
		int x = Integer.MAX_VALUE;
		int y = -1;
		for(int i = 0; i < distance.length; i++){
			if(!visit[i] && distance[i] < x){
				y = i;
				x = distance[i];
			}
		}
		
		return y;
	}
	
	public static void printJourney (WeightedMap Map, int [] previous, int start, int end){
		final ArrayList path = new ArrayList();
		int x = end;
		while(x != start){
			path.add(0, Map.getLabel(x));
			x = previous[x];
		}
		
		path.add(0, Map.getLabel(start));
		System.out.println("The path from: " + Map.getLabel(start) + " to " + Map.getLabel(end) + ": ");
		System.out.println(path);
	}
	
	public static ArrayList getPath (WeightedMap Map, int [] previous, int start, int end){
		final ArrayList path = new ArrayList();
		int x = end;
		while(x != start){
			path.add(0, Map.getLabel(x));
			x = previous[x];
		}
		
		path.add(0, Map.getLabel(start));
		
		return path;
	}
	
	public static int getCost (WeightedMap Map, int [] previous, int start, int end){
		final ArrayList path = new ArrayList();
		int x = end;
		int cost = 0;
		
		while(x != start){
			path.add(0, Map.getLabel(x));
			int y = x;
			x = previous[x];
			
			int temp = Map.getWeight(y, x);
			cost = cost + temp;
		}
		
		path.add(0, Map.getLabel(start));
		return cost;
	}
	
	
}
