package com.epam.agentx.statistic.repository

import com.epam.agentx.statistic.model.Statistic
import org.springframework.data.repository.CrudRepository

interface StatisticRepository : CrudRepository<Statistic, Long> {

}