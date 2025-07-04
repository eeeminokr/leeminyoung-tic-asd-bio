package medical.commoninfo.code.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import medical.common.service.AbstractService;
import medical.commoninfo.code.service.CodeService;
import medical.commoninfo.code.service.CodeVO;

@Service("CodeService")
public class CodeServiceImpl extends AbstractService implements CodeService {

	@Resource(name = "CodeDAO")
	private CodeDAO CodeDAO;

	public List<CodeVO> selectCodeDetailSearchCondition(CodeVO codeVO){
		
		return CodeDAO.selectCodeDetailSearchCondition(codeVO);
	}

}
