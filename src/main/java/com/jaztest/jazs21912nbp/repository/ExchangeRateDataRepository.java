package com.jaztest.jazs21912nbp.repository;

import com.jaztest.jazs21912nbp.model.ExchangeRateData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateDataRepository extends JpaRepository<ExchangeRateData,Long> {
}
