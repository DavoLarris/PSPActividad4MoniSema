package org.cuatrovientos.larris.PSPActividad4Semaforos;

import java.util.concurrent.BlockingQueue;

public class Client extends Thread{

	private BlockingQueue<Integer> queue;
	
	public Client(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	public void run(){
		
	}
}
