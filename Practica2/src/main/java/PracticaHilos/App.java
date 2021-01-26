package PracticaHilos;

import java.util.ArrayList;

import com.sun.tools.javac.util.List;

public class App {

	public static void main(String[] args) {
		TaskManager tm = new TaskManager(new ArrayList<Integer>(10));
		Productor productor = new Productor(tm, 1);
		Consumidor consumidor = new Consumidor(tm, 1);
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(productor));
		}

		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(consumidor));
		}

		for (Thread t : threads) {
			t.start();

		}
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println("NO SE HAN FINALIZADO LOS HILOS");
				e.printStackTrace();
			}
		}

	}

}
