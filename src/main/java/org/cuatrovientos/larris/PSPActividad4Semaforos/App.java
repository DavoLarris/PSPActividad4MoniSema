package org.cuatrovientos.larris.PSPActividad4Semaforos;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
        Client cli = new Client(queue);

        cli.start();
        
        
    }
}
