package com.atguigu.juc.thread;

import java.util.HashMap;
import java.util.Map;

class MyCach{
	private volatile Map<String, Object> map= new HashMap<>();
	public void put(String key,Object value) {
		System.out.println(Thread.currentThread().getName()+"\t正在写入");
		map.put(key, value);
		
	}
	public Object get(String key) {
		System.out.println(Thread.currentThread().getName()+"\t正在读");
		Object object = map.get(key);
		System.out.println(Thread.currentThread().getName()+"\t读完了");
		return object;
	}
}
public class WriteReadLockTest {
	
	{
	
	MyCach myCach = new MyCach();
		for(int i=1;i<=5;i++) {
			final int tmp = i;
			new Thread(()-> {
				System.out.println("");
				
			},String.valueOf(i)).start() ;
		}
	}
}