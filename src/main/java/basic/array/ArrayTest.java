package basic.array;

public class ArrayTest {
		
	static class Apple{
		private int height;
		private int width;	
		
		Apple next = null;
		
		Apple(int height, int width, Apple next){
			this.height=height;
			this.width=width;
			this.next=next;
		}
		
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		
		public String toString(){
			return "height ="+getHeight() + "width="+getWidth() + "next=" + (null==next?"NULL":next.toString());
		}
	}
	
	public static void main(String[] args){
		Apple[] apples = new Apple[4];
		Apple[] newApples = new Apple[4];
		
		Apple apple_0 = new Apple(10,10,null);
		Apple apple_1 = new Apple(20,20,null);
		apples[0] = new Apple(100,100,apple_0);
		apples[1] = new Apple(100,100,apple_1);
		System.out.println(apples[0]);
		System.out.println(apples[1]);
		
		Apple next = apples[0].next;
		
		apples[0].next = newApples[0];
		newApples[0]=apples[0];
		apples[0]=next;
		
		System.out.println(apples[0]);
		System.out.println("newApples[0]" + newApples[0]);
		
	}

}
