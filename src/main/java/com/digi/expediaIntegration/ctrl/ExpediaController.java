package com.digi.expediaIntegration.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.expediaIntegration.service.ExpediaService;
import com.digi.expediaIntegration.vo.Package;

/**
 * handle requests to Expedia integration
 * @author Tariq
 *
 */
@RestController
@RequestMapping("/api/packages")
public class ExpediaController {
    private final ExpediaService expediaService;

    public ExpediaController(ExpediaService expediaService) {
        this.expediaService = expediaService;
    }

    @GetMapping
    public ResponseEntity<List<Package>> searchPackages(@RequestParam String originCity, @RequestParam String destinationCity) throws Exception {
    	return ResponseEntity.ok(expediaService.getPackageOffers(originCity, destinationCity));
    }
    
    //created to handle cases where Expedia API is down
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        // log exception
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    } 
}
