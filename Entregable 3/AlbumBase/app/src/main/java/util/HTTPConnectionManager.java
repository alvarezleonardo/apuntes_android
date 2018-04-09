package util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;

public class HTTPConnectionManager {

	public String getRequestString(String url) throws DAOException{
		String result = null;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setReadTimeout(10000);  //In milliseconds.
            connection.setRequestMethod("GET");
			InputStream instream = connection.getInputStream();
			result = convertStreamToString(instream);             
		}catch (SocketTimeoutException e) {
			e.printStackTrace();
			throw new DAOException("Connection timeout. Please try again later.");
		} catch (UnknownHostException e) {
			throw new DAOException("There is no internet connection");
		} catch (IOException e) {
			throw new DAOException("Connection Problem");
		}
		return result;
	}
	
	public InputStream getRequestStream(String url) throws DAOException{
		InputStream result = null;
	    try {
	    	HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	    	connection.setReadTimeout(10000);
            connection.setRequestMethod("GET");
	    	InputStream instream =  connection.getInputStream();
			result = instream;
	    }catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
        	e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	    return result;
	}
	
	private String convertStreamToString(InputStream is) {
	
		byte[] bytes = new byte[1000];

		StringBuilder x = new StringBuilder();

		int numRead = 0;
		try {
			while ((numRead = is.read(bytes)) >= 0) {
				x.append(new String(bytes, 0,numRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		return x.toString();
	}

	public static boolean isNetworkingOnline(Context context){
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeConnection = cm.getActiveNetworkInfo();
		Boolean isOnline = (activeConnection != null) && activeConnection.isConnected();
		return isOnline;
	}
	
}























