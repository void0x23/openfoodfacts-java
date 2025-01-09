package org.openfoodfacts.utils;

import org.openfoodfacts.exception.OpenFoodsFactsException;
import org.openfoodfacts.model.AbstractProductResponse;
import java.net.http.HttpResponse;
import java.util.Optional;

public class ApiReadClientUtil {

    // Private constructor to prevent instantiation
    private ApiReadClientUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void checkHttpStatus(HttpResponse<String> response) {
        if (response.statusCode() >= 400) {
            throw new OpenFoodsFactsException("Server returned error status: " + response.statusCode() + " with error message: " + response.body());
        }
    }

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
