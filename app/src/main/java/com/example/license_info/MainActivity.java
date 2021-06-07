package com.example.license_info;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.license_info.License_Data.ApiClient;
import com.example.license_info.License_Data.CarRoot;
import com.example.license_info.License_Data.Datum;
import com.example.license_info.License_Data.LicenseRootModul;
import com.example.license_info.License_Data.OwnerDetailService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        OwnerDetailService ownerDetailService=ApiClient.getDetails();
        Call<CarRoot> call=ownerDetailService.getCarlist("3");
        call.enqueue(new Callback<CarRoot>() {
            @Override
            public void onResponse(Call<CarRoot> call, Response<CarRoot> response) {
                if (response.isSuccessful())
                {
                    CarRoot carRoot=response.body();
                  List<Datum> datalist=carRoot.getData();
                  for (int i=0;i<datalist.size();i++)
                  {
                      String carmodel=datalist.get(i).getCarModelName();
                      System.out.println(carmodel);
                  }
                }
            }

            @Override
            public void onFailure(Call<CarRoot> call, Throwable t) {

            }
        });



       /* OwnerDetailService ownerDetailService= ApiClient.getDetails();
        Call<LicenseRootModul> call=ownerDetailService.getLicensedata("MH1420090030945", "17-07-1974");
        call.enqueue(new Callback<LicenseRootModul>() {
            @Override
            public void onResponse(Call<LicenseRootModul> call, Response<LicenseRootModul> response) {
               if (response.isSuccessful())
               {
                   LicenseRootModul licenseRootModul=response.body();
                   String no=licenseRootModul.getDetails().getHolderName();
               }
            }

            @Override
            public void onFailure(Call<LicenseRootModul> call, Throwable t) {
                Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}