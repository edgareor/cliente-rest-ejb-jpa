package main;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import apachehttpcomponents.ApacheHttpComponents;
import entity.Persona;
import jerseyclient.ClassJerseyClient;

public class ClaseMain {

	public static void main(String[] args) {
		
		/**********   HTTP COMPONENTS   **********/
		/*
		JsonObject out = ApacheHttpComponents.extraerTodos();
		System.out.println(out);
		System.out.println();
		
		JSONObject out2 = ApacheHttpComponents.getStatus();
		System.out.println(out2);
		System.out.println();
		
		String out3 = ApacheHttpComponents.getMax();
		System.out.println(out3);
		System.out.println();
		
		Persona per = new Persona(11);
		per.setNombrePersona("David");
		per.setApellidoPersona("Jimenez");
		//per.setRutPersona("Prueba2");

		Gson json = new Gson();		
		String out4 = json.toJson(per);
		*/
		/*
		String out5 = ApacheHttpComponents.insertar(out4);
		System.out.println(out5);
		*/
		/*
		String out6 = ApacheHttpComponents.modificar(out4);
		System.out.println(out6);
		*/
		
		/**********   JERSEY CLIENT   **********/
		
		String out1 = ClassJerseyClient.extraerAll();
		System.out.println(out1);
		System.out.println();
		
		String out2 = ClassJerseyClient.getStatus();
		System.out.println(out2);
		System.out.println();
		
		String out3 = ClassJerseyClient.maximo();
		System.out.println(out3);
		System.out.println();
		
		Persona per = new Persona(16);
		per.setNombrePersona("Maryuri");
		per.setApellidoPersona("Lugo");
		//per.setRutPersona("Prueba2");
		
		Gson json = new Gson();
		String cast = json.toJson(per);
		
		/*
		Response out4 = ClassJerseyClient.ingresar(cast);
		System.out.println(out4);
		*/
		
		Response out5 = ClassJerseyClient.modificar(cast);
		System.out.println(out5);
	}
}
