package com.example.demo.controller.serviceis;

import org.springframework.stereotype.Component;

/**
 * WebAPIのインタフェースクラス
 *
 */
@Component
public interface APIService<T,R> {

	/**
	 *APIへのリクエスト処理実行
	 *
	 * @param request APIのリクエスト情報
	 * @return APIのレスポンス情報
	 */
	R execute(T request);
}
