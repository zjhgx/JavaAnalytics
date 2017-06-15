package main.webapp.concurrent.calculate;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	
	public AtomicInteger ai=new AtomicInteger(0);

	public volatile int i;
	
	public  void  add(){
		i++;
		System.out.println(i);
	}
	
	public synchronized void addSafe(){
		i++;
	}
	
	public void  addAtomic(){
		 i=ai.incrementAndGet();
	}
	
	public  static void main(String[] args){
		Counter counter=new Counter();
		for(int i=0;i<1000;i++){
			IncrementTask thread = new IncrementTask(counter);
			thread.start();

		}
	
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("###" + counter.i);

	}
		
}
