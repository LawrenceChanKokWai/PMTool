package com.codeIt.pmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationServiceError {

    public ResponseEntity<?> ValidationServiceError(BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMsg = new HashMap<>();
            for(FieldError error : result.getFieldErrors()){
                errorMsg.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMsg, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
