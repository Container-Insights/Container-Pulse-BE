package com.monitoring.backend.config;

import java.net.http.HttpClient;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfig {

	@Value("${http.client.connect-timeout}")
	private int connectTimeout;


	@Bean
	public HttpClient httpClient() {
		return HttpClient.newBuilder()
			.connectTimeout(Duration.ofSeconds(connectTimeout))
			.version(HttpClient.Version.HTTP_1_1)
			.followRedirects(HttpClient.Redirect.NORMAL)
			.build();
	}
}
