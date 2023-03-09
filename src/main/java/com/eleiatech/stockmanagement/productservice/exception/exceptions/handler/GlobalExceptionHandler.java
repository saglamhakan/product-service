package com.eleiatech.stockmanagement.productservice.exception.exceptions.handler;

import com.eleiatech.stockmanagement.productservice.exception.enums.FriendlyMessageCodes;
import com.eleiatech.stockmanagement.productservice.exception.exceptions.ProductAlreadyDeletedException;
import com.eleiatech.stockmanagement.productservice.exception.exceptions.ProductNotCreatedException;
import com.eleiatech.stockmanagement.productservice.exception.exceptions.ProductNotFoundException;
import com.eleiatech.stockmanagement.productservice.exception.utils.FriendlyMessageUtils;
import com.eleiatech.stockmanagement.productservice.response.FriendlyMessage;
import com.eleiatech.stockmanagement.productservice.response.InternalApiResponse;
import com.eleiatech.stockmanagement.productservice.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice //hataları tek bir yerden yönetmek için yazılır
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotCreatedException.class)
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotCreatedException productNoCreatedException){
return InternalApiResponse.<String>builder().friendlyMessage(FriendlyMessage.builder()
                .title(FriendlyMessageUtils.getFriendlyMessage(productNoCreatedException.getLanguage(), FriendlyMessageCodes.ERROR))
                .description(FriendlyMessageUtils.getFriendlyMessage(productNoCreatedException.getLanguage(),productNoCreatedException.getFriendlyMessageCode()))
                .build())
        .httpStatus(HttpStatus.BAD_REQUEST)
        .hasError(true)
        .errorMessages(Collections.singletonList(productNoCreatedException.getMessage()))
        .build();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotFoundException productNotFoundException){
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(productNotFoundException.getLanguage(),FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(productNotFoundException.getLanguage(), productNotFoundException.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.NOT_FOUND)
                .hasError(true)
                .errorMessages(Collections.singletonList(productNotFoundException.getMessage()))
                .build();
    }

    public InternalApiResponse<String> handleProductAlreadyDeletedException(ProductAlreadyDeletedException exception){
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),exception.getFriendlyMessageCode()))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), exception.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessages(Collections.singletonList(exception.getMessage()))
                .build();
    }

}
