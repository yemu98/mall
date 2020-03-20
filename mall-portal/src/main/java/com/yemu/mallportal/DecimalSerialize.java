package com.yemu.mallportal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author yemuc
 * @date 2020/3/20
 * 自定义序列化，保留两位小数
 */
public class DecimalSerialize extends JsonSerializer<BigDecimal> {
    private DecimalFormat df = new DecimalFormat("##.00");
    @Override
    public void serialize(BigDecimal bigDecimal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (bigDecimal!=null){
            jsonGenerator.writeString(df.format(bigDecimal));
        }
    }
}
