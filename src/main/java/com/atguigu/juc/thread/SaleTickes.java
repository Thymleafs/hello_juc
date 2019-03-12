package com.atguigu.juc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.atguigu.juc.SaleTickesMain;

public class SaleTickes {
	Lock lock =  new ReentrantLock();
	private int tol = 30 ;
/*	public void saleTickes() {
		synchronized (SaleTickesMain.class) {
			
			if(tol>0) {
				System.out.println(Thread.currentThread().getName()+"卖出第"+tol--+"票");
			}
				
			
		}
		
	
	}*/
	public void saleTickes() {
		
			
		
				
			
			lock.lock();
			try {
				if(tol>0) {
					System.out.println(Thread.currentThread().getName()+"卖出第"+tol--+"票");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			
	
		
	
	}
}
