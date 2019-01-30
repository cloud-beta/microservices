package com.beta.pushservice.util;

import com.beta.pushservice.constant.PushConstant;
import okhttp3.*;

import java.io.IOException;

public class PushUtil {
    public static void requestPush(String deviceToken, int placeID){
        OkHttpClient client = new OkHttpClient.Builder().build();

        okhttp3.RequestBody body = new FormBody.Builder()
                .add("to",deviceToken)
                .add("project_id", PushConstant.SENDER_ID)
                .add("notification","")
                .add("data",PushConstant.SURVEY_SERVER_DOMAIN + placeID)
                .build();

        Request request = new Request.Builder()
                .url("https://fcm.googleapis.com/fcm/send")
                .addHeader("Authorization", "key=" + PushConstant.API_KEY)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage() +"\n    ERROR");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {
                    System.out.println(response.code() + "\n" + response.body().string() +"\n    SUCCESS");
                }
                else{
                    System.out.println(response.body().string());
                }
            }
        });
    }
}
