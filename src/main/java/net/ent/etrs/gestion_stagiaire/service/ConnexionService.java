package net.ent.etrs.gestion_stagiaire.service;

import net.ent.etrs.gestion_stagiaire.model.JwtRequest;
import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class ConnexionService implements IConnexionService {

    private static final String URL_LOGIN = "http://localhost:8080/authenticate";

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public MyUser connexion(final String login, final String password) {
        // Request Header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // Request Body
//        MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
//        parametersMap.add("username", this.tfLogin.getText());
//        parametersMap.add("password", this.tfPwd.getText());
//
//        System.out.println("parametersMap : " + parametersMap);
//
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("username", this.tfLogin.getText());
//            jsonObject.put("password", this.tfPwd.getText());
//        } catch (JSONException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }


        ParameterizedTypeReference<JwtRequest> parametersMap = new ParameterizedTypeReference<JwtRequest>() {
        };

        JwtRequest jwtRequest = new JwtRequest(login, password);


        // Request Entity
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parametersMap, headers);
//        RequestEntity<MultiValueMap<String, String>> requestEntity = new RequestEntity<>(parametersMap,headers, HttpMethod.POST, URI.create(URL_LOGIN));
        RequestEntity<JwtRequest> requestEntity = RequestEntity.post(URI.create(URL_LOGIN))
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers)
                .body(jwtRequest);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//        messageConverters.add(converter);

//        restTemplate.setMessageConverters(messageConverters);

//         MyRequest body = null;
//  RequestEntity<MyRequest> request = RequestEntity
//                     .post("https://example.com/{foo}")
//      .accept(MediaType.APPLICATION_JSON)
//                     .body(body);
//  ResponseEntity&lt;MyResponse&gt; response = template.exchange(request, MyResponse.class);
//


        // POST Login
//        ResponseEntity<String> response = restTemplate.exchange(URL_LOGIN,
//                HttpMethod.POST, requestEntity, String.class);
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);


        HttpHeaders responseHeaders = response.getHeaders();

        List<String> list = responseHeaders.get("Authorization");
//        return list == null || list.isEmpty() ? null : list.get(0);
        String token = list.get(0);
        System.out.println("Authorization String=" + token);


//        jwtTokenUtil.getUsernameFromToken(authorizationString);
        System.out.println(jwtTokenUtil.getAllClaimsFromToken(token));

        MyUser myUser = new MyUser();
        myUser.setUsername(jwtTokenUtil.getUsernameFromToken(token));
        myUser.setToken(token);
        return myUser;
    }

}
