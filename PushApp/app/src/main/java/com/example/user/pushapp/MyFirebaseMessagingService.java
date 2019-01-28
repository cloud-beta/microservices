package com.example.user.pushapp;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    /**
     * App을 최초로 다운로드 받아 Token이 생성되거나
     * 이 외의 Token이 새로 갱신되는 경우 호출되는 메소드
     * (즉, FCM서버가 생성된 Token을 callback으로 알려주는 메소드)
     * @param token 생성된 token 값
     */
    @Override
    public void onNewToken(String token) {
        //핸드폰 번호 가져 오기
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        String phoneNum = "";
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            phoneNum = telephonyManager.getLine1Number();
        }

        sendRegistrationToServer(token, phoneNum);
    }

    private void sendRegistrationToServer(String token, String phoneNum) {
        // Send Token to Server
    }

    /**
     * FCM 서버로 부터 메시지를 받았을 경우 호출되는 메소드
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String context = remoteMessage.getData().get("data");
        // FCM서버로 부터 수신한 메시지중 data라는 키를 가진 값을 꺼내어 메소드로 파라미터로 넘겨준다
        sendNotification(context);
    }

    /**
     * Android 핸드폰에 알림을 띄워주는 메소드
     *
    */
    private void sendNotification(String data) {
        Uri uri = Uri.parse("https://www.naver.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = getString(R.string.channel_id);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("FCM Message")
                        .setContentText(data)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if(notificationManager.getNotificationChannel(channelId) == null) {
                NotificationChannel channel = new NotificationChannel(channelId, "jy", NotificationManager.IMPORTANCE_HIGH);
                notificationManager.createNotificationChannel(channel);
            }
        }

        notificationManager.notify(0, notificationBuilder.build());
    }
}
