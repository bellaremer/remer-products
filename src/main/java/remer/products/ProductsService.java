package remer.products;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ProductsService
{
    // this is what we use to request data from the internet
    // describes how to get the data

    @GET("/products")
    Single<ProductsResponse> getProducts();

}
