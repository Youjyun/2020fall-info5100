/* 
Dessert Shoppe - Due Fri 10/16/2020, 11:59 pm. PST
*/
public class DessertShoppe {

	public final static double TAX_RATE = 6.5; // 6.5%
	public final static String STORE_NAME = "M & M Dessert Shoppe";
	public final static int MAX_ITEM_NAME_SIZE = 25;
	public final static int COST_WIDTH = 6;
	public final static int MAX_CHECKOUT_ITMES = 100;

	/**
	 * A static method, which takes an integer number of cents and returns it as a
	 * String formatted in dollars and cents. <\br> For example, 105 cents would be
	 * returned as "1.05".
	 * 
	 * @param cents number of cents.
	 * @return
	 */
	public static String cents2dollarsAndCents(int cents) {

		String s = "";

		if (cents < 0) {
			s += "-";
			cents *= -1;
		}

		int dollars = cents / 100;
		cents = cents % 100;

		if (dollars > 0) {
			s += dollars;
		}

		s += ".";

		if (cents < 10) {
			s += "0";
		}

		s += cents;
		return s;
	}
}