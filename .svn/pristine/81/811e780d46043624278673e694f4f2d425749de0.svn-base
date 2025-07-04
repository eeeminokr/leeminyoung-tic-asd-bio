package medical.target.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import medical.common.service.AbstractService;
import medical.common.service.PerformTermVO;
import medical.common.service.impl.CommonDAO;
import medical.commoninfo.code.service.CodeVO;
import medical.commoninfo.code.service.impl.CodeDAO;
import medical.commoninfo.member.service.MemberVO;
import medical.framework.file.ExcelFile;
import medical.framework.file.ExcelFileReader;
import medical.framework.file.ExcelFileWriter;
import medical.framework.util.Constant;
import medical.framework.util.FileUtils;
import medical.framework.util.ResourceBundleUtil;
import medical.framework.util.StringUtil;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.ImageInfoVO;
import medical.imagingInfo.service.ImagingInfoService;
import medical.imagingInfo.service.UploadExcelVO;
import medical.imagingInfo.service.impl.ImagingInfoDAO;
import medical.neuropsy.service.NeuropsyService;
import medical.neuropsy.service.NeuropsyVO;
import medical.survey.service.SurveyVO;
import medical.survey.service.impl.SurveyDAO;
import medical.target.service.TargetListVO;
import medical.target.service.TargetService;
import medical.target.service.TargetVO;

@Service("TargetService")
public class TargetServiceImpl extends AbstractService implements TargetService{

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/** DAO Class */
	@Resource(name = "TargetDAO")
	private TargetDAO targetDAO;
	@Resource(name = "CommonDAO")
	private CommonDAO commonDAO;
	@Resource(name = "CodeDAO")
	private CodeDAO codeDAO;
	@Resource(name = "ImagingInfoDAO")
	private ImagingInfoDAO oImagingInfoDAO;
	@Resource(name = "SurveyDAO")
	private SurveyDAO surveyDAO;
	@Resource(name = "NeuropsyService")
	private NeuropsyService neuropsyService;
	
	/** Sevice Class */
	@Resource(name = "ImagingInfoService")
	private ImagingInfoService oImagingInfoService;
	
	
	
	
	private ExcelFileWriter<TargetVO> targetExcelFileWriter;
	private ExcelFileWriter<TargetVO> targetExcelFileWriter2;
	
	private ExcelFileReader<TargetVO> targetFileReader;
	private ExcelFileReader<TargetVO> targetFileReader2;
	
	public void setTargetExcelFileWriter(ExcelFileWriter<TargetVO> targetExcelFileWriter) {
		this.targetExcelFileWriter = targetExcelFileWriter;
	}
	public void setTargetExcelFileWriter2(ExcelFileWriter<TargetVO> targetExcelFileWriter2) {
		this.targetExcelFileWriter2 = targetExcelFileWriter2;
	}
	
	public void setTargetFileReader(ExcelFileReader<TargetVO> targetFileReader) {
		this.targetFileReader = targetFileReader;
	}
	public void setTargetFileReader2(ExcelFileReader<TargetVO> targetFileReader2) {
		this.targetFileReader2 = targetFileReader2;
	}
	
	
	public List<TargetVO> selectTargetList(TargetVO targetVO){
//		MemberVO memberVO = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
//		String rndId = memberVO.getRndId();
//		
//		int targetCntMax = targetDAO.selectTargetCntMax(targetVO);
//		int termCntMax = targetDAO.selectPerformCntMax(targetVO);
//		
//		if(targetCntMax > 8 && targetCntMax < termCntMax) {
//			TargetVO tvo = new TargetVO();
////			tvo.setRndId(rndId);
//			tvo.setPerformCnt(Integer.toString(targetCntMax));
//			commonDAO.deletePerformTerm(tvo);
//		}
		
		//공존진단 설명 내용 추가
		List<TargetVO> list = targetDAO.selectTargetList(targetVO); 
		CodeVO codeVO = new CodeVO();
		HashMap<String,String> cxtDetatilMap = new HashMap<String,String>();
		codeVO.setClassCd("CXTD1");
		List<CodeVO> cxtDetailList = codeDAO.selectCodeDetailSearchCondition(codeVO);
		for(CodeVO cvo : cxtDetailList) {
			if(!cxtDetatilMap.containsKey(cvo.getClassCdDtl())) {
				cxtDetatilMap.put(cvo.getClassCdDtl(), cvo.getClassCdDtlNm());
			}
		}
		String cxtDStrT="";
		String[] cxtDArr;
		String[] cxtArr;
		String cxtK = "";
		for(TargetVO tvo : list) {
			if(!StringUtil.isEmptyString(tvo.getCxtDetail())) {
				cxtDArr = tvo.getCxtDetail().split(",");
				cxtArr = tvo.getCxtDiag().split(",");
				cxtDStrT = "";
				for(int i=0; i<cxtArr.length; i++) {
					cxtK = cxtArr[i].trim();
					if(cxtDetatilMap.containsKey(cxtK)){
						cxtDStrT += cxtK+". "+cxtDetatilMap.get(cxtK);
						if("5".equals(cxtK) || "6".equals(cxtK) || "7".equals(cxtK)) {
							//정동장애, 불안장애, 기타 인 경우
							cxtDStrT += "("+cxtDArr[i]+")";
						}
						if(i!=cxtDArr.length-1) cxtDStrT += "<br/>";
					}
				}
				tvo.setCxtDetail(cxtDStrT);
			}
		}
		
		
		return list;
	}
	
