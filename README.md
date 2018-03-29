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

### innodb clustered index 
the clustered index is synonymous with the primary key.Because modifying the columns of the clustered index is an expensive operation, choose primary columns that are rarely or never updated.
* When you define a PRIMARY KEY on your table, InnoDB uses it as the clustered index. Define a primary key for each table that you create. If there is no logical unique and non-null column or set of columns, add a new auto-increment column, whose values are filled in automatically.
* If you do not define a PRIMARY KEY for your table, MySQL locates the first UNIQUE index where all the key columns are NOT NULL and InnoDB uses it as the clustered index.
* If the table has no PRIMARY KEY or suitable UNIQUE index, InnoDB internally generates a hidden clustered index named GEN_CLUST_INDEX on a synthetic column containing row ID values. The rows are ordered by the ID that InnoDB assigns to the rows in such a table. The row ID is a 6-byte field that increases monotonically as new rows are inserted. Thus, the rows ordered by the row ID are physically in insertion order.

### InnoDB Locking
#### Shared and Exclusive Locks<br>
InnoDB implements standard row-level locking where there are two types of locks, shared (S) locks and exclusive (X) locks.<br>
* A shared (S) lock permits the transaction that holds the lock to read a row.
* An exclusive (X) lock permits the transaction that holds the lock to update or delete a row.
If transaction T1 holds a shared (S) lock on row r, then requests from some distinct transaction T2 for a lock on row r are handled as follows:<br>
A request by T2 for an S lock can be granted immediately. As a result, both T1 and T2 hold an S lock on r.<br>
A request by T2 for an X lock cannot be granted immediately.<br>
If a transaction T1 holds an exclusive (X) lock on row r, a request from some distinct transaction T2 for a lock of either type on r cannot be granted immediately. Instead, transaction T2 has to wait for transaction T1 to release its lock on row r.<br>

#### Intention Locks<br>
To make locking at multiple granularity levels practical, InnoDB uses intention locks. Intention locks are table-level locks that indicate which type of lock (shared or exclusive) a transaction requires later for a row in a table. <br>
Before a transaction can acquire a shared lock on a row in a table, it must first acquire an IS lock or stronger on the table.<br>
Before a transaction can acquire an exclusive lock on a row in a table, it must first acquire an IX lock on the table.<br>

#### Record Locks<br>
A record lock is a lock on an index record.the row-level locks are actually index-record locks

* InnoDB行锁是通过给索引上的索引项加锁来实现的，只有通过索引条件检索数据，InnoDB才使用行级锁，否则，InnoDB将使用表锁。
* 由于MySQL的行锁是针对索引加的锁，不是针对记录加的锁，所以虽然是访问不同行的记录，但是如果是使用相同的索引键，是会出现锁冲突的。应用设计的时候要注意这一点.
* 当表有多个索引的时候，不同的事务可以使用不同的索引锁定不同的行，另外，不论是使用主键索引、唯一索引或普通索引，InnoDB都会使用行锁来对数据加锁。
* 即便在条件中使用了索引字段，但是否使用索引来检索数据是由MySQL通过判断不同执行计划的代价来决定的，如果MySQL认为全表扫描效率更高，比如对一些很小的表，它就不会使用索引，这种情况下InnoDB将使用表锁，而不是行锁。因此，在分析锁冲突时，别忘了检查SQL的执行计划，以确认是否真正使用了索引。
* 检索值的数据类型与索引字段不同，虽然MySQL能够进行数据类型转换，但却不会使用索引，从而导致InnoDB使用表锁。通过用explain检查两条SQL的执行计划，我们可以清楚地看到了这一点。
* 由于MySQL的行锁是针对索引加的锁，不是针对记录加的锁，所以虽然是访问不同行的记录，但是如果是使用相同的索引键，是会出现锁冲突的.
* 当表有多个索引的时候，不同的事务可以使用不同的索引锁定不同的行，另外，不论是使用主键索引、唯一索引或普通索引，InnoDB都会使用行锁来对数据加锁。
* 即便在条件中使用了索引字段，但是否使用索引来检索数据是由MySQL通过判断不同执行计划的代价来决定的，如果MySQL认为全表扫描效率更高，比如对一些很小的表，它就不会使用索引，这种情况下InnoDB将使用表锁，而不是行锁。因此，在分析锁冲突时，别忘了检查SQL的执行计划，以确认是否真正使用了索引。

