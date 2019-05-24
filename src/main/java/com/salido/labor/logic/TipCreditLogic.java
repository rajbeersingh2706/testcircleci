package com.salido.labor.logic;

import java.text.ParseException;
import java.util.List;

import com.salido.labor.bean.LocationTipCredits;
import com.salido.labor.dto.TipCreditDTO;

public interface TipCreditLogic {

    LocationTipCredits addTipCredit(final TipCreditDTO tipCreditDTO) throws ParseException;

    List<LocationTipCredits> listTipCreditById(final TipCreditDTO tipCreditDTO);

}
