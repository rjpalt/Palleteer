package palleteer.domain;

public enum PalletType {
	FIN(25.0),
	EUR(21.0),
	TEHO(10.0),
	MUU(0.0);

	private final double weight;

	PalletType(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

}