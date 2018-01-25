
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
	
}