package medical.gene.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.analysis.service.AnalysisTAnalEnvMattBlVO;
import medical.analysis.service.AnalysisTAnalEnvMattVO;
import medical.analysis.service.AnalysisTAnalGenVO;
import medical.analysis.service.AnalysisTAnalSnpVO;
import medical.analysis.service.AnalysisTotalVO;
import medical.analysis.service.AnalysisVO;
import medical.gene.service.GeneTotalVO;
import medical.gene.service.GeneVO;
import medical.gene.service.TAnalGenVO;

@Repository("GeneDAO")
public class GeneDAO {
	
	@Autowired
	private SqlSession sqlSession;

	

	public List<TAnalGenVO> selectTAnalGenList(GeneVO geneVO){
		return sqlSession.selectList("Gene.selectTAnalGenList",geneVO);
	}
	public List<GeneVO> selectGeneMenuList(GeneVO geneVO){
		return sqlSession.selectList("Gene.selectGeneMenuList", geneVO);
	}


	public int selectTAnalGenListTotal(GeneVO geneVO) {
		return sqlSession.selectOne("Gene.selectTAnalGenListTotal",geneVO);
	}



	
	public int insertGene(TAnalGenVO TAnalGenVO) {
		return sqlSession.update("Gene.insertGene", TAnalGenVO);
	}
	public int updatePerformMst(GeneVO geneVO) {
		return sqlSession.update("Gene.updatePerformMst",geneVO);
	}
	public int deleteGeneAnswer(GeneVO geneVO) {
		return sqlSession.update("Gene.deleteGeneAnswer", geneVO);
	}
	public int deleteGeneTotalPm(GeneVO geneVO) {
		return sqlSession.update("Gene.deleteGeneTotalPm", geneVO);
	}
	public int updateGenePerformMstTotal(GeneVO geneVO) {
		return sqlSession.update("Gene.updateGenePerformMstTotal", geneVO);
	}
	public int updateGenePerformMst(GeneVO geneVO) {
		return sqlSession.update("Gene.updateGenePerformMst", geneVO);
	}

	
	public int deleteGene(GeneVO geneVO) {
		return sqlSession.update("Gene.deleteGene", geneVO);
	}

	public int selectGeneTotalListTotal(GeneTotalVO geneTotalVO) {
		return sqlSession.selectOne("Gene.selectGeneTotalListTotal", geneTotalVO);
	}
	public List<GeneTotalVO> selectGeneTotalList(GeneTotalVO geneTotalVO) {
		return sqlSession.selectList("Gene.selectGeneTotalList", geneTotalVO);
	}
	
	
}
