package PracticaHilos;

public class Productor implements Runnable {
	private TaskManager tm;
	private int loops=10;

	
	public Productor(TaskManager tm, int loops) {
 		this.tm = tm;
		this.loops = loops;
	}


	public void run() {
		int i =0;
		while(i<loops) {
		tm.producirNumero();
		i++;
//		tm.mostrar();
		}
	}

}
