package palleteer.domain;
	
	public class HawleItem extends Product {
		
		public HawleItem (String code, String name, double weight, int initCount) {
			super(code, name, weight, initCount);
		}
		
		public HawleItem (String code, String name, double weight) {
			super(code, name, weight);
		}
		
	}
