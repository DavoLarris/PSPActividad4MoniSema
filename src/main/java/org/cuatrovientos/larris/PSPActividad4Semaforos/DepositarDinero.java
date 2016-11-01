package org.cuatrovientos.larris.PSPActividad4Semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DepositarDinero extends Thread{

	private Semaphore semaphore;
	
	public long depositarSaldo(long saldoActual, long saldoDepos){
		return (saldoActual+saldoDepos);
	}
	
	@Override
	public void run(){
		Random rdn = new Random();
		int cant;
		
		try {
			cuenta.getSemaphore().acquire();
			cant = rdn.nextInt(1000);
			
			this.depositarSaldo(cant);
			System.out.println("Depositada la cantidad de " + cant + " euros.");
			
			Thread.sleep(500);
			cuenta.getSemaphore().release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
