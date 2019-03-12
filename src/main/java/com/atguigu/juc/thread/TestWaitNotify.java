package com.atguigu.juc.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class AirCondition{
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition  =  lock.newCondition();
	public  void increment() throws Exception {
		lock.lock();
		try {
			while(count!=0) {
				condition.await();
			}
			count++;
			System.out.println(Thread.currentThread().getName()+"   count值为："+count);
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public  void decrement() throws Exception {
		lock.lock();
		try {
			while(count==0) {
				condition.await();
			}
			count --;
			System.out.println(Thread.currentThread().getName()+"   count值为："+count);
			condition.signalAll();
		}catch (Exception e) {
			
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}
}

public class TestWaitNotify {

	public static void main(String[] args) {
		AirCondition airCondition = new AirCondition();
		CountDownLatch countDownLatch = new CountDownLatch(6);
			new Thread(()->{
				for(int i =1;i<=20;i++) {
					try {
						Thread.sleep(200);
						airCondition.increment();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			},String.valueOf("A")).start();;
			
			new Thread(()->{
				for(int i =1;i<=20;i++) {
					try {
						Thread.sleep(300);
						airCondition.decrement();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			},String.valueOf("B")).start();;
			new Thread(()->{
				for(int i =1;i<=20;i++) {
					try {
						Thread.sleep(500);
						airCondition.decrement();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			},String.valueOf("C")).start();
			
			new Thread(()->{
				for(int i =1;i<=20;i++) {
					try {
						Thread.sleep(300);
						airCondition.increment();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			},String.valueOf("D")).start();
		}
	
	
}
