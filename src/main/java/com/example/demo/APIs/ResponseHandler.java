package com.example.demo.APIs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class ResponseHandler {
    public static ResponseEntity<Object> generateMapResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", responseObj);
		map.put("message", message);
		map.put("status", status.value());
            
            return new ResponseEntity<Object>(map,status);
    }
}