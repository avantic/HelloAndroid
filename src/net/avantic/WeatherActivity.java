package net.avantic;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);
		
		InputStream weather = checkWeather();
		WeatherParser weatherParser = new WeatherParser(weather);
		
		TextView conditionsText = (TextView) findViewById(R.id.conditionsText);
		conditionsText.setText(weatherParser.getConditions());
		TextView temperatureText = (TextView) findViewById(R.id.temperatureText);
		temperatureText.setText(weatherParser.getTemperature() + "ºC");
		TextView humidityText = (TextView) findViewById(R.id.humidityText);
		humidityText.setText(weatherParser.getHumidity());
	}
	
	private InputStream checkWeather() {
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet("http://www.google.com/ig/api?weather=Santa+Cruz+De+Tenerife");
			HttpResponse response = client.execute(request);
			return response.getEntity().getContent();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private class WeatherParser {
		
		Document document;
		
		public WeatherParser(InputStream input) {
			try {
				DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				document = documentBuilder.parse(input);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		}

		public String getConditions() {
			return getDataFrom("condition");
		}
		
		public String getTemperature() {
			return getDataFrom("temp_c");
		}
		
		public String getHumidity() {
			return getDataFrom("humidity");
		}
		
		private String getDataFrom(String labelName) {
			NodeList conditions = document.getElementsByTagName(labelName);
			return conditions.item(0).getAttributes().getNamedItem("data").getTextContent();
		}
		
	}
	
}
