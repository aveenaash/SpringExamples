package com.abinash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Cannot Read Image")
public class ImageUploadFailedException extends RuntimeException {
 
    private static final long serialVersionUID = -3332292346834265371L;
 
    public ImageUploadFailedException(){
        super("Product Image upload failed. Please try again uploading again");
    }
}
