package org.cuatrovientos.larris.PSPActividad4Semaforos;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Client extends Thread{

	private BlockingQueue<Integer> queue;
	private Random rdn;
	private static final Integer DINEROS = 100;
	private Integer dineros = DINEROS;
	
	public Client(BlockingQueue<Integer> queue) {
		this.queue = queue;
		this.rdn = new Random();
		
		try {
			this.queue.put(DINEROS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void depositar(Integer dinero) throws InterruptedException{
		if (!queue.isEmpty()){
			this.dineros = this.queue.take();
			System.out.println("Metemos dinero: " + (this.dineros+dinero));
			this.queue.put(this.dineros+dinero);
		}
	}
	
	public void retirar(Integer dinero) throws InterruptedException{
		if (!this.queue.isEmpty()){
			this.dineros = this.queue.take();
			if (dinero <= this.dineros){
				dineros = this.dineros - dinero;
				System.out.println("Sacamos dinero: " + this.dineros);
				this.queue.put(this.dineros);
			}
		}
	}
	
	
	public void run(){
		try {
			while (this.dineros > 0){
				if (this.rdn.nextInt(2) == 0){
					this.depositar(10);	
				} else {
					this.retirar(10);
				}
	
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
