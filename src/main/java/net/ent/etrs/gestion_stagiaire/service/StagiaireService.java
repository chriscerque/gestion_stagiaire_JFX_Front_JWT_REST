package net.ent.etrs.gestion_stagiaire.service;


import net.ent.etrs.gestion_stagiaire.controllerFx.AbstractController;
import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class StagiaireService implements IStagiaireService {


    private static final String url = "http://127.0.0.1:8081/api/stagiaires";

    public List<Stagiaire> getAllStagiaires() throws Exception {
        try {
            // Request Header
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + AbstractController.userEnCours.getToken());
            HttpEntity<List<Stagiaire>> reqEntity = new HttpEntity<List<Stagiaire>>(headers);
            ParameterizedTypeReference<List<Stagiaire>> typeRef = new ParameterizedTypeReference<List<Stagiaire>>() {
            };

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<Stagiaire>> resEntity = restTemplate.exchange(URI.create(url), HttpMethod.GET, reqEntity, typeRef);


            System.out.println(resEntity.getStatusCodeValue());
            for (Stagiaire b : resEntity.getBody()) {
                System.out.println(b);
            }

            return resEntity.getBody();
        } catch (RestClientException e) {
            throw new Exception(e.getMessage(), e);
        }

    }


}
