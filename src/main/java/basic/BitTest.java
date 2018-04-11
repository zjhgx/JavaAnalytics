package basic;

public class BitTest {
	
	public static void main(String[] args){
		
		int i=10;
		String bi = Integer.toBinaryString(i); 
		System.out.println("i = " + bi);

		int j=12;
		int m=i & j;
		System.out.println("m = " + m);
		
		byte hash=-5;
        int hash_1 = hash & 0x7F;

        String binary = Integer.toBinaryString(hash_1);        
        System.out.println("binary=" + binary);
        System.out.println("hash_1=" + hash_1);
        
        int a=-2;
        String a_str = Integer.toBinaryString(a);      
        int b=a>>1;
        String b_str = Integer.toBinaryString(b);
        int bm=a<<1;
        String bm_str = Integer.toBinaryString(bm);
        int c=a>>>1;
        String c_str = Integer.toBinaryString(c);

        System.out.println("a_str=" + a_str);
        System.out.println("b_str=" + b_str);
        System.out.println(bm_str);

        System.out.println(c_str);
      
        System.out.println(1<<3);
        System.out.println(b);
        
	}
	

}
