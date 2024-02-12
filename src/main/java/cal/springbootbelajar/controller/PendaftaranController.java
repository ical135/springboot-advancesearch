package cal.springbootbelajar.controller;

import cal.springbootbelajar.service.PendaftaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/support/pendaftaran", produces = MediaType.APPLICATION_JSON_VALUE)
public class PendaftaranController {
    @Autowired
    PendaftaranService pendaftaranService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, pendaftaranService.getById(id));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

//    @PostMapping(path = "/advance-filter")
//    public ResponseEntity<Object> getAdvanceFilter(@PathVariable("id") Long id) {
//        try {
//            return ResponseHandler.generateResponse("Success", HttpStatus.OK, pendaftaranService.getAdvanceFilter(id));
//        } catch (Exception e) {
//            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
//        }
//    }


}
