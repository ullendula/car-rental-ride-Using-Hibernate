package com.rentalrides.serviceImpl;

import java.util.List;

import com.rentalrides.DaoImpl.InsuranceDaoImpl;
import com.rentalrides.entity.Insurance;
import com.rentalrides.service.InsuranceService;

public class InsuranceServiceImpl implements InsuranceService{

	 private InsuranceDaoImpl insuranceDao = new InsuranceDaoImpl();

	    @Override
	    public void saveInsurance(Insurance insurance) {
	        insuranceDao.saveInsurance(insurance);
	    }

	    @Override
	    public Insurance getInsuranceById(Long insuranceId) {
	        return insuranceDao.getInsuranceById(insuranceId);
	    }

	    @Override
	    public List<Insurance> getAllInsurances() {
	        return insuranceDao.getAllInsurances();
	    }

	    @Override
	    public void updateInsurance(Insurance insurance) {
	        insuranceDao.updateInsurance(insurance);
	    }

	    @Override
	    public void deleteInsurance(Long insuranceId) {
	        insuranceDao.deleteInsurance(insuranceId);
	    }
}
