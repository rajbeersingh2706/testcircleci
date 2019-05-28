
package com.salido.labor.logic;

import java.io.FileInputStream;
import java.text.ParseException;
import java.util.List;

import com.salido.labor.bean.LaborLocation;
import com.salido.labor.bean.LaborRuleLocation;
import com.salido.labor.dto.LaborRuleLocationDTO;
import com.salido.labor.dto.Location;

public interface LaborRuleLogic {

    List<LaborRuleLocation> listAppliedRule(final LaborRuleLocationDTO laborRuleLocationDTO);

    List<LaborRuleLocation> listAllRules(final LaborRuleLocationDTO laborRuleLocationDTO);

    LaborRuleLocation applyRule(final LaborRuleLocationDTO locationDTO) throws ParseException;

    LaborLocation processLocation(final Location location);

    FileInputStream getRuleIcon(final String ruleId, final String type);
}
