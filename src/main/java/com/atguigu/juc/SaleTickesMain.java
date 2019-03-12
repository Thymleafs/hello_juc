package com.atguigu.juc;

import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

import com.atguigu.juc.thread.SaleTickes;

public class SaleTickesMain {

	public static void main(String[] args) {

		SaleTickes saleTickes = new SaleTickes();

		/*
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { for(int i=0;i<40;i++) {
		 * saleTickes.saleTickes(); }
		 * 
		 * } },"A").start();;
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { for(int i=0;i<40;i++) {
		 * saleTickes.saleTickes(); } } },"B").start();;
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { for(int i=0;i<40;i++) {
		 * saleTickes.saleTickes(); } } },"C").start();;
		 */

		new Thread(() -> {for (int i = 0; i < 40; i++) saleTickes.saleTickes(); }, "A").start();
		new Thread(() -> {for (int i = 0; i < 40; i++) saleTickes.saleTickes(); }, "B").start();
		new Thread(() -> {for (int i = 0; i < 40; i++) saleTickes.saleTickes(); }, "C").start();
		new CopyOnWriteArrayList<>();
	}
}
