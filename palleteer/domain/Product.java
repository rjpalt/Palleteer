package palleteer.domain;

public abstract class Product {
		
	private String productId;
	private String productName;
	private double weight;
	private int count;
	
	public Product(String code, String name, double weight, int initCount) {
		
		this.productId = code;
		this.productName = name;
		this.weight = weight;
		this.count = initCount;
		
	}
	
	public Product(String code, String name, double weight) {
		
		this.productId = code;
		this.productName = name;
		this.weight = weight;
		this.count = 1;
		
	}
	
	public void setTuotekoodi(String newCode) {
		this.productId = newCode;
	}
	
	public String getProductId() {
		return this.productId;
	}
	
	public void setWeight(double newWeight) {
		this.weight = newWeight;
	}
	
	public double getWeight() {
		return this.weight * this.count;
	}
	
	public double getTotalWeight() {
		return this.weight * this.count;
	}
	
	public void setName(String newName) {
		this.productName = newName;
	}
	
	public String getName() {
		return this.productName;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int newCount) {
		this.count = newCount;
	}
	
	public void addProduct() {
		this.count++; 
	}
	
	public void removeProduct() {
		this.count--;
	}	
		
	@Override
	public String toString() {
		return this.productId + ", " + this.productName + " (à " + this.weight + "), " + this.count + " pieces " + this.getTotalWeight() + " kg";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (count != other.count)
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
	

	
}
