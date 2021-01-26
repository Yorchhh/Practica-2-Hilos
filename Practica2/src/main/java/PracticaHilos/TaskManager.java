package PracticaHilos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*Para qe se pueda cerrar el programa tenemos que recorrer los hilos con for each esablecer el mentodo join*/
public class TaskManager {
	ArrayList<Integer> numeros = new ArrayList<Integer>(10);

	public TaskManager(ArrayList<Integer> numeros) {
		super();
		this.numeros = numeros;
	}

	public synchronized boolean producirNumero() {
		if (numeros.size() == 10) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		int numero = ThreadLocalRandom.current().nextInt(0, 11);
		numeros.add(numero);
		System.out.println("Productor[" + Thread.currentThread().getId() + "] produce el numero-->" + numero);
		notifyAll();
		return true;

	}

	public synchronized boolean consumirNumero() {

		if (numeros.size() > 0) {// Esta la lista vacia? Podra quitar un numero
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			int numero = numeros.get(numeros.size() - 1);
			int dato=numeros.remove(numeros.size()-1);

			System.out.println("Consumidor[" + Thread.currentThread().getId() + "] consume el numero--> " + dato);

			notifyAll();
			return true;

		}

		return false;

	}

	public void mostrar() {
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(numeros.get(i));

		}
	}

}
