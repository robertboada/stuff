public class HashTable<E>{

	double loadFactor;

	int numEntries;

	E[] table;

	public HashTable(){

		table = (E[]) new Object[7];

		numEntries = 0; 
	}

	public HashTable(double l){

		table = (E[]) new Object[7];
		loadFactor = l;
		numEntries = 0;
	}


	public boolean add(E val){

		int hash = val.hashCode() % table.length;

		if (table[hash] != null) {

			int i = 0;

			while (table[hash + i] != null) {

				i = ( hash + i*i ) % table.length;

				i++;
			}

			table[i] = val;
			numEntries += 1;
			loadFactor = numEntries / table.length;

			return true;

		}else{

			table[hash] = val;
			numEntries += 1;
			loadFactor = numEntries / table.length;

			return true;
		}

	}

	public boolean remove(E val){

		for ( int i =0; i < table.length; i++ ){

			if (table[i].equals(val)){

				table[i] = null;
				numEntries -= 1;
				loadFactor = numEntries / table.length;

				return true;
			}
		}

		return false;
	}

	public boolean contains(E val){

		for ( int i = 0; i < table.length; i++ ) {

			if(table[i].equals(val)){

				return true;
			}
		}
		return false;
	}



	private void expandTable(){

		if (loadFactor >= 0.5){

			int i = table.length *2;

			while ( i != table.length && i % 2 != 0 && i % 3 != 0 ){

				i++;
			}

			E[] temp;

			temp = (E[]) new Object[7];

			for ( int j = 0; j < table.length; j++ ){

				temp[j] = table[j];
			}

			table = temp;

			loadFactor = numEntries / table.length; 

		}
		
	}

}