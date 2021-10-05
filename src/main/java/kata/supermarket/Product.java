package kata.supermarket;

public abstract class Product {
	
	public enum CATEGORY {Drinks, Sweets, Biscuits, Fruit, Veg}

	private String name; //just using name here, there should also have id in real code
	private CATEGORY category;	//single for simplicity, should be a list 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CATEGORY getCategory() {
		return category;
	}
	public void setCategory(CATEGORY category) {
		this.category = category;
	}


	
	
}
