package org.cuatrovientos.larris.PSPActividad4Semaforos;

public class Container {
	
	private long saldo;
	private boolean isMoney = false;
	
	public synchronized int get(){
		while(!isMoney){
			try {
				wait();
			} catch (InterruptedException ex) {
				System.err.println(ex.getMessage());
			}
		}
		
		isMoney = false;
		
		System.out.println("Retirado " + cant);
	}
	
}
