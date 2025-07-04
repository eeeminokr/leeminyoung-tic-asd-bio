package medical.commoninfo.authority.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import medical.common.service.AbstractService;
import medical.commoninfo.authority.service.AuthorityService;
import medical.commoninfo.authority.service.UsrAuthVO;

@Service("AuthorityService")
public class AuthorityServiceImpl extends AbstractService implements AuthorityService {

	@Resource(name = "AuthorityDAO")
	private AuthorityDAO authorityDAO;
	
	@Override
	public List<UsrAuthVO> selectUsrAuthList(UsrAuthVO vo) {
		return authorityDAO.selectUsrAuthList(vo);
	}
	
}
