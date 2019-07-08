package jerseyclient;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

public class ClassJerseyClient {
	
	private static final String URL_BASE = "http://localhost:7001/manejojpaejbrest/api/personas";
	private static JerseyClient cliente;
	private static WebTarget webtarget ;
	private static Invocation.Builder invbuilder;

	public static String extraerAll() {
	
		cliente = JerseyClientBuilder.createClient();
		webtarget = cliente.target(URL_BASE).path("/all");
		String out = webtarget.request(MediaType.APPLICATION_JSON).get(String.class);
		return out;
	}
	
	public static String getStatus() {
		
		cliente = JerseyClientBuilder.createClient();
		webtarget = cliente.target(URL_BASE).path("/timenow");
		String out = webtarget.request(MediaType.APPLICATION_JSON).get(String.class);
		return out;
	}
	
	public static String maximo() {
		
		cliente = JerseyClientBuilder.createClient();
		webtarget = cliente.target(URL_BASE).path("/maximo");
		String out = webtarget.request(MediaType.APPLICATION_JSON).get(String.class);
		return out;
	}
	
	public static Response ingresar(String persona){
		
		cliente = JerseyClientBuilder.createClient();
		webtarget = cliente.target(URL_BASE).path("/persona");
		invbuilder = webtarget.request(MediaType.APPLICATION_JSON);
		Response resp = invbuilder.post(Entity.entity(persona, MediaType.APPLICATION_JSON));
		return resp;
	}
	
	public static Response modificar(String persona){
		
		cliente = JerseyClientBuilder.createClient();
		webtarget = cliente.target(URL_BASE).path("/persona");
		invbuilder = webtarget.request(MediaType.APPLICATION_JSON);
		Response resp = invbuilder.put(Entity.entity(persona, MediaType.APPLICATION_JSON));
		return resp;
	}

}
