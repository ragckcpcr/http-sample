package com.example.demo.dto.api.users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ユーザー検索レスポンス
 *
 */
@ToString
@Setter
@Getter
public class UserSearchResponseDto {

	//ここはJacsonでもしようして応答のJSON電文からDTOを直接生成するとよい
	private String test;
}
