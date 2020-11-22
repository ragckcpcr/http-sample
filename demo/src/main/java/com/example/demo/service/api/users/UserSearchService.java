package com.example.demo.service.api.users;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Component;

import com.example.demo.controller.serviceis.APIService;
import com.example.demo.dto.api.users.UserSearchRequestDto;
import com.example.demo.dto.api.users.UserSearchResponseDto;
import com.example.demo.service.api.AbstractApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ユーザー検索APIを実行する
 *
 */
@Component
public class UserSearchService extends AbstractApi<UserSearchRequestDto>
		implements APIService<UserSearchRequestDto, UserSearchResponseDto> {

	/**
	 * コンストラクタ<br>
	 * 内部で使用するリクエスト情報を渡す。
	 *
	 * @param request リクエスト情報
	 */
	public UserSearchService(UserSearchRequestDto request) {
		super(request);
	}

	/**
	 * リクエスト情報をAPIに送信する
	 */
	@Override
	public UserSearchResponseDto execute(UserSearchRequestDto request) {

		//APIがJSONを要求しているなら、引数からJSONを生成する。
		//Jacksonでも使って、DTOからJsonを作る
		String json = null;
		try {
			json = new ObjectMapper().writeValueAsString(request);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			//例外処理はプロジェクトのルールに則ってスローするなり握り潰すなりしてください
		}

		//送信処理を呼び出し
		String responseString = send(json);

		ObjectMapper mapper = new ObjectMapper();
		UserSearchResponseDto responseDto = null;
		try {
			responseDto = mapper.readValue(responseString, UserSearchResponseDto.class);
		} catch (JsonMappingException e) {
			//例外処理はプロジェクトのルールに則ってスローするなり握り潰すなりしてください
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			//例外処理はプロジェクトのルールに則ってスローするなり握り潰すなりしてください
			e.printStackTrace();
		}

		return responseDto;
	}

	@Override
	protected HttpsURLConnection createHeader(UserSearchRequestDto request) {
		URL url;
		HttpsURLConnection connection = null ;
		try {
			//このURLは本クラスのフィールドに用意した設定情報から受け取るなど改良してください。UserSearchRequestDtoには持たせない方がいいです。
			url = new URL("https://~~");
			connection = (HttpsURLConnection) url.openConnection();
			connection.addRequestProperty("Authorization", request.getAuthorization());
		} catch (IOException e) {
			e.printStackTrace();
			//例外処理はプロジェクトのルールに則ってスローするなり握り潰すなりしてください
		}
		return connection;
	}
}
