package medical.common.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import medical.clinician.service.ClinicianVO;
import medical.framework.file.ExcelFile;

public abstract class AbstractService {
protected Log log = LogFactory.getLog("bdsp");
	
	@Autowired
	protected SqlSession sqlSession;


}
