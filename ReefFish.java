
public class ReefFish {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ReefFish() {
		name = "";
	}
	public ReefFish(String name) {
		setName(name);
	}
	@Override
	public String toString() {
		return String.format("%s", name);
	}
}
