package com.shoaib.regex.service.impl.secondmethod;

import com.shoaib.regex.model.dto.RegExInputDTO;
import com.shoaib.regex.model.dto.RegExOutputDTO;

import javax.ws.rs.core.Response;
import java.util.regex.Matcher;

public class SecondRegExImpl {
    long REGEX_TIMEOUT = 30000L;
    Object lock = new Object();
    boolean finished = false;
    Thread matcherThread;
    Matcher matcher;
    boolean matched;

    public Response valiadte2(RegExInputDTO regExInputDTO) {
        RegExOutputDTO regExOutputDTO = new RegExOutputDTO();
        try {
            matcherThread = Thread.currentThread(); /* imagine code to start monitor thread is here*/
            try {
                matched = matcher.find();
                regExOutputDTO.setMatch(regExInputDTO.getExtBody());
                regExOutputDTO.setError(false);
                return Response.ok().entity(regExOutputDTO).build();
            } finally {
                synchronized (lock) {
                    finished = true;
                    lock.notifyAll();
                }
            }
        } catch (ThreadDeath td) {
            regExOutputDTO.setMatch(null);
            regExOutputDTO.setError(true);
            return Response.ok().entity(regExOutputDTO).build();
        }
    }
}