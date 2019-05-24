package com.salido.labor.controller;

import com.salido.labor.dto.MinWageDTO;

public interface MinWageController {
	public String listMinWageById(MinWageDTO minWageDTO);

	String addMinWage(MinWageDTO minWageDTO, String token);

}
