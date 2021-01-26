package PracticaHilos;

public class Consumidor implements Runnable {
	private TaskManager tm;
	private int loops = 10;

	public Consumidor(TaskManager tm, int loops) {
		this.tm = tm;
		this.loops = loops;
	}

	public void run() {
		int i = 0;
		while (i < loops) {
			 if (tm.consumirNumero()) {
				i++;
			} 
//			 tm.mostrar();
		}
	}

}
