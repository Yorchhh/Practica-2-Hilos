package PracticaHilos;

import java.util.ArrayList;

import com.sun.tools.javac.util.List;

public class App {

	public static void main(String[] args) {
		 TaskManager tm = new TaskManager(new ArrayList<Integer>(10));
		 Productor productor = new Productor(tm, 1);
		 Consumidor consumidor = new Consumidor(tm, 1);
		
		 for (int i=0;i<10;i++) {
			Thread hp = new Thread(productor);
			hp.start();
//			try {
//				hp.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		 
		 for(int i=0;i<10;i++) {
			 Thread hc = new Thread(consumidor);
			 hc.start();
			
//			 try {
//				hc.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		 }
		 
		 
		 
//		 Thread p = new Thread(productor);
//		 Thread c = new Thread(consumidor);
//		 p.start();
//		 c.start();
		
		
	}

}
