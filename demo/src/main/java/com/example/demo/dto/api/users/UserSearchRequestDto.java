package com.example.demo.dto.api.users;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

/**
 * ユーザー検索リクエスト
 *
 */
//@Setterは付与しないことにより、外部からの個別setを禁止
@Getter
@Component
public class UserSearchRequestDto {

	private UserSearchRequestDto() {
		//privateなコンストラクタにより、外部からのnewを禁止
	}

	/** ユーザーID*/
	private String userid;

	/** Authorizationヘッダに付与する値*/
	//ヘッダをRequestDto内に持つ場合はJSONへの変換から除外
	@JsonIgnore
	private String authorization;

	/**
	 * 引数から初期化済みユーザー検索リクエスト情報を生成する
	 *
	 * @param str ユーザーID
	 * @param str2 Authorizationヘッダー値
	 * @return
	 */
	public static UserSearchRequestDto initialize(String str,String str2) {
		UserSearchRequestDto dto = new UserSearchRequestDto();
		dto.userid=str;
		dto.authorization=str2;
		return dto;
	}
}
