package com.monitoring.backend.config.discord;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscordAlertMessage {

	private String content;
	private boolean tts; //true 면 디코에서 알림내용 읽어줌.
	private List<DiscordAlertEmbedMessage> embeds;

	public static DiscordAlertMessage of(List<DiscordAlertEmbedMessage> embeds) {
		return DiscordAlertMessage.builder()
			.content(
				"""
				🚨API 에러 발생 🚨
				""")
			.tts(false)
			.embeds(embeds)
			.build();

	}
}
