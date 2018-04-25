package jvm.memory;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-UseAdaptiveSizePolicy -XX:+UseSerialGC
 * 
 * [GC[DefNew: 6987K->301K(9216K), 0.0265780 secs] 6987K->6445K(19456K), 0.0267760 secs] [Times: user=0.01 sys=0.02, real=0.03 secs] 
Heap
 def new generation   total 9216K, used 4643K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  53% used [0x00000000f9a00000, 0x00000000f9e3d7e0, 0x00000000fa200000)
  from space 1024K,  29% used [0x00000000fa300000, 0x00000000fa34b450, 0x00000000fa400000)
  to   space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
 tenured generation   total 10240K, used 6144K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  60% used [0x00000000fa400000, 0x00000000faa00030, 0x00000000faa00200, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 2486K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  11% used [0x00000000fae00000, 0x00000000fb06d9c0, 0x00000000fb06da00, 0x00000000fc2c0000)
No shared spaces configured.
 *
 *使用Serial + SerialOld组合执行到allocation4 = new byte[4 * _1MB]时发生了一次Minor GC，此时Eden区已有3个2MB对象无法放入Survivor空间，通过分配担保机制直接进入老年代，
 *所以最后老年代(tenured generation)占了6144K小于6M（还有一部分去哪了？），年轻代用了4643K
 *----------------------------------------------------------------------------------------------------------------------------
 *-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-UseAdaptiveSizePolicy
 *
 *Heap
 PSYoungGen      total 9216K, used 7316K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 8192K, 89% used [0x00000000ff600000,0x00000000ffd25050,0x00000000ffe00000)
  from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
  to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
 ParOldGen       total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 40% used [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000)
 PSPermGen       total 21504K, used 2486K [0x00000000f9a00000, 0x00000000faf00000, 0x00000000fec00000)
  object space 21504K, 11% used [0x00000000f9a00000,0x00000000f9c6d9c0,0x00000000faf00000)
 *
 *使用JD1.7K默认的Parallel Scavenge + SerialOld时没有发生Minor GC，年轻代PSYoungGen用了4096K，看起来在allocation4 = new byte[4 * _1MB]这句4M直接进入了老年代而没有触发
 *MinorGC
 */

public class TestAllocation {
	private static final int _1MB = 1024 *1024;
	public static void main(String[] args){
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];

	}
}
