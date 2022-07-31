import java.util.*;

public class Heap{

	
	private ArrayList<String> heap;

	public boolean isMinHeap;

	public Heap(){ // min heap
		
		heap = new ArrayList<String>();
		isMinHeap = true;
	}

	public Heap(boolean b){
		
		if(b){
			isMinHeap = true; // min heap
		}
		else{
			isMinHeap = false; // max heap 
		}

	}

	public void add(String obj){
	
		heap.add(obj);
	
		if (isMinHeap){
			int i = heap.size() - 1;
			while (obj.compareTo(heap.get(i)) < 0){
			
				i = (i-1)/2;
			}
			swap(heap.indexOf(obj), i);
		}
		else{ // max heap

			int i = heap.size() - 1;
                        while (obj.compareTo(heap.get(i)) > 0){
                         
                                i = (i-1)/2;
                        }
			swap(heap.indexOf(obj), i);	
		}

	}
	private void swap(int index_1, int index_2){
	
		String temp = heap.get(index_2);

		heap.add(index_2,heap.get(index_1));

		heap.add(index_1,temp);

	}

	private String peek(){
		if(heap.size() > 0){
			return heap.get(0);
		}
		return null;
	}
	private void remove_helper(int cur){
	
		if(isMinHeap){ // when call on method initial parameter is always: 0

                        swap(0,heap.size()-1);
                        heap.remove(heap.size()-1);
                        int i = cur;
                        int smallest_index = i;
                        int left_node = 2 * i + 1;
                        int right_node = 2 * i +2;

                        if ( left_node < heap.size() && heap.get(left_node).compareTo(heap.get(smallest_index)) < 0 ){

                                smallest_index = left_node;
                        }
                        if ( right_node < heap.size() && heap.get(right_node).compareTo(heap.get(smallest_index)) < 0 ){

                                smallest_index = right_node;
                        }

                        if (smallest_index != i){

                                swap( smallest_index, i );

				remove_helper( smallest_index );
                        }

			

                }else{
			
			swap(0,heap.size()-1);
                        heap.remove(heap.size()-1);
                        int i = cur;
                        int biggest_index = i;
                        int left_node = 2 * i + 1;
                        int right_node = 2 * i +2;

                        if ( left_node < heap.size() && heap.get(left_node).compareTo(heap.get(biggest_index)) > 0 ){

                                biggest_index = left_node;
                        }
                        if ( right_node < heap.size() && heap.get(right_node).compareTo(heap.get(biggest_index)) > 0 ){

                                biggest_index = right_node;
                        }

                        if (biggest_index != i){

                                swap( biggest_index, i );

                                remove_helper( biggest_index );
                        }
                }

	}

	private void remove(){ // can only remove root
		
			remove_helper(0);
	}
	

}
