package webservices;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.*;

@Path("/countries")
public class WorldResource {
	private WorldService service = ServiceProvider.getWorldService();

	@GET
	@Produces("application/json")

	public String getCountries() {
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

		List<Country> countries = service.getAllCountries();
		for (Country c : countries) {
			JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
			jsonObjectBuilder.add("Code", c.getCode());
			jsonObjectBuilder.add("Iso3", c.getIso3());
			jsonObjectBuilder.add("Name", c.getName());
			jsonObjectBuilder.add("Capital", c.getCapital());
			jsonObjectBuilder.add("Continent", c.getContinent());
			jsonObjectBuilder.add("Region", c.getRegion());
			jsonObjectBuilder.add("Surface", c.getSurface());
			jsonObjectBuilder.add("Population", c.getPopulation());
			jsonObjectBuilder.add("Government", c.getGovernment());
			jsonObjectBuilder.add("Latitude", c.getLatitude());
			jsonObjectBuilder.add("Longitude", c.getLongitude());
			jsonArrayBuilder.add(jsonObjectBuilder);
		}
		return jsonArrayBuilder.build().toString();

	}

	@GET
	@Path("/{code}")
	public String getCountrieByCode(@PathParam("code") String countrieCode) {
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

		List<Country> countries = service.getAllCountries();
		for (Country c : countries) {
			if(c.getCode().equals(countrieCode)) {
				JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
				jsonObjectBuilder.add("Code", c.getCode());
				jsonObjectBuilder.add("Iso3", c.getIso3());
				jsonObjectBuilder.add("Name", c.getName());
				jsonObjectBuilder.add("Capital", c.getCapital());
				jsonObjectBuilder.add("Continent", c.getContinent());
				jsonObjectBuilder.add("Region", c.getRegion());
				jsonObjectBuilder.add("Surface", c.getSurface());
				jsonObjectBuilder.add("Population", c.getPopulation());
				jsonObjectBuilder.add("Government", c.getGovernment());
				jsonObjectBuilder.add("Latitude", c.getLatitude());
				jsonObjectBuilder.add("Longitude", c.getLongitude());

				jsonArrayBuilder.add(jsonObjectBuilder);
			}
		}
		return jsonArrayBuilder.build().toString();
	}
	@GET
	@Path("/largestsurfaces")
	public String getLargestsurfaces() {
		return getList(service.get10LargestSurfaces());
	}
	
	@GET
	@Path("/largestpopulations")
	public String getLargestpopulation() {
		return getList(service.get10LargestSurfaces());
	}
	
	public String getList(List<Country> list) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
//		System.out.println("komt hierin");
		for (Country c : list) {
			jab.add(getCountrie(c));
		}
		
		JsonArray array = jab.build();
		
		return array.toString();
	}

	private String getCountrie(Country c) {
		JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
		jsonObjectBuilder.add("Code", c.getCode());
		jsonObjectBuilder.add("Iso3", c.getIso3());
		jsonObjectBuilder.add("Name", c.getName());
		jsonObjectBuilder.add("Capital", c.getCapital());
		jsonObjectBuilder.add("Continent", c.getContinent());
		jsonObjectBuilder.add("Region", c.getRegion());
		jsonObjectBuilder.add("Surface", c.getSurface());
		jsonObjectBuilder.add("Population", c.getPopulation());
		jsonObjectBuilder.add("Government", c.getGovernment());
		jsonObjectBuilder.add("Latitude", c.getLatitude());
		jsonObjectBuilder.add("Longitude", c.getLongitude());
		
		return jsonObjectBuilder.build().toString();
	}
}