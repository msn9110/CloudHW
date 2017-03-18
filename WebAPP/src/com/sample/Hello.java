package com.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/games")
public class Hello {
    // This method is called if TEXT_PLAIN is request
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello Jersey";
    }

    // This method is called if XML is request
    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "" + " Hello Jersey" + "";
    }

    // This method is called if HTML is request
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html> " + "<title>" + "Hello Jersey" + "</title>"
              + "<body><h1>" 
              + "Hello Jersey"
              + "</h1></body></html></pre>" 
              + " ";
    }
    
 // This method is called if HTML is request
    @GET
    @Path("/{arg}")
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello2(@PathParam(value="arg") String para) {
        return "<html> " + "<title>" + "Hello " + para + "</title>"
              + "<body><h1>" 
              + "Hello " + para
              + "</h1><br><p id=\"result\" />\n<script>\n"
              + "document.getElementById(\"result\").innerHTML = '" 
              + para + "';\n"
              + "\n</script>\n</body></html>" 
              + " ";
    }
    
    @Path("/{getparameter}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByPathParameterAndQueryPath(
      @PathParam(value="getparameter") String getparameter,
      @QueryParam(value="q") String q) throws JSONException {
      System.out.println(getparameter);
      System.out.println(q);
      JSONObject json = new JSONObject();
      json.put("pathParameter", getparameter);
      json.put("q", q);
      return json.toString();
    }
}