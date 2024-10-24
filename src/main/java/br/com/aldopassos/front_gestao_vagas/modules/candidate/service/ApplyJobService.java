package br.com.aldopassos.front_gestao_vagas.modules.candidate.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApplyJobService {

    @Value("${host.api.gestaao.vagas}")
    private String hostApiGestaoVagas;

    public String execute(String token, UUID idJob){

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<UUID> request = new HttpEntity<>(idJob, headers);

        String url = hostApiGestaoVagas.concat("/candidate/auth");
        var result = rt.postForObject(url, request, String.class);
        
        return result;
    }
}
