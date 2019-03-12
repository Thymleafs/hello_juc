package com.atguigu.juc.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer>{

	private  final static Integer ADJUST_VALUE = 10;
	private int begin;
	private int end;
	private int result;
	
	
	public MyTask(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		if((end - begin) <= MyTask.ADJUST_VALUE) {
			for(int i =begin;i<=end;i++) {
				result = result + i;
			}
		}else {
			int middle = (begin+end)/2;
			MyTask myTask1 = new MyTask(begin, middle);
			MyTask myTask2 = new MyTask(middle+1, end);
			myTask1.fork();
			myTask2.fork();
			result = myTask1.join() + myTask2.join();
		}
		return result;
	}
	
	
}
public class ForkJoinTest {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
			MyTask myTask = new MyTask(0,100);
			ForkJoinPool threadPool = new ForkJoinPool();
			ForkJoinTask<Integer> forkJoinTask = threadPool.submit(myTask);
			System.out.println(forkJoinTask.get());
			threadPool.shutdown();
 	}
}
