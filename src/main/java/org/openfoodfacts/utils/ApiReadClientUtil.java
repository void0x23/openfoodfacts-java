package org.openfoodfacts.utils;

import org.openfoodfacts.exception.OpenFoodsFactsException;
import org.openfoodfacts.model.AbstractProductResponse;

import java.util.Optional;

public class ApiReadClientUtil {

    public static <T extends AbstractProductResponse> void checkResponseStatus(T response) {
        if (response.getStatus() == 0) {
            throw new OpenFoodsFactsException(response.getStatusVerbose());
        }
    }


    public static String checkBarcode(String code) {
        return Optional.ofNullable(code)
                .orElseThrow(() -> new OpenFoodsFactsException("Barcode cannot be null"));
    }

}
