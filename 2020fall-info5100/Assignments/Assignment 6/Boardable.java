/**
 * Created by Yuchun Chou on 10/29/20.
 */

public interface Boardable {
	void setBoardStart(int month, int day, int year);

	void setBoardEnd(int month, int day, int year);

	boolean boarding(int month, int day, int year);
}
