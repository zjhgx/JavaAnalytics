package concurrent.calculate;

public class IncrementTask extends Thread{
	
	public Counter counter;
	
	public IncrementTask(Counter counter){
		this.counter=counter;
	}

	@Override
	public void run() {
		counter.add();
//		counter.addSafe();
		
//		counter.addAtomic();
	}

}
