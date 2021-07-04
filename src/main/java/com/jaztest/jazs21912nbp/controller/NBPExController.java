package com.jaztest.jazs21912nbp.controller;

import com.jaztest.jazs21912nbp.model.ExchangeRateDataDto;
import com.jaztest.jazs21912nbp.service.NBPService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nbp/gold/")
public class NBPExController {

    private final NBPService nbpService;

    public NBPExController(NBPService nbpService) {
        this.nbpService = nbpService;
    }

    @Operation(summary = "Pobierz kursy z danego zakresu dat i policz srednia")

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "W przypadku zapytania poprawnego zwracany jest status code 200 i dane z srednia wartoscia kruszca."),
            @ApiResponse(code = 404, message = "W przypadku braku danych dla prawidłowo określonego zakresu czasowego " +
                    "zwracany jest komunikat 404 Not Found"),
            @ApiResponse(code = 400, message = "W przypadku zadania nieprawidłowo sformułowanych zapytań serwis zwraca" +
                    " komunikat 400 Bad Request"),
            @ApiResponse(code = 400, message = "W przypadku zapytania obejmującego więcej niż trzy miesiące serwis " +
                    "zwraca komunikat 400 Bad Request - Przekroczony limit 93 dni / Limit of 93 days has been exceeded")
    })
    @GetMapping("/{startDate}/{endDate}")
    public ResponseEntity<ExchangeRateDataDto> getAvgExFromParticularDateRange(
            @ApiParam(value = "Data od ktorej ma zaczac zbierac dane dot. kursu zlota", required = true)
            @PathVariable String startDate ,
            @ApiParam(value = "Data do ktorej ma zaczac zbierac dane dot. kursu zlota", required = true)
            @PathVariable String endDate){
        return ResponseEntity.ok(nbpService.getExchangeDateRateForPeriod(startDate,endDate));
    }
}
