package com.monitoring.backend.config.discord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscordAlertEmbedMessage {

	private String title;
	private String description;


	public static DiscordAlertEmbedMessage of(String title, String description) {
		return DiscordAlertEmbedMessage.builder()
				.title(title)
				.description(description)
				.build();
	}
}
