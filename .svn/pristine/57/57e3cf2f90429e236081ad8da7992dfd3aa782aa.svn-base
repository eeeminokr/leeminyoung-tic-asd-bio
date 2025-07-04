package medical.commoninfo.authority.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.commoninfo.authority.service.UsrAuthVO;

@Repository("AuthorityDAO")
public class AuthorityDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<UsrAuthVO> selectUsrAuthList(UsrAuthVO vo) {
		return sqlSession.selectList("Authority.selectUsrAuthList", vo);
	}
	
}
