package org.cuatrovientos.larris.PSPActividad4Semaforos;

import java.util.concurrent.SynchronousQueue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
        RetirarDinero ret = new RetirarDinero(queue);
        DepositarDinero dep = new DepositarDinero(queue);

        ret.start();
        dep.start();
        
        
    }
}
