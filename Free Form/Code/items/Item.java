package items;

public class Item {
	private String name;
	private String description;
	private int price;
	private int sellPrice;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice){
		this.sellPrice = sellPrice;
	}

	@Override
	public String toString() {
		return name;
	}
}
