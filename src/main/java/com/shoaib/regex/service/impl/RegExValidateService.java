package com.shoaib.regex.service.impl;

import com.shoaib.regex.controller.IRegExValidateServiceController;
import com.shoaib.regex.model.dto.RegExInputDTO;
import com.shoaib.regex.model.dto.RegExOutputDTO;
import com.shoaib.regex.service.impl.firstmethod.RegularExpressionUtils;
import com.shoaib.regex.service.impl.secondmethod.SecondRegExImpl;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.regex.Matcher;


@Service
public class RegExValidateService implements IRegExValidateServiceController {
    @Override
    public Response validateRegEx(RegExInputDTO regExInputDTO) {
        RegExOutputDTO regExOutputDTO = new RegExOutputDTO();
        try {
            Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(regExInputDTO.getRegex(), regExInputDTO.getExtBody(), 2000);
            boolean b = matcher.matches();
            regExOutputDTO.setMatch(regExInputDTO.getExtBody());
            regExOutputDTO.setError(false);
            return Response.ok().entity(regExOutputDTO).build();
        } catch (Exception e) {
            regExOutputDTO.setMatch(null);
            regExOutputDTO.setError(true);
            return Response.ok().entity(regExOutputDTO).build();
        }
    }

    @Override
    public Response validateRegEx2(RegExInputDTO regExInputDTO) {
        SecondRegExImpl secondRegEx= new SecondRegExImpl();
        return  secondRegEx.valiadte2(regExInputDTO);
    }
}
