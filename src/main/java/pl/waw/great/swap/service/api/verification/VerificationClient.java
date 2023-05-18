package pl.waw.great.swap.service.api.verification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Component
public class VerificationClient {

    private final RestTemplate restTemplate;
    private final String verificationApi;

    public VerificationClient(RestTemplate restTemplate, @Value("${api.verification}") String verificationApi) {
        this.restTemplate = restTemplate;
        this.verificationApi = verificationApi;
    }

    public VerificationResponse postVerification(String ean, ActionType actionType) {
        HttpEntity<HashMap<String, Object>> httpEntity = new HttpEntity<>(new HashMap<>());
        ResponseEntity<VerificationResponse> response = restTemplate.postForEntity(verificationApi + "/verify/" + ean + "/" + actionType, httpEntity, VerificationResponse.class);
        return response.getBody();
    }
}
