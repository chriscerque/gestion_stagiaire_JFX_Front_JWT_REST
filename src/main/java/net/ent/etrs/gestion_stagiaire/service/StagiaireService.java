package net.ent.etrs.gestion_stagiaire.service;


import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class StagiaireService implements IStagiaireService {


    private static final String url = "http://127.0.0.1:8080/Stagiaires";

    public List<Stagiaire> getAllStagiaires() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + JwtTokenUtil.getToken());
        RequestEntity<List<Stagiaire>> reqEntity = new RequestEntity<List<Stagiaire>>(new ArrayList<Stagiaire>(), headers, HttpMethod.GET, URI.create(url));
//        (headers, HttpMethod.GET, url);
        ParameterizedTypeReference<List<Stagiaire>> typeRef = new ParameterizedTypeReference<>() {
        };


        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setMessageConverters(messageConverters);
        ResponseEntity<List<Stagiaire>> resEntity = restTemplate.exchange(reqEntity, typeRef);

        System.out.println(resEntity.getStatusCodeValue());
        for (Stagiaire b : resEntity.getBody()) {
            System.out.println(b);
        }

        return resEntity.getBody();
    }


}
