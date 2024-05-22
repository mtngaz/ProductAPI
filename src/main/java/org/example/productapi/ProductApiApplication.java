/**
 * The main class for the Product API application.
 */
package org.example.productapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Product API application.
 */
@SpringBootApplication
public class ProductApiApplication {

    /**
     * The main method to start the Product API application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }

}
