package com.abinash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NO_CONTENT, reason="Image is Null")
public class ImageFileNullException extends RuntimeException {
 
    private static final long serialVersionUID = -3332292346834265371L;
 
    public ImageFileNullException(){
        super("Product Image is Null. Please try again uploading again");
    }
}
