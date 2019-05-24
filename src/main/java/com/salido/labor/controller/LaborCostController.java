package com.salido.labor.controller;

import com.salido.labor.dto.LaborCostRequestDTO;

public interface LaborCostController {

    public String calculateTimecardCost(LaborCostRequestDTO ruleProcessorDTO);

}
