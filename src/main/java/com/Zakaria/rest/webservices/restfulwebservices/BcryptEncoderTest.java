package com.Zakaria.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {


    public static void main(String[] args) {


        // classe qui permet de créer des codes
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


        for (int i = 1; i<= 10; i++) {

                // on stock dans une variable encodedString, le résultat de la méthode .encode(), qui permet de générer des codes HASHER
          String  encodedString = encoder.encode("Riyad");
            System.out.println(encodedString);

        }




    }
}
