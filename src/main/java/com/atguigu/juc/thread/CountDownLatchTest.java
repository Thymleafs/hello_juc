package com.atguigu.juc.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for (int i = 1; i <= 6; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t被灭掉");
				countDownLatch.countDown();
			},CountryEnum.forEach_Country(i).getName()).start();;
			
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"\t统一华夏");
	}
}
