package com.example.demo.service.api;

import javax.net.ssl.HttpsURLConnection;

import lombok.AllArgsConstructor;

/**
 * WebAPIへの共通処理クラス
 * @param <T>
 */
@AllArgsConstructor
public abstract class AbstractApi<T> {

	/**リクエスト情報*/
	private final T request;

	/**
	 * APIへ電文を送信する
	 * @param body 送信する電文
	 * @return 受信した応答電文
	 */
	protected String send(String body) {

		//まずはヘッダの生成
		HttpsURLConnection connection = createHeader(request);

		//あとはボディの設定やリクエスト送信、タイムアウト処理、リトライ処理などを実装

		//この辺で、受信した応答電文から文字列を取得
		StringBuffer sb = new StringBuffer();
		//今は固定のJSONを設定
		sb.append("{\"test\":\"testvalue\"}");

		//受信した応答電文を返す
		return sb.toString();
	}

	/**
	 * リクエストのヘッダを設定する
	 *
	 * @param request リクエスト情報
	 * @return
	 */
	protected abstract HttpsURLConnection createHeader(T request);
}
