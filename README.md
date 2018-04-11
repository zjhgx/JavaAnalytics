# JavaAnalytics

### classic bounded producer/consumer problem
A classic concurrency problem is that of the bounded producer/consumer, in which there is a queue or ring buffer of tasks with a maximum size, with one or more threads being "producer" threads that add tasks to the queue, and one or more other threads being "consumer" threads that take tasks out of the queue. The queue is assumed to be non–thread-safe itself, and it can be empty, full, or between empty and full. Whenever the queue is full of tasks, then we need the producer threads to block until there is room from consumer threads dequeueing tasks. On the other hand, whenever the queue is empty, then we need the consumer threads to block until more tasks are available due to producer threads adding them.<br>
As the queue is a concurrent object shared between threads, accesses to it must be made atomic, because the queue can be put into an inconsistent state during the course of the queue access that should never be exposed between threads. Thus, any code that accesses the queue constitutes a critical section that must be synchronized by mutual exclusion. If code and processor instructions in critical sections of code that access the queue could be interleaved by arbitrary context switches between threads on the same processor or by simultaneously-running threads on multiple processors, then there is a risk of exposing inconsistent state and causing race conditions.<br>
Incorrect without synchronization<br>
```
global RingBuffer queue; // A thread-unsafe ring-buffer of tasks.

// Method representing each producer thread's behavior:
public method producer(){
    while(true){
        task myTask=...; // Producer makes some new task to be added.
        while(queue.isFull()){} // Busy-wait until the queue is non-full.
        queue.enqueue(myTask); // Add the task to the queue.
    }
}

// Method representing each consumer thread's behavior:
public method consumer(){
    while(true){
        while (queue.isEmpty()){} // Busy-wait until the queue is non-empty.
        myTask=queue.dequeue(); // Take a task off of the queue.
        doStuff(myTask); // Go off and do something with the task.
    }
}
```
This code has a serious problem in that accesses to the queue can be interrupted and interleaved with other threads' accesses to the queue. The queue.enqueue and queue.dequeue methods likely have instructions to update the queue's member variables such as its size, beginning and ending positions, assignment and allocation of queue elements, etc. In addition, the queue.isEmpty() and queue.isFull() methods read this shared state as well. If producer/consumer threads are allowed to be interleaved during the calls to enqueue/dequeue, then inconsistent state of the queue can be exposed leading to race conditions. In addition, if one consumer makes the queue empty in-between another consumer's exiting the busy-wait and calling "dequeue", then the second consumer will attempt to dequeue from an empty queue leading to an error. Likewise, if a producer makes the queue full in-between another producer's exiting the busy-wait and calling "enqueue", then the second producer will attempt to add to a full queue leading to an error.<br>

### 关于Monitor
In concurrent programming, a monitor is a synchronization construct that allows threads to have both mutual exclusion and the ability to wait (block) for a certain condition to become true. Monitors also have a mechanism for signaling other threads that their condition has been met. A monitor consists of a mutex (lock) object and condition variables.<br>
Another definition of monitor is a thread-safe class, object, or module that uses wrapped mutual exclusion in order to safely allow access to a method or variable by more than one thread. The defining characteristic of a monitor is that its methods are executed with mutual exclusion: At each point in time, at most one thread may be executing any of its methods.<br>
While a thread is executing a method of a thread-safe object, it is said to occupy the object, by holding its mutex (lock). Thread-safe objects are implemented to enforce that at each point in time, at most one thread may occupy the object.<br>

wait c, m, where c is a condition variable and m is a mutex (lock) associated with the monitor.  This operation is called by a thread that needs to wait until the assertion Pc is true before proceeding. While the thread is waiting, it does not occupy the monitor.
* Atomically: 
	* a.release the mutex m,
	* b.move this thread from the "running" to c's "wait-queue" (a.k.a. "sleep-queue") of threads
	* c.sleep this thread. (Context is synchronously yielded to another thread.)
* Once this thread is subsequently notified/signalled (see below) and resumed, then automatically re-acquire the mutex
>The atomicity of the operations within step 1 is important to avoid race conditions that would be caused by a preemptive thread switch in-between them. One failure mode that could occur if these were not atomic is a missed wakeup, in which the thread could be on c's sleep-queue and have released the mutex, but a preemptive thread switch occurred before the thread went to sleep, and another thread called a signal/notify operation (see below) on c moving the first thread back out of c's queue. As soon as the first thread in question is switched back to, its program counter will be at step 1c, and it will sleep and be unable to be woken up again, violating the invariant that it should have been on c's sleep-queue when it slept.

signal c, also known as notify c, is called by a thread to indicate that the assertion Pc is true. Depending on the type and implementation of the monitor, this moves one or more threads from c's sleep-queue to the "ready queue" or another queues for it to be executed. It is usually considered a best practice to perform the "signal"/"notify" operation before releasing mutex m that is associated with c, but as long as the code is properly designed for concurrency and depending on the threading implementation, it is often also acceptable to release the lock before signalling.<br>

broadcast c, also known as notifyAll c, is a similar operation that wakes up all threads in c's wait-queue. This empties the wait-queue.<br> 

### sleep和wait有什么不同？
A wait can be "woken up" by another thread calling notify on the monitor which is being waited on whereas a sleep cannot. Also a wait (and notify) must happen in a block synchronized on the monitor object whereas sleep does not<br>
```Java
Object mon = ...;
synchronized (mon) {
    mon.wait();
} 
At this point the currently executing thread waits and releases the monitor. Another thread may do
synchronized (mon) { mon.notify(); }
```
Another point is that you call wait on Object itself (i.e. you wait on an object's monitor) whereas you call sleep on Thread.<br>
Yet another point is that you can get spurious wakeups from wait (i.e. the thread which is waiting resumes for no apparent reason). You should always wait whilst spinning on some condition as follows: 
```
synchronized {
    while (!condition) { mon.wait(); }
}
```
One key difference not yet mentioned is that while sleeping a Thread does not release the locks it holds, while waiting releases the lock on the object that wait() is called on.Waiting only releases the lock for the object you call wait() on. It doesn't release any other locks. <br>
```
synchronized(LOCK) {
    Thread.sleep(1000); // LOCK is held
}


synchronized(LOCK) {
    LOCK.wait(); // LOCK is not held
}
```
compare synchronized(OUTER_LOCK){ Thread.sleep(1000); } with synchronized(OUTER_LOCK){ synchronized(LOCK){LOCK.wait();} } and we can see that both instructions don't release the OUTER_LOCK. If there's any difference, we can say that sleep doesn't explicitly use java locks.

### synchronized(this)和synchronized(Classname.class)有什么不同？
* synchronized(this) acquires the lock of the instance this for the current thread. The method can run parallel on different instances (different values for this and therefore different locks)
* synchronized(SomeClass.class) acquires the lock of the global class object of SomeClass. Only one instance of the method can run as all object instances lock on the same global object (same lock).




