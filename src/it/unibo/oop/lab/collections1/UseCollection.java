package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	private static final int ELEM = 100000;
    private static final int TO_MS = 1_000_000;
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	ArrayList<Integer> arr = new ArrayList<>();
    	int count=0;
    	for(count=1000 ; count<2000 ; count++) {
    		arr.add(count);
    	}
    	//System.out.println(arr);
    	/*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	LinkedList<Integer> list = new LinkedList<>();
    	list.addAll(arr);
    	
    	//System.out.println(list);
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int primo = arr.get(0);
    	int ultimo = arr.get(arr.size() -1 );
    	arr.set(0, ultimo);
    	arr.set(arr.size() - 1, primo);
    	
    	//System.out.println(arr);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for(int i : arr) {
    		System.out.println(i);
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();
    	
    	for (int i=0 ; i < ELEM ; i++) {
    		arr.add(i);
    		list.add(i);
    	}
    	
    	time = System.nanoTime()-time;
    	System.out.println(time/TO_MS + "ms");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	long time2 = System.nanoTime();
    	for (int i = 0 ; i< 1000 ; i++) {
    		arr.get((arr.size())/2);
    		list.get((list.size())/2);
    	}
    	time2=System.nanoTime()-time2;
    	System.out.println(time2/TO_MS + "ms");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	HashMap<String, Long> continenti = new HashMap<>(); 
    	continenti.put("Africa",(long) 1110635000 );
    	continenti.put("America",(long) 972005000 );
    	continenti.put("Antartride",(long) 0 );
    	continenti.put("Asia",(long ) 4298723000L );
    	continenti.put("Europa",(long) 742452000 );
    	continenti.put("Oceania",(long) 38304000 );
        /*
         * 8) Compute the population of the world
         */
    	long abit=0;
    	for(long elem : continenti.values()) {
    		abit = abit + elem;
    	}
    	System.out.println(abit);
    	
    }
}
