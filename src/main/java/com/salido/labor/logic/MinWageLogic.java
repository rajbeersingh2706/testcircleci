package com.salido.labor.logic;

import java.text.ParseException;
import java.util.List;

import com.salido.labor.bean.LocationMinWage;
import com.salido.labor.dto.MinWageDTO;

public interface MinWageLogic {

    LocationMinWage addMinWage(final MinWageDTO minWageDTO) throws ParseException;

    List<LocationMinWage> listMinWage(final MinWageDTO minWageDTO);

}
