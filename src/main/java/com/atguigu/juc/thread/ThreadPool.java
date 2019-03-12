package com.atguigu.juc.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	ExecutorService threadPool = Executors.newFixedThreadPool(5);
	ExecutorService threadPool2 = Executors.newCachedThreadPool();
	ExecutorService threadPool3 = Executors.newSingleThreadExecutor();
	
	
}
