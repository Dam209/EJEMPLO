/**
 * @Clase: Ejemplo.java
 * 
 * @version  1.0
 * 
 * @since 25/08/2020
 * 
 * @autor Ing. Jhon Mendez
 *
 * @Copyrigth: Legal Credit Solution
 */

package edu.cecar.ejemplo;

import java.io.IOException;

import us.monoid.json.JSONObject;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

/**
 *  Clase que ejemplifica el uso de buenas practicas de desarrollo de software
 *  
 */

public class Ejemplo {

	private JSONResource jsonResource;

	public Ejemplo(String url) {
		
		try {
			
			jsonResource = new Resty().json(url);
		
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}
	
	
	public String getCambioDolar() {

		String resultado = "";
		
		try {

			JSONObject jsonRoot = jsonResource.object();

			JSONObject jsonUSDCOL = jsonRoot.getJSONObject("USDCOL");

			resultado = jsonUSDCOL.get("setfxsell").toString();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return resultado;

	}
	
	public String getCambioDolarVenta() {

		String resultado = "";
		
		try {

			JSONObject jsonRoot = jsonResource.object();

			JSONObject jsonUSDCOL = jsonRoot.getJSONObject("USDCOL");

			resultado = jsonUSDCOL.get("setfxbuy").toString();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return resultado;

	}

	

	public static void main(String[] args) {

		Ejemplo ejemplo = new Ejemplo("https://s3.amazonaws.com/dolartoday/data.json");
		System.out.println(ejemplo.getCambioDolar());
		System.out.println(ejemplo.getCambioDolarVenta());
		

	}


}
