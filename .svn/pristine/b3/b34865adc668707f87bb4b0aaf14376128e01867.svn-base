package medical.imagingInfo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import medical.common.progress.ProgressDetails;
import medical.dataIntegration.service.DataIntegrationListVO;
import medical.dataIntegrationAsd.service.DataIntegrationAsdListVO;
import medical.framework.file.ExcelFile;
import medical.target.service.TargetVO;

public interface ImagingInfoService {
	int insertDocFileInfo(DocFileVO oDocFileVO);
	int deleteDocFileInfo(DocFileVO oDocFileVO);
	int insertImageInfoVO(ImageInfoVO oImageInfoVO);
	int insertUpfileOriginVO(UpfileOriginVO oUpfileOriginVO);
	int insertUpfileDecompVO(UpfileDecompVO oUpfileDecompVO);
	int insertTarFileInfo(ImagingTarFileVO oImagingTarFileVO);
	int deleteTarFileInfo(ImagingTarFileVO oImagingTarFileVO);
	int deleteImageInfoVO(ImageInfoVO oImageInfoVO);
	int deleteUpfileOriginVO(UpfileOriginVO oUpfileOriginVO);
	int deleteUpfileDecompVO(UpfileDecompVO oUpfileDecompVO);
	List<DocFileVO> selectDocFileInfo(DocFileVO oDocFileVO);
	boolean targetPdfUpload(HttpSession session, 
			MultipartFile file, 
			DocFileVO oDocFileVO) throws Exception;
	boolean dataUpload(List<MultipartFile> file, 
			ImageInfoVO oImageInfoVO, ProgressDetails taskProgress) throws Exception;
	boolean imagingExcelFileUpload(MultipartFile file, 
			DataIntegrationListVO oDataIntegrationListVO,
			DataIntegrationAsdListVO dataIntegrationAsdListVO,
			ProgressDetails taskProgress) throws Exception;
//	boolean imagingAsdExcelFileUpload(MultipartFile file, 
//			DataIntegrationAsdListVO dataIntegrationAsdListVO,
//			ProgressDetails taskProgress) throws Exception;
	
	
	List<UploadExcelVO> selectUploadExcelInfo(UploadExcelVO oUploadExcelVO);
	int insertUploadExcelInfo(UploadExcelVO oUploadExcelVO);
	int deleteUploadExcelInfo(UploadExcelVO oUploadExcelVO);
	int updateImagingInfo(DataIntegrationListVO oDataIntegrationListVO);
	int updateAsdImagingInfo(DataIntegrationAsdListVO dataIntegrationAsdListVO);
	int deleteImagingInfo(ImageInfoVO oImageInfoVO);
	int updateBlankMriDate(ImageInfoVO oImageInfoVO);
	public void deleteDocFile(DocFileVO oDocFileVO);
	public void removeImagingInfoByPerformCnt(ImageInfoVO oImageInfoVO);
	public void deleteImagingInfoByPerformCnt(ImageInfoVO oImageInfoVO);
	//영상 전체리스트 조회
	List<ImageInfoVO> selectImageList(ImageInfoVO imageInfoVO);
	int selectImageListTotal(ImageInfoVO imageInfoVO);
	//엑셀
	ExcelFile imagingExcelDownload(ImageInfoVO imageInfoVO);
	ExcelFile imagingExcelDownload2(ImageInfoVO imageInfoVO);
}
