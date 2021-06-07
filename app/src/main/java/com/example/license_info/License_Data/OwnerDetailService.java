package com.example.license_info.License_Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OwnerDetailService {






    @GET("car_models")
    Call<CarRoot>getCarlist(@Query("brandId") String no);
   /* @POST("searchLicenseDetails")
    Call<LicenseRootModul>getLicensedata(@Query("licenseNo")String no,@Query("dob")String dob);*/

}
