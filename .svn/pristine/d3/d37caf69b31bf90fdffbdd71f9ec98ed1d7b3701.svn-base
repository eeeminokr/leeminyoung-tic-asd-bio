package medical.dataIntegrationAsd.service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.dataIntegrationAsd.service.DataIntegrationAsdListVO;
import medical.dataIntegrationAsd.service.DataIntegrationAsdVO;

@Repository("DataIntegrationAsdDAO")
public class DataIntegrationAsdDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<DataIntegrationAsdListVO> selectDataIntegrationAsdList(
			DataIntegrationAsdListVO dataIntegrationAsdListVO) {
		return sqlSession.selectList("DataIntegrationAsd.selectDataIntegrationListAo", dataIntegrationAsdListVO);
	}

	public int selectDataIntegrationListAoTotal(DataIntegrationAsdListVO dataIntegrationAsdListVO) {
		return sqlSession.selectOne("DataIntegrationAsd.selectDataIntegrationListAoTotal", dataIntegrationAsdListVO);
	}

	public List<DataIntegrationAsdVO> selectTicDocDtlList(DataIntegrationAsdVO dataIntegrationAsdVO) {
		return sqlSession.selectList("DataIntegrationAsd.selectTicDocDtlList", dataIntegrationAsdVO);
	}

	public List<DataIntegrationAsdVO> selectTicDocDtl(DataIntegrationAsdVO dataIntegrationAsdVO) {
		return sqlSession.selectList("DataIntegrationAsd.selectTicDocDtl", dataIntegrationAsdVO);
	}

	public List<DataIntegrationAsdListVO> selectDataIntegrationDtlListAo(
			DataIntegrationAsdListVO dataIntegrationAsdListVO) {
		return sqlSession.selectList("DataIntegrationAsd.selectDataIntegrationDtlListAo", dataIntegrationAsdListVO);
	}
}
