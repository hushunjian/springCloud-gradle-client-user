package com.hushunjian.springcloud.client.user.enumeration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.BeanUtils;

import java.io.IOException;

public class BaseEnumDeserialize extends JsonDeserializer<BaseEnum> {
    @Override
    public BaseEnum deserialize(JsonParser p, DeserializationContext context) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        Class<?> clazz = BeanUtils.findPropertyType(p.currentName(), p.getCurrentValue().getClass());
        clazz.getEnumConstants();
        return null;
    }
}
