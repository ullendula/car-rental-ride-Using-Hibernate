package com.rentalrides.Dao;

import java.util.List;

import com.rentalrides.entity.Insurance;

public interface InsuranceDao {
	
	void saveInsurance(Insurance insurance);
    Insurance getInsuranceById(Long insuranceId);
    List<Insurance> getAllInsurances();
    void updateInsurance(Insurance insurance);
    void deleteInsurance(Long insuranceId);

}
