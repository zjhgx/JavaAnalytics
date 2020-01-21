package basic;

import com.alibaba.fastjson.JSON;

public class JsonTest {
	public static void main(String[] args) {
		Integer[] ids = new Integer[] { 1, 2, 3 };

		System.out.println(JSON.toJSONString(ids));
	}
}
