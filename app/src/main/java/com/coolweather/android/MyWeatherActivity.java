package com.coolweather.android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.qweather.sdk.bean.base.IndicesType;
import com.qweather.sdk.bean.weather.WeatherNowBean;
import com.qweather.sdk.view.HeConfig;
import com.qweather.sdk.view.QWeather;

import org.json.JSONException;
import org.json.JSONObject;

public class MyWeatherActivity extends AppCompatActivity {
    String TAG = "Test";
    TextView tv_weather, tv_location, tv_temperature, tv_suggestion;
    String cityID = null;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myweather);
        //此处分别输入你申请的Username与Key
        HeConfig.init("HE2010191724241678", "bf2a8d885e474ee6a57e48de2347ef24");
        //个人开发者需要切换到免费服务域名，默认使用中国付费节点服务域名会报错
        HeConfig.switchToDevService();
        tv_weather = (TextView) findViewById(R.id.weather);
        tv_location = (TextView) findViewById(R.id.location);
        tv_temperature = (TextView) findViewById(R.id.temperature);
        tv_suggestion = (TextView) findViewById(R.id.suggestion);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWether();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWether();
    }

    private void getWether() {
        /**
         * 实况天气
         * 实况天气即为当前时间点的天气状况
         * @param context  上下文
         * @param listener  网络访问回调接口
         * 通过getWeatherNow和监听器OnResultWeatherNowBeanListener来监听返回的数据
         */
        QWeather.getWeatherNow(MyWeatherActivity.this,"CN101010100", new QWeather.OnResultWeatherNowListener(){
            public static final String TAG = "HeWeather_getWeatherNow";

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError:", e);
                System.out.println("Weather Now Error:" + new Gson());
            }

            @Override
            public void onSuccess(WeatherNowBean weatherNowBean) {
                Log.i(TAG, " Weather Now onSuccess:" + new Gson().toJson(weatherNowBean));
                Log.i(TAG, "onSuccess: "+new Gson().toJson(weatherNowBean.getNow().getTemp()));
                String weather = null, temperature = null, city = null, district = null, cid = null;
                if (weatherNowBean.getCode().equals("200")) {
                    String JsonNow = new Gson().toJson(weatherNowBean.getNow());
                    String JsonBasic = new Gson().toJson(weatherNowBean.getBasic());
                    JSONObject jsonObject = null;


                try {
                        jsonObject = new JSONObject(JsonNow);
                        cid = "101010101";
                        district = "湿度："+jsonObject.getString("humidity");
                        city = "体感温度:"+jsonObject.getString("feelsLike")+"℃";
                        weather = "天气状况:"+jsonObject.getString("text");
                        temperature = "温度："+jsonObject.getString("temp")+"℃";

                } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(MyWeatherActivity.this, "Mistakes...", Toast.LENGTH_SHORT).show();
                    return;
                }


                cityID = cid;
                tv_location.setText(city);
                tv_weather.setText(weather);
                tv_temperature.setText(temperature);
                tv_suggestion.setText(district);


                IndicesType all=IndicesType.ALL;
//                QWeather.getIndices1D(MyWeatherActivity.this, Collections.singletonList(all), Lang.ZH_HANS,new QWeather.OnResultIndicesListener(){
//                    public static final String TAG2 = "HeWeather_getSuggesion";
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        Log.i(TAG2, "ERROR IS:", throwable);
//                    }
//
//                    @Override
//                    public void onSuccess(IndicesBean indicesBean) {
//                        Log.i(TAG2, "LifeStyle onSuccess:" + new Gson().toJson(indicesBean));
//                        String sport = null;
//                        String suggestion = null;
//                        if (indicesBean.getCode().equals("ok")) {
//                            String JsonLifestyle = new Gson().toJson(indicesBean.getDailyList());
//                            JSONObject jsonObject = null;
//                            try {
//                                JSONArray jsonArray = new JSONArray(JsonLifestyle);
//                                sport = jsonArray.getString(3);
//                                jsonObject = new JSONObject(sport);
//                                suggestion = jsonObject.getString("txt");
//                                tv_suggestion.setText(suggestion);
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//                            Toast.makeText(MyWeatherActivity.this, "Mistakes...", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                    }
//                });
            }
        });
    }

}