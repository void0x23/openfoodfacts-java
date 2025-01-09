package org.openfoodfacts.ut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openfoodfacts.exception.OpenFoodsFactsException;
import org.openfoodfacts.model.ProductResponse;
import org.openfoodfacts.model.products.Product;
import org.openfoodfacts.utils.ApiReadClientUtil;
import static org.junit.jupiter.api.Assertions.*;

public class ApiReadClientUtilTest {

    @Test
    void checkResponseStatusOK() {

        ProductResponse productResponse = new ProductResponse();
        productResponse.setCode("nonexistingbarcode");
        productResponse.setProduct(new Product());
        productResponse.setStatus(0);
        productResponse.setStatusVerbose("no code or invalid code");

        OpenFoodsFactsException exception = assertThrows(OpenFoodsFactsException.class,
                () -> ApiReadClientUtil.checkResponseStatus(productResponse));

        assertEquals("no code or invalid code", exception.getLocalizedMessage());

    }

}
