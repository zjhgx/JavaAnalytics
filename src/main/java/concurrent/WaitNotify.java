/**
 * 
 * 
 * 等待-通知模式
 * 
 * 
 **/
package concurrent;

import java.util.Date;

public class WaitNotify {
	//locker
	Object locker = new Object();
	Object lock = new Object();
	
	volatile boolean flag=false;
	
	public void startWaitNotify() throws InterruptedException{
		Waiter waiter = new Waiter();
		Notifier notifier =  new Notifier();
		Thread waiterThread = new Thread(new WaiterThread(waiter), "waitThread");
		Thread notifyThread = new Thread(new NotifyThread(notifier),"notifyThread");
		waiterThread.start();
		Thread.sleep(1000);
		notifyThread.start();
	}
	
	public static void main(String[] args){
		WaitNotify waitNotify = new WaitNotify();
		try{
			waitNotify.startWaitNotify();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	class WaiterThread implements Runnable{
		Waiter waiter = null;
		
		public WaiterThread(Waiter waiter){
			this.waiter = waiter;
		}
		@Override
		public void run() {
			waiter.execWait();
		}
		
	}
	
	class NotifyThread implements Runnable{
		
		Notifier notifier = null;
		public NotifyThread(Notifier notifier){
			this.notifier=notifier;
		}
		@Override
		public void run() {
			notifier.execNotify();			
		}
	}
	
	class Waiter{
		
		public void execWait(){
			synchronized(locker){
				while(!flag){
					try{
						System.out.println(new Date() + " Thread is waiting start" + Thread.currentThread().getName());						
						locker.wait();
						System.out.println(new Date() + " Thread is waiting end" + Thread.currentThread().getName());												
					}catch(Exception e){
						e.fillInStackTrace();
					}				
				}
			}	
			
			System.out.println(new Date() + "Thread is running " + Thread.currentThread().getName());
		}

	}
	
	class Notifier{
		public  void execNotify(){
			synchronized(locker){
				System.out.println(new Date() +  "Notify..." + Thread.currentThread().getName());
				locker.notify();
				flag=true;
				try{
					Thread.sleep(5000);					
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	

}
