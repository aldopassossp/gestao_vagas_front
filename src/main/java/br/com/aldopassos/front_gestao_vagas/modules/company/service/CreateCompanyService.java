package br.com.aldopassos.front_gestao_vagas.modules.company.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.aldopassos.front_gestao_vagas.modules.company.dto.CreateCompanyDTO;

@Service
public class CreateCompanyService {

    @Value("${host.api.gestaao.vagas}")
    private String hostApiGestaoVagas;
    
    public String execute(CreateCompanyDTO createCompanyDTO){
        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreateCompanyDTO> request = new HttpEntity<>(createCompanyDTO, headers);

        String url = hostApiGestaoVagas.concat("/company");
        return rt.postForObject(url, request, String.class);
    }
}
