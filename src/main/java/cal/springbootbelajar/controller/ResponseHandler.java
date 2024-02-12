package cal.springbootbelajar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus httpStatus, Object responseObject) {
        Map<String, Object> mapResponse = new HashMap<String, Object>();
        mapResponse.put("message", message);
        mapResponse.put("status", httpStatus.value());
        mapResponse.put("data", responseObject);

        return new ResponseEntity<Object>(mapResponse, httpStatus);
    }
}
