package com.Zakaria.rest.webservices.restfulwebservices.helloworld;


import com.Zakaria.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
//specify to Spring that is a Rest Controller that will handle Rest request !
@RestController
public class HelloWorldController {



    //Tell to Spring that we want to mapp a http method/verbs to an URI
    // we need the @requestMapping anotation and below it, use a specific method for that

    // 2 ways
    //@RequestMapping( method= RequestMethod.GET,path="/hello-world")
    // => it's the general way
    //OR
    //@GetMapping( path="/hello-world")
    // => more specific way
    @GetMapping( path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping( path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){

        //throw new RuntimeException(" Some Error Happened ! ");
        return new HelloWorldBean("Hello world bean from the Service created by Zak");
    }

    @GetMapping( path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean( String.format("Hello world %s", name));
    }

}
