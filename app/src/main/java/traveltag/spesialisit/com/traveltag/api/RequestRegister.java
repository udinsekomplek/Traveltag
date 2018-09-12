package traveltag.spesialisit.com.traveltag.api;



        import java.util.List;

        import okhttp3.MultipartBody;
        import retrofit2.http.Multipart;
        import retrofit2.http.Part;
        import traveltag.spesialisit.com.traveltag.model.ImageResult;
        import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultToDo;
        import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultTravelPlan;
        import traveltag.spesialisit.com.traveltag.model.mapLounge.ResultTravelerMapLounge;
        import traveltag.spesialisit.com.traveltag.model.LocalTourResponse;
        import traveltag.spesialisit.com.traveltag.model.ResponsModelRegister;

        import retrofit2.Call;
        import retrofit2.http.Field;
        import retrofit2.http.FormUrlEncoded;
        import retrofit2.http.GET;
        import retrofit2.http.POST;


public interface RequestRegister {

    @FormUrlEncoded
    @POST("server.php?operasi=op_add_user")
    Call<ResponsModelRegister> sendBiodata(@Field("username") String username,
                                   @Field("password") String password,
                                   @Field("email") String email,
                                           @Field("tipe") String tipe,
                                           @Field("ttl") String ttl,
                                           @Field("national") String national,
                                           @Field("gender") String gender,
                                           @Field("bio") String bio,
                                           @Field("img") String img

    );

    @GET("server.php?operasi=op_list_user")
    Call<ResponsModelRegister> getBiodata();

    @FormUrlEncoded
    @POST("server.php?operasi=op_update_user")
    Call<ResponsModelRegister> updateData( @Field("id") String id,
                                   @Field("username") String username,
                                   @Field("password") String password,
                                   @Field("email") String email);

    @FormUrlEncoded
    @POST("server.php?operasi=op_deluser")
    Call<ResponsModelRegister> deleteData(@Field("id") String id);

    @Multipart
    @POST("profilepicture/upload.php")
    Call<ImageResult> uploadImage(@Part MultipartBody.Part file);


    @GET("server.php?operasi=op_list_user")
    Call<LocalTourResponse> getUserLocal();

    @GET("server.php?operasi=op_list_userr")
    Call<ResultTravelerMapLounge> getUserTraveler();

    @FormUrlEncoded
    @POST("server.php?operasi=op1")
    Call<List<ResultTravelPlan>> rTravelPlan(@Field("iduser") String iduser);
//cal to do
    @FormUrlEncoded
    @POST("server.php?operasi=op2")
    Call<List<ResultToDo>> rToDo(@Field("idtplan") String idtplan);
    //call nonth list
    @FormUrlEncoded
    @POST("server.php?operasi=op3")
    Call<List<ResultTravelPlan>> rMonthList(@Field("idplan") String idplan, @Field("bulan") String bulan);
}
