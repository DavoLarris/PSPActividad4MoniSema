package org.cuatrovientos.larris.PSPActividad4Semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class RetirarDinero extends Thread{

	private Semaphore semaphore;
	private boolean retirado;

	public RetirarDinero(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public long retirarSaldo(long saldoActual, long saldoRetirar) {
		
		long saldoResultado = saldoActual - saldoRetirar;
		
		if (saldoResultado > 0) {
			retirado = true;
			return saldoResultado;
		}
		retirado = false;
		return saldoActual;
	}
	
	@Override
	public void run(){
		Random rdn = new Random();
		int cant;
		
		try {
			semaphore.acquire();
			cant = rdn.nextInt(1000);
			
			if (retirado) {
				System.out.println("Retirados " + cant + " de euros");
			} else {
				System.out.println("No fue posible retirar " + cant + " de euros");
			}
			
			Thread.sleep(500);
			semaphore.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
