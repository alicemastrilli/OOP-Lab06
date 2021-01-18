package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
    private static final int TO_MS = 1_000_000;
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	ArrayList<Integer> list = new ArrayList<>();
    	int i;
    	for(i=1000; i< 2000 ; i++) {
    		list.add(i);
    	}
    	LinkedList<Integer> list2 = new LinkedList<>();
    	list2.addAll(list);
    	int first = list.get(0);
    	int last = list.get(list.size() - 1);
    	list.set(0, last); 
    	list.set(list.size()-1  , first);
    	for(int elem : list) {
    		System.out.println(elem);
    	}
    	long time = System.nanoTime();
    	int k;
    	for(k = 0; k<= 100000; k++) {
    		list.add(0, k);
    		list2.add(0, k);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("tempo per popolare lista e array di 100000 elementi :" +time/TO_MS +"ms");
    	
    	long time2 = System.nanoTime();
    	int l=0;
    	for(l = 0; l<=1000; l++) {
    		list.get(list.size()/2);
    		list2.get(list2.size()/2);
    	}
    	time2 = System.nanoTime() - time2;
    	System.out.println("tempo per leggere 1000 elementi da array e list : "+time2/TO_MS +"ms" );
    	
    	HashMap<String, Long> map = new HashMap<>();
    	map.put("Africa", 1100635000L);
    	map.put("Americas", 972005000L);
    	map.put("Antartica", 0L);
    	map.put("Asia", 4298723000L);
    	map.put("Europe", 742452000L);
    	map.put("Oceania", 38304000L);
    	
    	long result=0;
    	for(Long a : map.values()) {
    		result+= a;
    	}
    	System.out.println("Popolazione totale = " + result);        
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
        /*
         * 8) Compute the population of the world
         */
    }
}
