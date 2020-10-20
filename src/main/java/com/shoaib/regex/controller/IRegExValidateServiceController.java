package com.shoaib.regex.controller;

import com.shoaib.regex.model.dto.RegExInputDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;


@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public interface IRegExValidateServiceController {

    @PostMapping(path = "/validate/regex")
    Response validateRegEx(@RequestBody RegExInputDTO regExInputDTO) ;

    @PostMapping(path = "/validate2/regex")
    Response validateRegEx2(@RequestBody RegExInputDTO regExInputDTO) ;
}