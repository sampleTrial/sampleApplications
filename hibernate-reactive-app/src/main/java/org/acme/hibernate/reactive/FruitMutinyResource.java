package org.acme.hibernate.reactive;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import org.jboss.logging.Logger;


@Path("fruits")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class FruitMutinyResource {
     private static final Logger LOGGER = Logger.getLogger(FruitMutinyResource.class);


    @GET
    @Path("/greet")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOGGER.info("Logger implemented here in FruitMutinyResource");
        return "Hello!! You are inside FruitMutinyResource";
    }

    @GET
    @Path("/giveFruitNameLog")
    @Produces(MediaType.TEXT_PLAIN)
    public String addValues() {
        
        String fruitName = "Guava";
        
        System.out.println("****"+fruitName++"*****");
        LOGGER.info("Logger implemented here with fruit name" +" "+fruitName);
        return fruitName+" and logger Implemented";
    }
  
}
