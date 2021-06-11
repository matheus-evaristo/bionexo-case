package com.example.spring.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;

/**
 * Utility class to convert between database and application data format
 */
@Converter
public class UbsScoreConverter implements AttributeConverter<Integer, String> {
    private final ArrayList<String> descriptionList = new ArrayList<String>() {
        {
            add("Desempenho mediano ou  um pouco abaixo da média");
            add("Desempenho acima da média");
            add("Desempenho muito acima da média");
        }
    };
    private final Integer [] scores = { 1, 2, 3 };

    @Override
    public String convertToDatabaseColumn(Integer scoreValue) {
        return descriptionList.get(scoreValue - 1);
    }

    @Override
    public Integer convertToEntityAttribute(String scoreDescription) {
        return scores[descriptionList.indexOf(scoreDescription)];
    }
}
