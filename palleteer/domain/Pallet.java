package palleteer.domain;

import java.util.ArrayList;
import java.util.List;

public class Pallet {

	private PalletType type;
	private List<Product> contents;

	public Pallet (PalletType type) {

		this.type = type;
		this.contents = new ArrayList<Product>();

	}

	public Pallet () {

		this.type = PalletType.MUU;
		this.contents = new ArrayList<Product>();

	}

	public PalletType getType() {

		return this.type;

	}

	public void setType(PalletType type) {

		this.type = type;

	}

	public double getWeight() {

		return this.type.getWeight();

	}

	public void addProduct(Product product) {

		if (!this.contents.contains(product)) {
			this.contents.add(product);
		} else {
			this.contents.stream().forEach(listproduct -> {
				if (listproduct.equals(product)) {
					listproduct.addProduct();
				}
			});
		}

	}

	public double countTotalWeight() {

		double totalWeight = this.contents.stream()
				.mapToDouble(product -> product.getWeight())
				.sum();

		return totalWeight + this.type.getWeight();

	}


	public List<Product> contentList() {

		return this.contents;

	}

	public void listContents() {

		System.out.println (this.type + " type pallet containing " + this.contents.size() + " lines with a total weight of " + countTotalWeight() + " kg");
		System.out.println("");
		this.contents.stream().forEach(product -> {
			System.out.println(product);
		});

	}


	@Override
	public String toString() {
		return this.type + " type pallet containing " + this.contents.size() + " lines with a total weight of " + countTotalWeight() + " kg";
	}

}
