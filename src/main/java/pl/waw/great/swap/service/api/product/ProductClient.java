package pl.waw.great.swap.service.api.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

    private final RestTemplate restTemplate;
    private final String productApi;

    public ProductClient(RestTemplate restTemplate,  @Value("${api.product}") String productApi) {
        this.restTemplate = restTemplate;
        this.productApi = productApi;
    }

    public ProductResponse getProductApi(String ean) {
        ResponseEntity<ProductResponse> response = restTemplate.getForEntity(productApi + "/product/"+ean, ProductResponse.class);
        return response.getBody();
    }
}
