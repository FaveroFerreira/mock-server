package org.faveroferreira.mockserver.controller;

import org.faveroferreira.mockserver.util.PotentialFailure;
import org.faveroferreira.mockserver.util.failure.SucceedXTimesFailYTimesAndThenSucceed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/via-cep")
public class ViaCepProxyController {

    PotentialFailure potentialFailure = new SucceedXTimesFailYTimesAndThenSucceed(12, 8);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{cep}")
    public Map<String, Object> viaCepMock(@PathVariable String cep) {
        potentialFailure.occur();
        return restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json/", Map.class);
    }

}
