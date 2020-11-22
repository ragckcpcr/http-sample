package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.serviceis.APIService;
import com.example.demo.dto.api.users.UserSearchRequestDto;
import com.example.demo.dto.api.users.UserSearchResponseDto;

import lombok.AllArgsConstructor;

/**
 * サンプルコントローラー
 *
 */
@RestController
@AllArgsConstructor
public class SampleController {

	/** ユーザー検索API */
	private final APIService<UserSearchRequestDto, UserSearchResponseDto> userSearchService;

	/**
	 * リクエスト処理
	 * @return レスポンス電文
	 */
	@GetMapping("sample")
	public String index() {

		UserSearchRequestDto request = UserSearchRequestDto.initialize("userid", "authorize");
		UserSearchResponseDto response = userSearchService.execute(request);

		System.out.println(response);
		return "result string";
	}
}
