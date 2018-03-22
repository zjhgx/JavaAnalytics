package concurrent.locksupport;

import java.util.concurrent.TimeUnit;

public class ExecThread extends Thread{
	private FIFOMutex fifoMutex;
	
	public ExecThread(FIFOMutex fifoMutex, String name){
		super(name);

		this.fifoMutex = fifoMutex;
	}
	
	@Override
	public void run() {
		fifoMutex.lock();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fifoMutex.unlock();
	}
}