	public int selectTargetListTotal(TargetVO targetVO){
		return targetDAO.selectTargetListTotal(targetVO);
	}
	
	public ExcelFile targetExcelDownload(TargetVO targetVO) {
		return  targetExcelFileWriter.excelWrite(targetDAO.selectTargetList(targetVO), ExcelFile.XLSX);
	}
	public ExcelFile targetExcelDownload2(TargetVO targetVO) {
		return  targetExcelFileWriter2.excelWrite(targetDAO.selectTargetList(targetVO), ExcelFile.XLSX);
	}
	
	public int targetExcelUpload(HttpSession session,File file) throws Exception {
		int result = 0;
		MemberVO memberVO = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		String rndId = memberVO.getRndId();
		CodeVO codeVO = new CodeVO();
		List<CodeVO> codeList; 
		List<TargetVO> idChk = null;
		TargetVO tvo = new TargetVO();
		
		String disClassDtl = (String) session.getAttribute("disClassDtl");
	
		List<TargetVO> dataList = null;
		if("DS001".equals(disClassDtl)) {
			dataList = targetFileReader.excelRead(file);
		}else {
			dataList = targetFileReader2.excelRead(file);
		}
		
		for (TargetVO vo : dataList) {
			//대상자 id 중복 체크
			tvo.setRndId(rndId);
			tvo.setUseYn("Y");
			tvo.setDisClassDtl(disClassDtl);
			idChk = targetDAO.selectTargetUniqueChk(tvo);
			
			if(idChk.size() > 0) {
				//대상자id (TARGET_ID) 중복시 upload X
				throw new RuntimeException("중복된 대상자가 있습니다. 데이터를 확인해주세요. 연구번호 : "
				+idChk.get(0).getTargetId()+" 메뉴 : "+idChk.get(0).getDisClassDtl());
			}
			//질병군 코드값 가져오기
			codeVO.setClassCd("DISE1");
			codeVO.setClassCdDtlNm(vo.getDisClassDtl());
			codeList = codeDAO.selectCodeDetailSearchCondition(codeVO); 
			
			String uploadDisClass = "";
			if(codeList.size()>0 && !"".equals(vo.getDisClassDtl())) {
				uploadDisClass = codeList.get(0).getClassCdDtl();
				vo.setDisClassDtl(codeList.get(0).getClassCdDtl());
			}
			
			if(!disClassDtl.equals(uploadDisClass)) {
				//메뉴의 질병군 코드값(session에서 가져옴)과 업로드 한 질병군 확인 후 다를 경우 upload X
				continue;
			}
			
			//프로토콜 코드값 가져오기
			String protocolNm = vo.getProtocol();
			if("".equals(protocolNm)) {
				//프로토콜 값이 없는 경우 insert X 
				continue;
			}
			codeVO.setClassCd("PT001");
			codeVO.setClassCdDtlNm(protocolNm);
			codeList = codeDAO.selectCodeDetailSearchCondition(codeVO); 
			if(codeList.size()>0) {
				vo.setProtocol(codeList.get(0).getClassCdDtl());
			}
			
			//차수 확인 후 없는 차수면 T_PERFORM_TERM INSERT
			if("".equals(vo.getPerformCntNm())) {
				
				//차수가 없을 경우 upload X
				continue;
			}
			int performTermChk = targetDAO.selectPerformTermChk(vo);
			
			if(performTermChk != 0) {
				//차수가 없는 경우
				String performMax = targetDAO.selectPerformMax(vo);
				
				PerformTermVO performTermVO = new PerformTermVO();
				String oPerformCntNm = vo.getPerformCntNm().toUpperCase(); //추가하려는 차수
				
				int subNm = Integer.parseInt(oPerformCntNm.substring(1, oPerformCntNm.length())); //추가하려는 차수의 숫자
				int subPerformMax = Integer.parseInt(performMax.substring(1, performMax.length())); //최대 차수명 숫자
						//차수가 정상적으로 늘었을때
					if(subNm == (subPerformMax +1)) {
						performTermVO.setPerformCnt(performTermChk);
						performTermVO.setRndId(rndId);
						performTermVO.setPerformNm(oPerformCntNm);
						performTermVO.setCreateBy("excel_upload");
						commonDAO.insertPerformTerm(performTermVO);
					} else if(subNm > (subPerformMax+1)) { //차수명이 중간에 누락되어 들어왔을 때 자동으로 전 차수 삽입
						for(int i = (subPerformMax+1); i < (subNm+1); i++) {
							performTermVO.setPerformCnt(i+4);
							performTermVO.setRndId(rndId);
							performTermVO.setPerformNm("V"+i);
							performTermVO.setCreateBy("excel_upload");
							commonDAO.insertPerformTerm(performTermVO);
						}
					}
				
			}
			vo.setRndId(rndId);
			vo.setUseYn("Y");
			String targetDisId = vo.getTargetDisId();
			//T_TARGET_MST insert
			targetDAO.insertTargetMst(vo);
			if(!"".equals(targetDisId) && targetDisId != null) targetDAO.insertTargetDisMst(vo);
			//T_PERFORM_MST insert
			targetDAO.insertPerformMst(vo);
		}
	
		return result;
	}
	
