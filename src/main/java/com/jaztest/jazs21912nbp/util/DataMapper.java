package com.jaztest.jazs21912nbp.util;

import com.jaztest.jazs21912nbp.model.ExchangeRateData;
import com.jaztest.jazs21912nbp.model.ExchangeRateDataDto;

public class DataMapper {

    public static ExchangeRateDataDto mapToDto(ExchangeRateData exchangeRateData){
        return new ExchangeRateDataDto(exchangeRateData.getOreData(),exchangeRateData.getBeginDate(),
                exchangeRateData.getEndDate(),exchangeRateData.getAverageRate(),exchangeRateData.getDateAndTimeOfQuery());
    }
}
