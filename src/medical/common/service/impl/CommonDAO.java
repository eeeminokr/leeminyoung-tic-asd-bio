package medical.common.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.common.service.PerformTermVO;
import medical.target.service.TargetVO;

@Repository("CommonDAO")
public class CommonDAO {
	@Autowired
	private SqlSession sqlSession;
	public List<PerformTermVO> selectPerformTerm(PerformTermVO oPerformTermVO){
		return sqlSession.selectList("Common.selectPerformTerm",oPerformTermVO);
	}
	
	public String selectRndId(){
		return sqlSession.selectOne("Common.selectRndId");
	}
	
	public int insertPerformTerm(PerformTermVO oPerformTermVO) {
		return sqlSession.update("Common.insertPerformTerm", oPerformTermVO);
	}

	public int deletePerformTerm(PerformTermVO tvo) {
		return sqlSession.delete("Common.deletePerformTerm", tvo);
	}	
}
