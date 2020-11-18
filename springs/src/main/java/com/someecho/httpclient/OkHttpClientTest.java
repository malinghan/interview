package com.someecho.httpclient;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author : linghan.ma
 * @Package com.someecho.httpclient
 * @Description:
 * @date Date : 2020年11月17日 8:48 PM
 **/
@Slf4j
public class OkHttpClientTest {


    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .build();

    public static void main(String[] args) throws Exception{
        String url = "http://www.baidu.com";
//        System.out.println(doGet(""));
        new OkHttpClientTest().run(url);
    }

    private final OkHttpClient client = new OkHttpClient();

    public void run(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

            System.out.println(response.body().string());
        }
    }

    /**
     * get
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String doGet(String url) throws IOException {
        okhttp3.Request request = new okhttp3.Request.Builder().url(url).build();
        return executeRequestBody(request);
    }

    private static String executeRequestBody(Request body) throws IOException {
        Response response = CLIENT.newCall(body).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}
