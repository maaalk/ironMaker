package br.com.direfrog.persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {
	  public static void main(String[] args) {
		    EntityManagerFactory factory = Persistence.
		          createEntityManagerFactory("ironMaker");

		    factory.close();
		  }

}
