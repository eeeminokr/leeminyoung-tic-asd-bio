package medical.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import medical.common.service.AbstractService;
import medical.common.service.CommonService;
import medical.common.service.PerformTermVO;

@Service("CommonService")
public class CommonServiceImpl extends AbstractService implements CommonService{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/** DAO Class */
	@Resource(name = "CommonDAO")
	private CommonDAO oCommonDAO;
	public List<PerformTermVO> selectPerformTerm(PerformTermVO oPerformTermVO){
		return oCommonDAO.selectPerformTerm(oPerformTermVO);
	}
	
	public String selectRndId() {
		return oCommonDAO.selectRndId();
	}
}