### clustered index & secondary index
* clustered primary key entry data set is a set of all record fields (key fields and not key fields)
* secondary index entry data is a union of its key fields and primary key fields (at least InnoDB and its derivatives don't duplicate primary key fields there, even if the primary and the secondary keys have a common subset of key fields) then secondary index entry data is always a subset of primary key entry. Unfortunately, key_info[nr].key_length doesn't show the length of key/pointer pair but a sum of key field lengths only, thus we can't estimate index IO volume comparing only this key_length value of secondary keys and clustered PK.So, try secondary keys first, and choose PK only if there are no usable secondary covering keys or found best secondary key include all table fields (i.e. same as PK):"

### Mysql index
The index entries act like pointers to the table rows, allowing the query to quickly determine which rows match a condition in the WHERE clause, and retrieve the other column values for those rows.unnecessary indexes waste space and waste time for MySQL to determine which indexes to use. Indexes also add to the cost of inserts, updates, and deletes because each index must be updated.Indexes are used to find rows with specific column values quickly. Without an index, MySQL must begin with the first row and then read through the entire table to find the relevant rows.<br>
索引为什么能加快搜索？索引已经排好序，可以用binary search来加快搜索速度<br>
* To find the rows matching a WHERE clause quickly.
* To eliminate rows from consideration. If there is a choice between multiple indexes, MySQL normally uses the index that finds the smallest number of rows (the most selective index).
* If the table has a multiple-column index, any leftmost prefix of the index can be used by the optimizer to look up rows. For example, if you have a three-column index on (col1, col2, col3), you have indexed search capabilities on (col1), (col1, col2), and (col1, col2, col3).
* To retrieve rows from other tables when performing joins. MySQL can use indexes on columns more efficiently if they are declared as the same type and size. In this context, VARCHAR and CHAR are considered the same if they are declared as the same size.
* For comparisons between nonbinary string columns, both columns should use the same character set. For example, comparing a utf8 column with a latin1 column precludes use of an index.
* Comparison of dissimilar columns (comparing a string column to a temporal or numeric column, for example) may prevent use of indexes if values cannot be compared directly without conversion. For a given value such as 1 in the numeric column, it might compare equal to any number of values in the string column such as '1', ' 1', '00001', or '01.e1'. This rules out use of any indexes for the string column.
* 

### Optimizing InnoDB Queries
* Do not specify too many or too long columns in the primary key, because these column values are duplicated in each secondary index. When an index contains unnecessary data, the I/O to read this data and memory to cache it reduce the performance and scalability of the server.
* Do not create a separate secondary index for each column, because each query can only make use of one index. Indexes on rarely tested columns or columns with only a few different values might not be helpful for any queries. If you have many queries for the same table, testing different combinations of columns, try to create a small number of concatenated indexes rather than a large number of single-column indexes. If an index contains all the columns needed for the result set (known as a covering index), the query might be able to avoid reading the table data at all.
* If an indexed column cannot contain any NULL values, declare it as NOT NULL when you create the table. The optimizer can better determine which index is most effective to use for a query, when it knows whether each column contains NULL values.
* Primary Key Optimization: Query performance benefits from the NOT NULL optimization, because it cannot include any NULL values. With the InnoDB storage engine, the table data is physically organized to do ultra-fast lookups and sorts based on the primary key column or columns.
* Foreign Key Optimization: If a table has many columns, and you query many different combinations of columns, it might be efficient to split the less-frequently used data into separate tables with a few columns each, and relate them back to the main table by duplicating the numeric ID column from the main table. That way, each small table can have a primary key for fast lookups of its data, and you can query just the set of columns that you need using a join operation. Depending on how the data is distributed, the queries might perform less I/O and take up less cache memory because the relevant columns are packed together on disk. (To maximize performance, queries try to read as few data blocks as possible from disk; tables with only a few columns can fit more rows in each data block.)
* 

### Avoiding Full Table Scans
REASON
* There are no usable restrictions in the ON or WHERE clause for indexed columns.
* You are comparing indexed columns with constant values and MySQL has calculated (based on the index tree) that the constants cover too large a part of the table and that a table scan would be faster. 
* You are using a key with low cardinality (many rows match the key value) through another column. In this case, MySQL assumes that by using the key it probably will do many key lookups and that a table scan would be faster.


### Estimating Query Performance
For bigger tables, you can estimate that, using B-tree indexes, you need this many seeks to find a row: log(row_count) / log(index_block_length / 3 * 2 / (index_length + data_pointer_length)) + 1.<br>
In MySQL, an index block is usually 1,024 bytes and the data pointer is usually four bytes. For a 500,000-row table with a key value length of three bytes (the size of MEDIUMINT), the formula indicates log(500,000)/log(1024/3*2/(3+4)) + 1 = 4 seeks.

