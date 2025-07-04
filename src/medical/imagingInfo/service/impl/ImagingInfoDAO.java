package medical.imagingInfo.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.dataIntegration.service.DataIntegrationListVO;
import medical.dataIntegrationAsd.service.DataIntegrationAsdListVO;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.ImageInfoVO;
import medical.imagingInfo.service.ImagingTarFileVO;
import medical.imagingInfo.service.UpfileDecompVO;
import medical.imagingInfo.service.UpfileOriginVO;
import medical.imagingInfo.service.UploadExcelVO;

@Repository("ImagingInfoDAO")
public class ImagingInfoDAO {
	@Autowired
	private SqlSession sqlSession;
	//전체조회
	public List<ImageInfoVO> selectImageList(ImageInfoVO imageInfoVO){
		return sqlSession.selectList("ImagingInfo.selectImageList", imageInfoVO);
	}
	//전체 카운트
	public int selectImageListToTal(ImageInfoVO imageInfoVO) {
		return sqlSession.selectOne("ImagingInfo.selectImageListTotal",imageInfoVO);
	}
	public int insertDocFileInfo(DocFileVO oDocFileVO) {
		return sqlSession.update("ImagingInfo.insertDocFileInfo",oDocFileVO);
	}
	public int deleteDocFileInfo(DocFileVO oDocFileVO) {
		return sqlSession.update("ImagingInfo.deleteDocFileInfo",oDocFileVO);
	}
	public int insertImageInfoVO(ImageInfoVO oImageInfoVO) {
		return sqlSession.update("ImagingInfo.insertImageInfoVO", oImageInfoVO);
	}
	public int insertUpfileOriginVO(UpfileOriginVO oUpfileOriginVO) {
		return sqlSession.update("ImagingInfo.insertUpfileOriginVO", oUpfileOriginVO);
	}
	public int insertUpfileDecompVO(UpfileDecompVO oUpfileDecompVO) {
		return sqlSession.update("ImagingInfo.insertUpfileDecompVO", oUpfileDecompVO);
	}
	public int insertTarFileInfo(ImagingTarFileVO oImagingTarFileVO) {
		return sqlSession.update("ImagingInfo.insertTarFileInfo", oImagingTarFileVO);
	}
	public int deleteTarFileInfo(ImagingTarFileVO oImagingTarFileVO) {
		return sqlSession.update("ImagingInfo.deleteTarFileInfo", oImagingTarFileVO);
	}
	public int deleteImageInfoVO(ImageInfoVO oImageInfoVO) {
		return sqlSession.update("ImagingInfo.deleteImageInfoVO", oImageInfoVO);
	}
	public int deleteUpfileOriginVO(UpfileOriginVO oUpfileOriginVO) {
		return sqlSession.update("ImagingInfo.deleteUpfileOriginVO", oUpfileOriginVO);
	}
	public int deleteUpfileDecompVO(UpfileDecompVO oUpfileDecompVO) {
		return sqlSession.update("ImagingInfo.deleteUpfileDecompVO", oUpfileDecompVO);
	}
	public List<DocFileVO> selectDocFileInfo(DocFileVO oDocFileVO){
		return sqlSession.selectList("ImagingInfo.selectDocFileInfo", oDocFileVO);
	}
	public List<UploadExcelVO> selectUploadExcelInfo(UploadExcelVO oUploadExcelVO){
		return sqlSession.selectList("ImagingInfo.selectUploadExcelInfo", oUploadExcelVO);
	}
	public int insertUploadExcelInfo(UploadExcelVO oUploadExcelVO) {
		return sqlSession.update("ImagingInfo.insertUploadExcelInfo",oUploadExcelVO);
	}
	public int deleteUploadExcelInfo(UploadExcelVO oUploadExcelVO) {
		return sqlSession.update("ImagingInfo.deleteUploadExcelInfo",oUploadExcelVO);
	}
	public int updateImagingInfo(DataIntegrationListVO oDataIntegrationListVO) {
		return sqlSession.update("ImagingInfo.updateImagingInfo",oDataIntegrationListVO);
	}
	public int updateAsdImagingInfo(DataIntegrationAsdListVO dataIntegrationAsdListVO) {
		return sqlSession.update("ImagingInfo.updateAsdImagingInfo",dataIntegrationAsdListVO);
	}

	
	public List<UpfileOriginVO> selectUpfileOrigin(UpfileOriginVO oUpfileOriginVO){
		return sqlSession.selectList("ImagingInfo.selectUpfileOrigin", oUpfileOriginVO);
	}
	public int updateMriDate(ImageInfoVO oImageInfoVO) {
		return sqlSession.update("ImagingInfo.updateMriDate",oImageInfoVO);
	}
	public int updateBlankMriDate(ImageInfoVO oImageInfoVO) {
		return sqlSession.update("ImagingInfo.updateBlankMriDate",oImageInfoVO);
	}
	public int deleteImagingInfo(ImageInfoVO oImageInfoVO) {
		return sqlSession.update("ImagingInfo.deleteImagingInfo",oImageInfoVO);
	}
}
