package com.jking31cs.jerseyexample.webservices;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jking31cs.jerseyexample.objects.User;
import com.jking31cs.jerseyexample.stores.UserStore;


@Path("api/users")
public class UserWebService {

	private final UserStore userStore;

    @Inject
    public UserWebService(UserStore userStore) {
		this.userStore = userStore;
    }

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userStore.getAll();
    }
	
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") Long id) {
        return userStore.get(id);
    }
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User saveUser(User user) {
        return userStore.save(user);
    }
	
	@PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@PathParam("id") Long id, User user) {
        return userStore.save(user);
    }
	
	@DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteUser(@PathParam("id") Long id, User user) {
        return userStore.delete(user);
    }

}
