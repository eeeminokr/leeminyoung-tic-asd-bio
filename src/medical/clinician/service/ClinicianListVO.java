package medical.clinician.service;

import java.util.ArrayList;
import java.util.List;

import medical.framework.vo.KoriginCommonVO;

public class ClinicianListVO extends KoriginCommonVO{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6108244637263528706L;
	
	List<ClinicianVO> clinicianList = new ArrayList<ClinicianVO>();

	public List<ClinicianVO> getClinicianList() {
		return clinicianList;
	}

	public void setClinicianList(List<ClinicianVO> clinicianList) {
		this.clinicianList = clinicianList;
	}
	

}
