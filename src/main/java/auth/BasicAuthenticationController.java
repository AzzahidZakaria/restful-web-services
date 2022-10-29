package auth;


import org.springframework.web.bind.annotation.*;

//ce service permettra d'envoyer des choses à ntore login page

@CrossOrigin(origins = "*", allowedHeaders = "*")
//specify to Spring that is a Rest Controller that will handle Rest request !
@RestController
public class BasicAuthenticationController {


    @GetMapping( path="/basicauth")
    public AuthenticationBean helloWorldBean(){

        //throw new RuntimeException(" Some Error Happened ! ");
        return new AuthenticationBean("You are authenticated");
    }



}
