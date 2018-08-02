
package com.leysoft.service.inter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.leysoft.model.CustomMessage;

public interface SenderService {

    public void send(CustomMessage payload) throws JsonProcessingException;
}
