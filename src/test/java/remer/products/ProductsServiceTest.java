package remer.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsServiceTest
{

    @Test
    void getProducts()
    {
        // given
        ProductsService service = new ProductsServiceFactory().create();

        // when
        ProductsResponse products = service.getProducts()
                .blockingGet();     // this should only be used in tests

        // then
        assertEquals(30, products.products.length);
    }

}