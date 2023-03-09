package com.eleiatech.stockmanagement.productservice.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class InternalApiResponse<T> { //Her türlü response için bunu kullanabileceğiz

    private FriendlyMessage friendlyMessage;
    private T payload;

    private boolean hasError;

    private List<String> errorMessages;

    private HttpStatus httpStatus; //notFound, BadRequest, OK, Created gibi HttpStatusleri tutacak.
}
//<T> bunu yaptığımızda classımız generic olur