package com.monitoring.backend.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.monitoring.backend.config.discord.DiscordAlertEmbedMessage;
import com.monitoring.backend.config.discord.DiscordAlertMessage;
import com.monitoring.backend.config.discord.DiscordAlertService;
import com.monitoring.backend.config.response.CommonResponse;
import com.monitoring.backend.config.response.CustomStatus;
import com.monitoring.backend.config.response.ResponseService;
import com.monitoring.backend.config.response.exception.CustomException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//TODO: 추후에 알림 서비스(슬랙, 디코등)를 연동해서 에러 메시지를 보내도록 해야 함.
@Slf4j
@Getter
@RequiredArgsConstructor
@RestControllerAdvice
public class ControllerAdvisor {

	private final ResponseService responseService;
	private final DiscordAlertService discordAlertService;

	/**
	 * 커스텀 예외들
	 */
	@ExceptionHandler(CustomException.class)
	public CommonResponse exceptionHandler(CustomException e) {

		CustomStatus status = e.getCustomExceptionStatus();

		log.warn("[ CustomException - {}] : {}",
			LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")),
			status.getMessage()
		);

		return responseService.getExceptionResponse(status);
	}

	/**
	 * 커스텀 예외로 잡히지 않은 에러들
	 */
	@ExceptionHandler(Exception.class)
	public CommonResponse exceptionHandler(Exception e, HttpServletRequest request) {

		String errorFormat = String.format("[ Exception - %s] : %s",
			LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")),
			e.getMessage());

		log.error(errorFormat);

		//TODO : 추후에 다른 웹훅 로직이 들어가게 되면 종류별로 별도의 클래스로 빼야 함.
		/*디스코드 처리*/
		//커스텀 예외가 아닌 케이스들에 대해 알림.
		List<DiscordAlertEmbedMessage> embeds = new ArrayList<>();
		embeds.add(
			DiscordAlertEmbedMessage.of(
				"""
					ℹ️에러 정보
					""",
				String.format("""
						### ⏰ 발생시간\n
						=> %s \n
						### 🧑‍💻요청 URL\n
						=> %s \n
						### 📋에러 내용\n
						``` \n
						%s
						```
						""",
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")),
					request.getRequestURI(),
					e.getMessage()
				)
			)
		);


		//디스코드로 알림 보내기.
		discordAlertService.sendErrorAlert(
			DiscordAlertMessage.of(embeds)
		);

		//에러의 경우에는 따로 메시지를 응답으로 주지 않음.
		return responseService.getErrorResponse(e);
	}
}
