package medical.commoninfo.code.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.commoninfo.code.service.CodeVO;

@Repository("CodeDAO")
public class CodeDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@SuppressWarnings("unchecked")
	public List<CodeVO> selectCodeDetailSearchCondition(CodeVO codeVO){
		return sqlSession.selectList("Code.selectCodeDetailSearchCondition",codeVO);
	}
}
