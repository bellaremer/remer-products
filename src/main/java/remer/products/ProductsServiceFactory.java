package remer.products;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsServiceFactory
{

    public ProductsService create()
    {
        // retrofit object allows us to create the objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")  // server connecting to
                // Configure Retrofit to use Gson to turn the Json into Objects
                .addConverterFactory(GsonConverterFactory.create())
                // Configure Retrofit to use Rx
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        // given all these things, create a product
        ProductsService service = retrofit.create(ProductsService.class);
        return service;
    }

}
