package concurrent.synchronize;

public class Lock {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lock(String name){
		this.name=name;
	}
}
