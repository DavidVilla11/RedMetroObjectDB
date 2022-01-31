package es.redmetro.dam2.procesos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConvertirUrlAImagen {

	public static byte[] getBytesFromURL(String textoURL) {
		byte[] bytesImagen = null;
		URL url = null;
		try {
			url = new URL(textoURL);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.addRequestProperty("User-Agent", "Mozilla");
			InputStream inputStream = urlConnection.getInputStream();
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			inputStream.close();
			bytesImagen = outStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytesImagen;
	}

}
