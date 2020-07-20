package com.api.vuttr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;


@RestController
@RequestMapping("/")
@Api(tags = { "Index EndPoint" })
public class IndexController {

	@GetMapping(value="/", produces = "application/json")
	@ApiOperation(value = "Initial presentation of welcome to the tools API")
	public ResponseEntity<String> welcome() {

		return ResponseEntity.ok("Welcome to the Tools API");
	}
}
