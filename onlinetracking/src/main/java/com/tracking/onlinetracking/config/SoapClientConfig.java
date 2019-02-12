package com.tracking.onlinetracking.config;

import com.tracking.onlinetracking.soapclient.PackageClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Created by Robi on 1/12/2019.
 */
@Configuration
public class SoapClientConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the  specified in
        // pom.xml
        marshaller.setContextPath("packages.wsdl");
        return marshaller;
    }

    @Bean
    public PackageClient packageClient(Jaxb2Marshaller marshaller) {
        PackageClient client = new PackageClient();
        client.setDefaultUri("http://localhost:8091/PackageTrackingAdmin/packages");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
