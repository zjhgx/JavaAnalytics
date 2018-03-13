package concurrent.synchronize;

public class TestThread extends Thread{

	private Lock lock;
	private String name;
	private Synchronize synchronize;
	private int i;
	
	public TestThread(Lock lock, String name, Synchronize synchronize,int i){
		this.lock=lock;
		this.name=name;
		this.synchronize = synchronize;
		this.i=i;
	}
	
	@Override
	public void run(){
		synchronize.synchronizeClassObject(lock,name, i);
	}
}
