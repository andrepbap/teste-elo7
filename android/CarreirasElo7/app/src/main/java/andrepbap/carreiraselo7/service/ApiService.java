package andrepbap.carreiraselo7.service;

import java.util.ArrayList;

import andrepbap.carreiraselo7.model.Area;
import andrepbap.carreiraselo7.model.Cultura;
import andrepbap.carreiraselo7.model.MenuLink;
import andrepbap.carreiraselo7.model.Social;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/cultura")
    Call<ArrayList<Cultura>> getCulturas();

    @GET("/area")
    Call<ArrayList<Area>> getAreas();

    @GET("/social")
    Call<ArrayList<Social>> getSocials();

    @GET("/menu")
    Call<ArrayList<MenuLink>> getMenu();

}
