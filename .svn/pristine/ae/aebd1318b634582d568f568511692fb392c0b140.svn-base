package medical.target.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.common.service.PerformTermVO;
import medical.target.service.TargetVO;


@Repository("TargetDAO")
public class TargetDAO {
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<TargetVO> selectTargetList(TargetVO targetVO){
		return sqlSession.selectList("Target.selectTargetList",targetVO);
	}
	
	public int selectTargetListTotal(TargetVO targetVO){
		return sqlSession.selectOne("Target.selectTargetListTotal",targetVO);
	}
	
	public int insertTargetMst(TargetVO targetVO) {
		System.out.println("TargetMst DAO");
		return sqlSession.update("Target.insertTargetMst", targetVO);
	}
	
	public int insertPerformMst(TargetVO targetVO) {
		return sqlSession.update("Target.insertPerformMst", targetVO);
	}
	
	public int deletePerformMst(TargetVO targetVO) {
		return sqlSession.update("Target.deletePerformMst", targetVO);
	}
	
	public int selectPerformMstCnt(TargetVO targetVO) {
		return sqlSession.selectOne("Target.selectPerformMstCnt", targetVO);
	}
	
	public int deleteTargetMst(TargetVO targetVO) {
		return sqlSession.update("Target.deleteTargetMst", targetVO);
	}
	
	public List<TargetVO> selectTargetFollowUpList(TargetVO targetVO){
		return sqlSession.selectList("Target.selectTargetFollowUpList",targetVO);
	}
	
	public int updateTargetList(TargetVO targetVO){
		return sqlSession.update("Target.updateTargetList", targetVO);
	}
	
	public int updateNextVisitDate(TargetVO targetVO){
		return sqlSession.update("Target.updateNextVisitDate", targetVO);
	}
	
	public int updateTargetRemarks(TargetVO targetVO){
		return sqlSession.update("Target.updateTargetRemarks", targetVO);
	}
	
	public int selectPerformTermChk(TargetVO targetVO){
		return sqlSession.selectOne("Target.selectPerformTermChk",targetVO);
	}
	public String selectPerformMax(TargetVO targetVO) {
		return sqlSession.selectOne("Target.selectPerformMax",targetVO);
	}

	public List<TargetVO> selectTargetCntMax(TargetVO targetVO) {
		return sqlSession.selectList("Target.selectTargetCntMax",targetVO);
	}

	public int selectPerformCntMax(TargetVO targetVO) {
		return sqlSession.selectOne("Target.selectPerformCntMax",targetVO);
	}

	public int updateRemarksDataDtl(TargetVO targetVO) {
		return sqlSession.update("Target.updateRemarksDataDtl",targetVO);
	}

	public int insertTargetDisMst(TargetVO targetVO) {
		return sqlSession.update("Target.insertTargetDisMst", targetVO);
	}

	public List<TargetVO> selectTargetUniqueChk(TargetVO targetVO) {
		return sqlSession.selectList("Target.selectTargetUniqueChk",targetVO);
	}

}
