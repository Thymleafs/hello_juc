package com.atguigu.juc.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class ComplatableFutureTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
			  System.out.println(Thread.currentThread().getName()+"\t hello java1018");
		});
		completableFuture.get();*/
		CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
			  System.out.println(Thread.currentThread().getName()+"\t hello java1018");
			  int i  = 10/0;
			  return 1024;
		}).whenComplete((t,u)->{
			
			System.out.println("**********"+t);
			System.out.println("********"+u);
		}).exceptionally(f -> {
			System.out.println("**********"+f.getMessage());
			return  444;
		});
		System.out.println(completableFuture2.get());
	}
}
