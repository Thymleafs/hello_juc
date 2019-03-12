package com.atguigu.juc.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier cyclicbarrier= new CyclicBarrier(7,()->{
			
			System.out.println(Thread.currentThread().getName()+"\t召唤神龙");
		});
		for(int i=1;i<=7;i++) {
			final int tmp = i;
			new Thread(()-> {
				
				System.out.println(Thread.currentThread().getName()+"\t收第"+tmp+"龙珠");
				try {
					cyclicbarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
		
	}
	
	
	
}
