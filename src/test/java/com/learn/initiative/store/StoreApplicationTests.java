package com.learn.initiative.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class StoreApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnHealthCheckInfo() {
        var actualPong = restTemplate.getForObject("/v1/ping", String.class);
        assertThat(actualPong).isNotBlank();
    }

}
