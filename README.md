# JavaAnalytics

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
compare synchronized(OUTER_LOCK){ Thread.sleep(1000); } with synchronized(OUTER_LOCK){ synchronized(LOCK){LOCK.wait();} } and we can see that both instructions don't release the OUTER_LOCK. If there's any difference, we can say that sleep doesn't explicitly use java locks, 