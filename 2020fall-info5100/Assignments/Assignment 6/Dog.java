/**
 * Created by Yuchun Chou on 10/29/20.
 */

import java.time.LocalDate;


public class Dog extends Pet implements Boardable {
	private String size;
	public LocalDate startDate;
	public LocalDate endDate;

	public Dog(String name, String ownerName, String color, String size) {
		super(name, ownerName, color);
		this.size = size;
	}

	@Override
	public void setBoardStart(int month, int day, int year) {
		startDate = LocalDate.of(year, month, day);
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		endDate = LocalDate.of(year, month, day);
	}

	@Override
	public boolean boarding(int month, int day, int year) {
		LocalDate boardDate = LocalDate.of(year, month, day);
		if (boardDate.isAfter(startDate) && boardDate.isBefore(endDate)) {
			return true;
		}
		if (boardDate.isEqual(startDate) || boardDate.isEqual(endDate)) {
			return true;
		}
		return false;
	}

	public String getSize() {
		return size;
	}

	public String toString() {
		return "DOG:\n" + super.toString() + "\nSize: " + getSize();
	}

}