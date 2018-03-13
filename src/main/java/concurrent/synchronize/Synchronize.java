package concurrent.synchronize;

public class Synchronize {
	private int count;
	private int increment;


	public void synchronizeClassObject(Lock lock,String threadName, int i){
		System.out.println(lock.getName());
		synchronized(lock){
			String lockName=lock.getName();
			increment++;
			System.out.println(lockName + "  increment["+increment+"]");

	//		System.out.println("increment["+increment+"],thread["+threadName+"],i["+i+"],object["+lock.getName()+"]");
			synchronized(Lock.class){
				count++;
				String name=lock.getName();
				System.out.println("count["+count+"],thread["+threadName+"],i["+i+"],object["+lock.getName()+"]");	
//				if(!lockName.equals(name)){
//					System.out.println("lockName="+lockName+ "name="+name);
//				}
			}
		}
	}
	
	public void synchronizeObject1(Lock lock){
		synchronized(lock){
			
		}
	}
	
	public void synchronizeObject2(Lock lock){
		synchronized(lock){
			
		}
	}
	
	public static void main(String[] args){
		Lock lock1=new Lock("lockA");
		Lock lock2=new Lock("lockB"); 
		Synchronize synchronize = new Synchronize();
		for(int i=0;i<1000;i++){
			TestThread threadA=new TestThread(lock1,"threadA"+i,synchronize,i);
			TestThread threadB=new TestThread(lock2,"threadB"+i,synchronize,i);

			threadA.start();
			threadB.start();
		}
		
		
	}
	

}


