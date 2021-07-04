package com.jaztest.jazs21912nbp.service;

import com.jaztest.jazs21912nbp.configuration.EnvData;
import com.jaztest.jazs21912nbp.configuration.StaticDataConf;
import com.jaztest.jazs21912nbp.model.*;
import com.jaztest.jazs21912nbp.repository.ExchangeRateDataRepository;
import com.jaztest.jazs21912nbp.util.DataMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class NBPService {

    private final ExchangeRateDataRepository exchangeRateDataRepository;
    private final RestTemplate restTemplate;
    private final EnvData envData;

    public NBPService(ExchangeRateDataRepository exchangeRateDataRepository, RestTemplate restTemplate, StaticDataConf staticDataConf) {
        this.exchangeRateDataRepository = exchangeRateDataRepository;
        this.restTemplate = restTemplate;
        envData = staticDataConf.getData().get("env");
    }

    public ExchangeRateDataDto getExchangeDateRateForPeriod(String startDate, String endDate){
        NBPExData[] nbpData =   restTemplate
                                .getForEntity(
                               String.format("%s/%s/%s/%s?format=json",envData.getUrl(),envData.getPath(),
                                                startDate,endDate), NBPExData[].class).getBody();
        double avgProce = Arrays.stream(nbpData).mapToDouble(NBPExData::getCena).average().getAsDouble();
        ExchangeRateData data =  new ExchangeRateData(OreData.GOLD, LocalDate.parse(startDate),LocalDate.parse(endDate),round(avgProce,2), Instant.now());
        exchangeRateDataRepository.save(data);
        return DataMapper.mapToDto(data);
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
