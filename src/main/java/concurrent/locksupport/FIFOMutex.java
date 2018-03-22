package concurrent.locksupport;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class FIFOMutex {
	private final AtomicBoolean locked = new AtomicBoolean(false);
	private final Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();

	public void lock() {
		boolean wasInterrupted = false;
		Thread current = Thread.currentThread();
		waiters.add(current);

		// Block while not first in queue or cannot acquire lock
		while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
			System.out.println(new Date() + " before park " + Thread.currentThread().getName());
			LockSupport.park(this);
			System.out.println(new Date() + " after park " + Thread.currentThread().getName());		
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(new Date() + " after sleep " + Thread.currentThread().getName());
			if (Thread.interrupted()) // ignore interrupts while waiting
				wasInterrupted = true;
		}

		waiters.remove();
		if (wasInterrupted) // reassert interrupt status on exit
			current.interrupt();
	}

	public void unlock() {
		locked.set(false);
		LockSupport.unpark(waiters.peek());
	}
	
	public static void main(String[] args){
		FIFOMutex fifoMutex = new FIFOMutex();
		ExecThread thread1= new ExecThread(fifoMutex, "thread1");
		ExecThread thread2= new ExecThread(fifoMutex, "thread2");
		ExecThread thread3= new ExecThread(fifoMutex, "thread3");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
}
