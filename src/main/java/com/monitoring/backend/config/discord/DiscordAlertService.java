package com.monitoring.backend.config.discord;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiscordAlertService {

	private final HttpClient httpClient;
	private final ObjectMapper objectMapper;

	@Value("${discord.webhook.url}")
	private String discordWebhookUrl;
	@Value("${discord.webhook.connect-timeout}")
	private int connectTimeout;


	//동기로 처리.
	public void sendErrorAlert(DiscordAlertMessage message) {
		try{
			HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(discordWebhookUrl))
				.header("Content-Type", "application/json")
				.timeout(Duration.ofSeconds(connectTimeout))
				.POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(message)))
				.build();

			//데이터 보내기
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		} catch (Exception e) {
			log.error("디스코드 알림 전송중 오류 발생", e);
		}
	}


}
