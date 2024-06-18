package com.nextflow.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/concatenate")
public class ConcatenateController {

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    public ResponseEntity <Map<String, String>> getConcatenate (
            @RequestParam(required = false) String left,
            @RequestParam(required = false) String right) {
        Map<String, String> concatenateStrings = new HashMap<>();
        if(left == null || right == null || left.isEmpty() || right.isEmpty()) {
            concatenateStrings.put("error", "los dos son requeridos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(concatenateStrings);
        }
        concatenateStrings.put("result", left + right);
        return ResponseEntity.ok(concatenateStrings);
    }
}
