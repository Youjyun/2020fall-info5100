/**
 * Created by Yuchun Chou on 10/29/20.
 */

import java.util.*;

public class Mreview implements Comparable<Mreview> {
	// instance variables
	private String title; // title of the movie
	private ArrayList<Integer> ratings; // list of ratings stored in a Store object

	public Mreview() {
		
	}

	public Mreview(String title) {
		this.title = title;
	}

	public Mreview(String title, int firstRating) {
		this.title = title;
		ratings = new ArrayList<>();
		ratings.add(firstRating);
	}

	// methods
	public void addRating(int r) {
		ratings.add(r);
	}

	public double aveRating() {
		double fsum = 0;
		for (Integer i : ratings) {
			fsum += i;
		}
		return fsum / ratings.size();
	}

	public int compareTo(Mreview obj) {
		int result = this.title.compareTo(obj.title);
		if (result > 0) {
			return 1;
		} else if (result < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Mreview)) {
			return false;
		}

		Mreview m = (Mreview) o;

		return title.equals(m.title);

	}

	public String getTitle() {
		return title;
	}

	public int numRatings() {
		return ratings.size();
	}
    //XXX, average YYY out of ZZZ ratings
	public String toString() {
		return title + ", average "+ aveRating()+" out of "+ratings.size();
	}

	public static void main(String[] arg) {
		Mreview m = new Mreview("Kill Bill", 3);
		m.addRating(5);
		m.addRating(1);
		System.out.println(m.toString());
		System.out.println(m.aveRating());
	}
}
