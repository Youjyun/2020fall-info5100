/* 
Dessert Shoppe - Due Fri 10/16/2020, 11:59 pm. PST

The Sundae class should be derived from the IceCream class. The cost of a
Sundae is the cost of the IceCream plus the cost of the topping.
*/
public class Sundae extends IceCream {
	private String nameTopping;
	private int costTopping;

	public Sundae(String nameIceCream, int costIcecream, String nameTopping, int costTopping) {
		super(nameIceCream, costIcecream);
		this.nameTopping = nameTopping;
		this.costTopping = costTopping;
	}

	public int getCost() {
		return super.getCost() + costTopping;
	}

	public String getNameTopping() {
		return nameTopping;
	}

}
