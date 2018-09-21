package andrepbap.carreiraselo7.module;

import andrepbap.carreiraselo7.service.ApiService;
import andrepbap.carreiraselo7.util.Util;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    public ApiService getApiService () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.124:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        return apiService;
    }

}
