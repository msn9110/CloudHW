package com.mkyong.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGet {

	public static void main(String[] args) {
		try {

			Client client = Client.create();
			String url1 = "http://localhost:8080/RESTfulExample/rest/json/metallica/get";
			String apikey = "CWB-F4E67147-4625-4C0A-85F7-DB42AF404A38";
			String data_id = "F-C0032-001";
			String url2 = "http://opendata.cwb.gov.tw/opendataapi?dataid=" + data_id + "&authorizationkey="
					+ apikey;
			WebResource webResource = client
					.resource(url2);

			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}