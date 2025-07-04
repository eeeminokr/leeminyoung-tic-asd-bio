package medical.dataIntegration.service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.dataIntegration.service.DataIntegrationListVO;
import medical.dataIntegration.service.DataIntegrationVO;

@Repository("DataIntegrationDAO")
public class DataIntegrationDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@SuppressWarnings("unchecked")
	public List<DataIntegrationVO> selectTicDocDtlList(DataIntegrationVO dataIntegrationVO) {
		return sqlSession.selectList("DataIntegration.selectTicDocDtlList", dataIntegrationVO);
	}
	@SuppressWarnings("unchecked")
	public List<DataIntegrationVO> selectTicDocDtl(DataIntegrationVO dataIntegrationVO) {
		return sqlSession.selectList("DataIntegration.selectTicDocDtl", dataIntegrationVO);
	}
	@SuppressWarnings("unchecked")
	public List<DataIntegrationListVO> selectDataIntegrationList(DataIntegrationListVO dataIntegrationListVO) {
		return sqlSession.selectList("DataIntegration.selectDataIntegrationList", dataIntegrationListVO);
	}
	@SuppressWarnings("unchecked")
	public int selectDataIntegrationListTotal(DataIntegrationListVO dataIntegrationListVO) {
		return sqlSession.selectOne("DataIntegration.selectDataIntegrationListTotal", dataIntegrationListVO);
	}

	public List<DataIntegrationListVO> selectDataIntegrationDtlList(DataIntegrationListVO dataIntegrationListVO) {
		return sqlSession.selectList("DataIntegration.selectDataIntegrationDtlList", dataIntegrationListVO);
	}
}
