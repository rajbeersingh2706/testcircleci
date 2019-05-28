package com.salido.labor.cost.logic;

import com.salido.labor.bean.RuleExpressions;
import com.salido.labor.dto.LaborCostRequestDTO;

public interface RuleResultProcessor {

    LaborCostRequestDTO process(LaborCostRequestDTO processDTO, RuleExpressions expression);

}
