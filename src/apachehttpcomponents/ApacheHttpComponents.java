package apachehttpcomponents;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ApacheHttpComponents {

	public static JsonObject extraerTodos() {
		
	String URL_SERVICIO = "http://localhost:7001/manejojpaejbrest/api/personas/all";
	HttpClient httpClient = null;
	JsonObject jsonObject = new JsonObject();
	String sbString = null;
	
	try {
		
		httpClient = HttpClientBuilder.create().build();
		HttpGet httpRequest = new HttpGet(URL_SERVICIO);
		HttpResponse httpResponse = httpClient.execute(httpRequest);
		
		if(httpResponse.getStatusLine().getStatusCode() != 200){
			throw new Exception("Ocurrio un error, estatus : " + httpResponse.getStatusLine().getStatusCode());
		}
		
		BufferedReader br = null; 
		
		try {
			
			br = new BufferedReader(new InputStreamReader((httpResponse.getEntity().getContent())));
			StringBuffer sb = new StringBuffer();
			String output = "";
			
			 while ((output = br.readLine()) != null) {
				sb.append(output);
			}
			 
			 sbString = sb.toString();
			 jsonObject.addProperty("Response :", sbString);
			 
			
		} catch(Exception Ex) {
			Ex.printStackTrace();	
		} finally {
			br.close();
		}
		
	} catch (Exception E) {
		E.printStackTrace();
	} finally {
		HttpClientUtils.closeQuietly(httpClient);
	}
	return jsonObject;
  }
	
	public static JSONObject getStatus() {
		
	String URL_SERVICIO = "http://localhost:7001/manejojpaejbrest/api/personas/timenow";
	HttpClient httpClient = null;
	JSONObject jsonObject2 = new JSONObject();
	String sbString = null;
	
	try {
		
		httpClient = HttpClientBuilder.create().build();
		HttpGet httpRequest = new HttpGet(URL_SERVICIO);
		HttpResponse httpResponse = httpClient.execute(httpRequest);
		
		if(httpResponse.getStatusLine().getStatusCode() != 200){
			throw new Exception("Ocurrio un error, estatus : " + httpResponse.getStatusLine().getStatusCode());
		}
		
		BufferedReader br = null; 
		
		try {
			
			br = new BufferedReader(new InputStreamReader((httpResponse.getEntity().getContent())));
			StringBuffer sb = new StringBuffer();
			String output = "";
			
			 while ((output = br.readLine()) != null) {
				sb.append(output);
			}
			 
			 sbString = sb.toString();
			 jsonObject2.put("OutPut :", sbString);
			 
			
		} catch(Exception Ex) {
			Ex.printStackTrace();	
		} finally {
			br.close();
		}
		
	} catch (Exception E) {
		E.printStackTrace();
	} finally {
		HttpClientUtils.closeQuietly(httpClient);
	}
	return jsonObject2;
  }
	
	public static String getMax() {
		
		String URL_SERVICIO = "http://localhost:7001/manejojpaejbrest/api/personas/maximo";
		HttpClient httpClient = null;
		String sbString = null;
		String sbString2 = null;
		String sbString3 = null;
		Gson json = new Gson();
		
		try {
			
			httpClient = HttpClientBuilder.create().build();
			HttpGet httpRequest = new HttpGet(URL_SERVICIO);
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			
			if(httpResponse.getStatusLine().getStatusCode() != 200){
				throw new Exception("Ocurrio un error, estatus : " + httpResponse.getStatusLine().getStatusCode());
			}
			
			BufferedReader br = null; 
			
			try {
				
				br = new BufferedReader(new InputStreamReader((httpResponse.getEntity().getContent())));
				StringBuffer sb = new StringBuffer();
				String output = "";
				
				 while ((output = br.readLine()) != null) {
					sb.append(output);
				}
				 
				 sbString = sb.toString();
				 
				 sbString2 = json.toJson(sbString);
				 
				 sbString3 = json.fromJson(sbString2, String.class);
				
			} catch(Exception Ex) {
				Ex.printStackTrace();	
			} finally {
				br.close();
			}
			
		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
		}
		return sbString3;
	  }

	public static String insertar(String per) {
		
		String URL_SERVICIO = "http://localhost:7001/manejojpaejbrest/api/personas/persona";
		HttpClient httpClient = null;
		String sbString = null;
		
		try {
			
			httpClient = HttpClientBuilder.create().build();
			
			HttpPost httpRequest = new HttpPost(URL_SERVICIO);
			// httpRequest.addHeader("Content-type", "application/json"); 
			
			HttpEntity entity = new StringEntity(per, ContentType.APPLICATION_JSON);
			httpRequest.setEntity(entity);
			
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			
			if(httpResponse.getStatusLine().getStatusCode() != 200){
				throw new Exception("Ocurrio un error, estatus : " + httpResponse.getStatusLine().getStatusCode());
			}
			
			BufferedReader br = null; 
			
			try {
				
				br = new BufferedReader(new InputStreamReader((httpResponse.getEntity().getContent())));
				StringBuffer sb = new StringBuffer();
				String output = "";
				
				 while ((output = br.readLine()) != null) {
					sb.append(output);
				}
				 
				 sbString = sb.toString();
				
			} catch(Exception Ex) {
				Ex.printStackTrace();	
			} finally {
				br.close();
			}
			
		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
		}
		return sbString;
	  }

	public static String modificar(String per) {
		
		String URL_SERVICIO = "http://localhost:7001/manejojpaejbrest/api/personas/persona";
		HttpClient httpClient = null;
		String sbString = null;
		
		try {
			
			httpClient = HttpClientBuilder.create().build();
			
			HttpPut httpRequest = new HttpPut(URL_SERVICIO);
			// httpRequest.addHeader("Content-type", "application/json"); 
			
			HttpEntity entity = new StringEntity(per, ContentType.APPLICATION_JSON);
			httpRequest.setEntity(entity);
			
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			
			if(httpResponse.getStatusLine().getStatusCode() != 200){
				throw new Exception("Ocurrio un error, estatus : " + httpResponse.getStatusLine().getStatusCode());
			}
			
			BufferedReader br = null; 
			
			try {
				
				br = new BufferedReader(new InputStreamReader((httpResponse.getEntity().getContent())));
				StringBuffer sb = new StringBuffer();
				String output = "";
				
				 while ((output = br.readLine()) != null) {
					sb.append(output);
				}
				 
				 sbString = sb.toString();
				
			} catch(Exception Ex) {
				Ex.printStackTrace();	
			} finally {
				br.close();
			}
			
		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
		}
		return sbString;
	  }

}