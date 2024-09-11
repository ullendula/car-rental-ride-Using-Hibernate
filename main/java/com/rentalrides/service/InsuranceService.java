package com.rentalrides.service;

import java.util.List;

import com.rentalrides.entity.Insurance;

public interface InsuranceService {

	 void saveInsurance(Insurance insurance);
	    Insurance getInsuranceById(Long insuranceId);
	    List<Insurance> getAllInsurances();
	    void updateInsurance(Insurance insurance);
	    void deleteInsurance(Long insuranceId);
	
}
