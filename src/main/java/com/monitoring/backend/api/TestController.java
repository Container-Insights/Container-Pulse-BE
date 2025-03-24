package com.monitoring.backend.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitoring.backend.config.response.CommonResponse;
import com.monitoring.backend.config.response.DataResponse;
import com.monitoring.backend.config.response.ResponseService;
import com.monitoring.backend.config.response.exception.CustomException;
import com.monitoring.backend.config.response.exception.CustomExceptionStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

	private final ResponseService responseService;

	@Getter
	@Setter
	@NoArgsConstructor
	static class TestDto{
		String test1;
		int test2;
		boolean test3;



		public TestDto(String test1, int test2, boolean test3){
			this.test1 = test1;
			this.test2 = test2;
			this.test3 = test3;
		}
	}


	@GetMapping("test1")
	public CommonResponse notContentTest(){

		return responseService.getSuccessResponse();

	}

	//단일 객체.
	@GetMapping("test2")
	public DataResponse<TestDto> contentTest(){

		TestDto testDto = new TestDto("hello", 1, false);

		return responseService.getDataResponse(testDto);

	}
	//객체 리스트.
	@GetMapping("test2-2")
	public DataResponse<List<TestDto>> contentTest2(){

		List<TestDto> testList = new ArrayList<>();

		TestDto testDto1 = new TestDto("hello1", 1, false);
		TestDto testDto2 = new TestDto("hello2", 2, true);
		TestDto testDto3 = new TestDto("hello3", 3, false);

		testList.add(testDto1);
		testList.add(testDto2);
		testList.add(testDto3);

		return responseService.getDataResponse(testList);

	}

	@GetMapping("test3")
	public CommonResponse customExceptionTest(){

		throw new CustomException(CustomExceptionStatus.NOT_FOUND_CLUSTER);

	}
	@GetMapping("test4")
	public CommonResponse errorTest(){

		List<Integer> nullList = null;
		nullList.add(2);

		return responseService.getSuccessResponse();
	}
}
