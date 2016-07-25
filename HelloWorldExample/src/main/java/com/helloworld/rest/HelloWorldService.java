package com.helloworld.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class HelloWorldService {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }

    @GET
    @Path("/query")
    public Response getQuery(@Context UriInfo info) {

        String name = info.getQueryParameters().getFirst("name");

        String output = "<h1>Hello " + (name == null ? "Jersey" : name) + "</h1>";

        return Response.status(200).entity(output).build();

    }

}