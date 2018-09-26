package itterrinoni.soapclienttrain;

import hello.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SoapClientTrainApplication {

  public static void main(String[] args) {
    SpringApplication.run(SoapClientTrainApplication.class, args);
  }

  @Bean
  CommandLineRunner lookup(CountryClient quoteClient) {
    return args -> {
      String country = "Spain";

      if(args.length > 0) {
        country = args[0];
      }

      GetCountryResponse response = quoteClient.getCountry(country);
      System.out.println(response.getCountry().getName() + " " +response.getCountry().getCurrency());
    };
  }
}
