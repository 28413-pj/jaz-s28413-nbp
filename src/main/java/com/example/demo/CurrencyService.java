package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyQueryRepository repository;

    public double getAverageRate(String currency, int firstday, int lastday) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + firstday + "/"+ lastday + "/?format=json";
        RestTemplate restTemplate = new RestTemplate();
        NbpResponse response = restTemplate.getForObject(url, NbpResponse.class);

        double sum = 0;
        for (Rate rate : response.getRates()) {
            sum += rate.getMid();
        }
        double averageRate = sum / response.getRates().length;

        CurrencyQuery query = new CurrencyQuery();
        query.setCurrency(currency);
        query.setFirstday(LocalDate.ofEpochDay(firstday));
        query.setLastday(lastday);
        query.setAverageRate(averageRate);
        query.setQueryTime(LocalDate.from(LocalDateTime.now()));
        repository.save(query);

        return averageRate;
    }

    private static class NbpResponse {
        private Rate[] rates;

        public Rate[] getRates() {
            return rates;
        }

        public void setRates(Rate[] rates) {
            this.rates = rates;
        }
    }

    private static class Rate {
        private double mid;

        public double getMid() {
            return mid;
        }

        public void setMid(double mid) {
            this.mid = mid;
        }
    }
}
