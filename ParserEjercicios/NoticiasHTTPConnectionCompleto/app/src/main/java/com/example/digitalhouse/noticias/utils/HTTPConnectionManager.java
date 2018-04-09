package com.example.digitalhouse.noticias.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;

public class HTTPConnectionManager {


	public InputStream getRequestStream(String url) throws Exception{
		InputStream result = null;
	    try {
			//GENERA UNA CONEXION ENTRE MI APLICACION Y EL SERVIDOR WEB DE ESA URL
	    	HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

			//ESPERA MAXIMA
	    	connection.setReadTimeout(10000);

			//TIPO DE REQUEST
			connection.setRequestMethod("GET");

			//LEE EL CONTENIDO QUE DESCARGO
			result =  connection.getInputStream();

	    }catch (SocketTimeoutException e) {
			e.printStackTrace();
			throw new SocketTimeoutException("Connection timeout. Please try again later.");
		} catch (UnknownHostException e) {
			throw new UnknownHostException("There is no internet connection");
		} catch (IOException e) {
			throw new IOException("Connection Problem");
		}
	    return result;
	}
	
}
