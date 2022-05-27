package saulodev.com.integrationproject.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit RETROFIT;

    private static String BASE_URL = "http://192.168.15.2:8080";//Siqueira
    //private static String BASE_URL = "http://192.168.15.86:8080";//Marinho
    //private static String BASE_URL = "http://192.168.15.87:8080";//Rodrigo
    //private static String BASE_URL = "http://192.168.15.6:8080";//Constantino
    //private static String BASE_URL = "http://192.168.84.245:8080";//Petros
    //private static String BASE_URL = "http://192.168.15.9:8080";//Vini

    //private static String BASE_URL = "http://192.168.15.2:8080";//Mendes
    //private static String BASE_URL = "http://192.168.15.2:8080";//PH
    //private static String BASE_URL = "http://192.168.15.2:8080";//Saulo
    //private static String BASE_URL = "http://192.168.15.2:8080";//Luiz


    public static Retrofit getRETROFIT(){

        if (RETROFIT == null){
            RETROFIT = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT;
    }

}
