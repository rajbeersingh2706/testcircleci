package com.salido.labor.controller;

import com.salido.labor.dto.TipCreditDTO;

public interface TipCreditController {

	public String listTipCreditById(TipCreditDTO tipCreditDTO);

	String addTipCredit(TipCreditDTO tipCreditDTO, String token);

}
