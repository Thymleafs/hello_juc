package com.atguigu.juc.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestArrayList {

//	测试ArrayList是线程不安全的
	public static void main(String[] args) {
		
		List<String> list= new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());//new Vector<>(); //new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			new Thread(()-> {
				list.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(list);
			},String.valueOf(i)).start() ;
			
		}
		new CopyOnWriteArraySet<>();
		new ConcurrentHashMap<>();
		
		Collections.synchronizedSet(new HashSet<>());
		new HashSet<>();
	}
}