	public int  deleteTargetId(HttpSession session, TargetListVO targetListVO) {
		int result = 0;
		MemberVO memberVO = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		String rndId = memberVO.getRndId();
		String disClassDtl = (String) session.getAttribute("disClassDtl");
		ImageInfoVO ImageInfoVO = new ImageInfoVO();
		SurveyVO surveyVO = new SurveyVO();
		NeuropsyVO neuropsyVO =  new NeuropsyVO();
		
		
		for(TargetVO vo : targetListVO.getTargetList()) {
			vo.setRndId(rndId);
			vo.setDisClassDtl(disClassDtl);
			targetDAO.deletePerformMst(vo);
			
			//Neuropsy 삭제
			neuropsyVO.setRndId(rndId);
			neuropsyVO.setTargetId(vo.getTargetId());
			neuropsyVO.setDisClassDtl(disClassDtl);
			neuropsyVO.setPerformCnt(vo.getPerformCnt());
			neuropsyVO.setPerformCntNm(vo.getPerformCntNm());
			neuropsyService.deleteNeuropsyS1(neuropsyVO);
			if("DS003".equals(disClassDtl)) {	
				neuropsyService.deleteS1IKLeiter(neuropsyVO);
			}
			neuropsyService.deleteNeuropsyAta(neuropsyVO);
			neuropsyService.deleteNeuropsyStroop(neuropsyVO);
			neuropsyService.deleteNeuropsyCctt(neuropsyVO);
			neuropsyService.deleteNeuropsyWsct(neuropsyVO);
			neuropsyService.deleteNeuropsyCat(neuropsyVO);
			neuropsyService.deleteNeuropsyExitii(neuropsyVO);
			neuropsyService.deleteNeuropsyCpt(neuropsyVO);
			neuropsyService.deleteNeuropsyTmt(neuropsyVO);
			neuropsyService.deleteNeuropsyAdos1(neuropsyVO);
			neuropsyService.deleteNeuropsyAdos2(neuropsyVO);
	//		neuropsyService.deleteNeuropsyAdos3(neuropsyVO);
			neuropsyService.deleteNeuropsyPep(neuropsyVO);
			neuropsyService.deleteNeuropsySms(neuropsyVO);
			neuropsyService.deleteNeuropsyCars(neuropsyVO);
			
			//survey 삭제
			surveyVO.setRndId(rndId);
			surveyVO.setTargetId(vo.getTargetId());
			surveyVO.setPerformCnt(vo.getPerformCnt());
			surveyDAO.deleteSurveyAnswer(surveyVO);
			
			//ImagingInfo 삭제
			ImageInfoVO.setRndId(rndId);
			ImageInfoVO.setDisClassDtl(disClassDtl);
			ImageInfoVO.setPerformCntNm(vo.getPerformCntNm());
			ImageInfoVO.setTargetId(vo.getTargetId());
			oImagingInfoService.removeImagingInfoByPerformCnt(ImageInfoVO);
			
			
			//T_PERFORM_MST에 TARGET_ID의 모든 차수 삭제 시 TARGET_MST도 삭제
			int targetIdCnt = targetDAO.selectPerformMstCnt(vo);
			
			if(targetIdCnt==0) {
				targetDAO.deleteTargetMst(vo);
			}
		}
		
		return result;
	}
	
