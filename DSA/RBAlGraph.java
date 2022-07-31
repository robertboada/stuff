import java.util.*;

public class RBAlGraph {

	ArrayList<ArrayList<Integer>> verts;

	public RBAlGraph( int numNodes ){
		
		verts = new ArrayList<ArrayList<Integer>>( numNodes );

		for( int i = 0; i < verts.size(); i++){

			ArrayList<Integer> vertPointers = new ArrayList<Integer>();
			verts.add(i, vertPointers);

		}
		
	}
	
	private void addNode(){

		ArrayList<Integer> vertPointers = new ArrayList<Integer>();

		verts.add(vertPointers);

	}

	private boolean addEdge(int a , int b){

		if( a <= verts.size() && b <= verts.size() ){
			

			if ( verts.get(a).contains(b) && verts.get(b).contains(a) ){ 

				verts.get(a).add(b);
				verts.get(b).add(a);
			
				return true;
			}

			return false;
		}
		
		return false;

	}

	private void removeEdge( int a, int b ){
		
		if ( a <= verts.size() && b <= verts.size() ){

			if ( verts.get(a).contains(b) && verts.get(b).contains(a) ){

				verts.get(a).remove(verts.get(a).indexOf(b));
				verts.get(b).remove(verts.get(b).indexOf(a));

			}

		} 
		
	}

	private int size(){
		
		return verts.size();
	}

	
	private int numEdges(){ 
		
		int edgeCount = 0;

		for ( int i = 0; i < verts.size(); i++){
			
			edgeCount += verts.get(i).size();
		}

		return edgeCount / 2;
	}

	private int degree( int a ){

		int degree_count = 0;

		ArrayList<Integer> a_node = verts.get(a);

		for ( int i = 0; i < a_node.size();i++){

			if ( verts.get( a_node.get(i) ).contains(a)){
				degree_count++;
			} 
		}

		return degree_count;
	}

}
