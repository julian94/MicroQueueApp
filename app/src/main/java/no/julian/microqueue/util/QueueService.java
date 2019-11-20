package no.julian.microqueue.util;

import io.reactivex.Single;
import retrofit2.http.*;

public interface QueueService {
    @POST("auth/register")
    Single<LoginResult> register(@Body LoginCredentials credentials);

    @POST("auth/login")
    Single<LoginResult> login(@Body LoginCredentials credentials);
    
    
	@GET("user/{id}")
	Single<User> getUser(@Path("id") String id,
                         @Header("Authorization") String token);

	@PATCH("user/{id}")
	Single<User> patchUser(@Path("id") String id, @Body User user,
                           @Header("Authorization") String token);

    @DELETE("user/{id}")
    Single<User> deleteUser(@Path("id") String id,
                            @Header("Authorization") String token);

    
    @POST("queue/create")
    Single<Queue> createQueue(@Body Queue queue,
                              @Header("Authorization") String token);

    @GET("queue/{id}")
    Single<Queue> getQueue(@Path("id") String id,
                           @Header("Authorization") String token);

    @PUT("queue/{id}")
    Single<Queue> updateQueue(@Path("id") String id,
                              @Body Queue queue,
                              @Header("Authorization") String token);

    @DELETE("queue/{id}")
    Single<Queue> deleteQueue(@Path("id") String id,
                              @Header("Authorization") String token);
    
    
    @GET("queue/place/{id}")
    Single<PlaceList> getPlaces(@Path("id") String id,
                                @Header("Authorization") String token);

    @POST("queue/place/{id}")
    Single<PlaceList> addToLine(@Path("id") String id,
                                @Body User user,
                                @Header("Authorization") String token);
    
    @PUT("queue/place/{id}")
    Single<PlaceList> updatePlace(@Path("id") String id,
                                  @Body User user,
                                  @Header("Authorization") String token);

    @DELETE("queue/place/{id}")
    Single<PlaceList> losePlace(@Path("id") String id,
                                @Header("Authorization") String token);

}