	public boolean targetFileUpload(HttpSession session, MultipartFile file, 
			HttpServletRequest request, DocFileVO oDocFileVO) throws Exception {
		boolean tf = false;
		MemberVO memberVo = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		try {
			if (file != null) {
				String fileName = file.getOriginalFilename();
				String fileExtension = fileName.substring(fileName.lastIndexOf("."));
				String fileNameWOExtenstion = fileName.substring(0, fileName.lastIndexOf("."));
				String docDir = ResourceBundleUtil.getResourceBundle("DorDir");
				String uploadExcelPath = docDir + "Excel";
				if (!FileUtils.makeDir(uploadExcelPath)) {
					throw new Exception(uploadExcelPath + " 폴더 생성이 실패하였습니다. 관리자에게 문의하세요.");
				}
				UploadExcelVO oUploadExcelVO = new UploadExcelVO();
				oUploadExcelVO.setRndId(oDocFileVO.getRndId());
				oUploadExcelVO.setDisClassDtl(oDocFileVO.getDisClassDtl());
				oUploadExcelVO.setFileClassDtl(oDocFileVO.getFileClassDtl());
				List<UploadExcelVO> oList = new ArrayList<UploadExcelVO>();
				oList = oImagingInfoDAO.selectUploadExcelInfo(oUploadExcelVO);
				if(oList.size() != 0) {
					new File(oList.get(0).getFilePath()).delete();
					oImagingInfoDAO.deleteUploadExcelInfo(oUploadExcelVO);
				}
				File temp = new File(uploadExcelPath + StringUtil.PathSep(fileNameWOExtenstion) + "__"
						+ oDocFileVO.getFileClassDtl() + fileExtension);
				
				file.transferTo(temp);
				
				oUploadExcelVO.setFilePath(temp.getAbsolutePath());
				oUploadExcelVO.setSessionUserId(memberVo.getUserId());
				oImagingInfoDAO.insertUploadExcelInfo(oUploadExcelVO);
				
				targetExcelUpload(session,temp);
			}
			tf = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tf;
	}
	

	public List<TargetVO> selectTargetFollowUpList(TargetVO targetVO){
		return targetDAO.selectTargetFollowUpList(targetVO);
	}

	public int updateTargetList(TargetVO targetVO) {
		return targetDAO.updateTargetList(targetVO);
	}
	
	public int updateNextVisitDate(TargetVO targetVO) {
		return targetDAO.updateNextVisitDate(targetVO);
	}

	@Override
	public int updateTargetRemarks(TargetVO targetVO) {
		return targetDAO.updateTargetRemarks(targetVO);
	}

	@Override
	public List<TargetVO> selectTargetCntMax(TargetVO targetVO) {
		return targetDAO.selectTargetCntMax(targetVO);
	}

	@Override
	public int selectPerformCntMax(TargetVO targetVO) {
		return targetDAO.selectPerformCntMax(targetVO);
	}

	@Override
	public int deletePerformTerm(PerformTermVO tvo, HttpSession session) {
		MemberVO memberVO = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		String rndId = memberVO.getRndId();
		
		tvo.setRndId(rndId);
		
//		int result = commonDAO.deletePerformTerm(tvo);
		
		return commonDAO.deletePerformTerm(tvo);
		
	}

	@Override
	public int updateRemarksDataDtl(TargetVO targetVO) {
		return targetDAO.updateRemarksDataDtl(targetVO);
		
	}
}
