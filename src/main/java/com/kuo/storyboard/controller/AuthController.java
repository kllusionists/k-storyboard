package com.kuo.storyboard.controller;

import com.alibaba.fastjson.JSONObject;
import com.kuo.storyboard.core.ErrorEnum;
import com.kuo.storyboard.core.Result;
import com.kuo.storyboard.core.ResultGenerator;
import com.kuo.storyboard.core.ServiceException;
import com.kuo.storyboard.dto.AuthenticationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Channing Kuo
 * @date 2021/9/7
 */
@Api(value = "/auth", tags = "登录模块")
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Value("${server-address}")
	private String serverAddress;

	final String CLIENT_ID = "storyboard-client-id";
	final String CLIENT_SECRET = "storyboard-kuo-client-secret";

	@ApiOperation(value = "账号密码模式登录", notes = "账号密码模式登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result<?> loginWithPassword(@RequestBody AuthenticationDto payload) {
		try {
			String userName = payload.getUserName();
			String password = payload.getPassword();
			String client_id = StringUtils.isBlank(payload.getAppId()) ? CLIENT_ID : payload.getAppId();
			String client_secret = StringUtils.isBlank(payload.getAppKey()) ? CLIENT_SECRET : payload.getAppKey();

			okhttp3.RequestBody body = new FormBody.Builder()
					.add("grant_type", "password")
					.add("username", userName)
					.add("password", password)
					.add("client_id", client_id)
					.add("client_secret", client_secret)
					.add("scope", "all")
					.build();

			Request request = new Request.Builder()
					.url(serverAddress + "/oauth/token")
					.post(body)
					.build();
			JSONObject result = this.executeOkHttp(request);
			if (null == result) {
				return ResultGenerator.genFailResult(ErrorEnum.INTERNAL_SERVER_ERROR.getResultMessage());
			}

			if (StringUtils.isNotBlank(result.getString("error"))) {
				throw new ServiceException("401", result.getString("error_description"));
			}
			return ResultGenerator.genSuccessResult(result);
		} catch (ServiceException e) {
			return ResultGenerator.genFailResult(e.getMessage());
		}
	}

	private JSONObject executeOkHttp(Request request) {
		OkHttpClient httpClient = new OkHttpClient();
		try {
			Response response = httpClient.newCall(request).execute();
			String authResult = Objects.requireNonNull(response.body()).string();
			JSONObject result = JSONObject.parseObject(authResult);
			result.remove("jti");
			result.remove("scope");
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
