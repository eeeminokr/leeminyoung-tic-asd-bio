package medical.neuropsy.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import medical.common.service.CommonService;
import medical.framework.file.ExcelFile;
import medical.framework.util.JsonUtils;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.ImagingInfoService;
import medical.imagingInfo.service.UploadExcelVO;
import medical.neuropsy.service.NeuropsyAdos1VO;
import medical.neuropsy.service.NeuropsyAdos2VO;
import medical.neuropsy.service.NeuropsyAdos3VO;
import medical.neuropsy.service.NeuropsyAtaVO;
import medical.neuropsy.service.NeuropsyCarsVO;
import medical.neuropsy.service.NeuropsyCatVO;
import medical.neuropsy.service.NeuropsyCcttVO;
import medical.neuropsy.service.NeuropsyCptVO;
import medical.neuropsy.service.NeuropsyExitiiVO;
import medical.neuropsy.service.NeuropsyPepVO;
import medical.neuropsy.service.NeuropsyS1VO;
import medical.neuropsy.service.NeuropsyService;
import medical.neuropsy.service.NeuropsySmsVO;
import medical.neuropsy.service.NeuropsyStroopVO;
import medical.neuropsy.service.NeuropsyTmtVO;
import medical.neuropsy.service.NeuropsyTotalVO;
import medical.neuropsy.service.NeuropsyVO;
import medical.neuropsy.service.NeuropsyWsctVO;

@Controller
public class NeuropsyController {
	
	@Resource(name = "ImagingInfoService")
	private ImagingInfoService oImagingInfoService;
	
	/** Sevice Class */
	@Resource(name = "NeuropsyService")
	private NeuropsyService neuropsyService;
	@Resource(name = "CommonService")
	private CommonService commonService;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping("/medical/neuropsy/selectNeuropsyMenuList.do")
	public ModelAndView selectNeuropsyTabList(HttpSession session, @ModelAttribute("NeuropsyVO")NeuropsyVO neuropsyVO
			, ModelMap model) throws Exception {
		
		List<NeuropsyVO> tabList = neuropsyService.selectNeuropsyMenuList(neuropsyVO);
		model.put("success", true);
		model.put("result", tabList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/neuropsy/selectNeuropsyPage.do")
	public ModelAndView selectNeuropsyPage(HttpSession session, @ModelAttribute("NeuropsyVO")NeuropsyVO neuropsyVO
			, ModelMap model) throws Exception {
		
		String docNm = neuropsyVO.getDocNm();
		String schKeyWord = neuropsyVO.getSchKeyWord();
		int totalCount = 0;
		
		if("schTargetId".equals(schKeyWord)) {
			int rownum = 0;
			int pageSize = neuropsyVO.getLimit();
			int pageNum,rNum;
			//해당 탭의 TargetID 위치로 이동
			System.out.println(docNm+": 심리검사docNm page.do");
			//TargetID 조회
			if("K-SADS".equals(docNm)) {
				List<NeuropsyS1VO> s1List = neuropsyService.selectNeuropsyS1RowList(neuropsyVO);
				rownum = s1List.get(0).getRownum();
			}else if("ATA".equals(docNm)) {
				List<NeuropsyAtaVO> ataList = neuropsyService.selectNeuropsyAtaList(neuropsyVO);
				rownum = ataList.get(0).getRownum();
			}else if("STROOP".equals(docNm)) {
				List<NeuropsyStroopVO> stroopList = neuropsyService.selectNeuropsyStroopList(neuropsyVO);
				rownum = stroopList.get(0).getRownum();
			}else if("CCTT".equals(docNm)) {
				List<NeuropsyCcttVO> ccttList = neuropsyService.selectNeuropsyCcttList(neuropsyVO);
				rownum = ccttList.get(0).getRownum();
			}else if("WCST".equals(docNm)) {
				List<NeuropsyWsctVO> wsctList = neuropsyService.selectNeuropsyWsctList(neuropsyVO);
				rownum = wsctList.get(0).getRownum();
			}else if("CAT".equals(docNm)) {
				List<NeuropsyCatVO> catList = neuropsyService.selectNeuropsyCatList(neuropsyVO);
				rownum = catList.get(0).getRownum();
			}else if("EXIT-II".equals(docNm)) {
				List<NeuropsyExitiiVO> exitiiList = neuropsyService.selectNeuropsyExitiiList(neuropsyVO);
				rownum = exitiiList.get(0).getRownum();
			}else if("CPT-3".equals(docNm)) {
				List<NeuropsyCptVO> cptList = neuropsyService.selectNeuropsyCptList(neuropsyVO);
				rownum = cptList.get(0).getRownum();
			}else if("TMT".equals(docNm)) {
				List<NeuropsyTmtVO> tmtList = neuropsyService.selectNeuropsyTmtList(neuropsyVO);
				rownum = tmtList.get(0).getRownum();
			}else if("PEP-R".equals(docNm)) {
				List<NeuropsyPepVO> pepList = neuropsyService.selectNeuropsyPepList(neuropsyVO);
				rownum = pepList.get(0).getRownum();
			}else if("ADOS".equals(docNm)) {
				List<NeuropsyAdos1VO> ados1List = neuropsyService.selectNeuropsyAdos1List(neuropsyVO);
				rownum = ados1List.get(0).getRownum();
			}else if("ADOS-2".equals(docNm)) {
				List<NeuropsyAdos2VO> ados2List = neuropsyService.selectNeuropsyAdos2List(neuropsyVO);
				rownum = ados2List.get(0).getRownum();
//			}else if("ADOS3".equals(docNm)) {
//				List<NeuropsyAdos3VO> ados3List = neuropsyService.selectNeuropsyAdos3List(neuropsyVO);
//				rownum = ados3List.get(0).getRownum();
			}else if("SMS".equals(docNm)) {
				List<NeuropsySmsVO> smsList = neuropsyService.selectNeuropsySmsList(neuropsyVO);
				rownum = smsList.get(0).getRownum();
			}else if("CARS".equals(docNm)) {
				List<NeuropsyCarsVO> carsList = neuropsyService.selectNeuropsyCarsList(neuropsyVO);
				rownum = carsList.get(0).getRownum();
			}
			
			//페이지 수 계산
			pageNum = rownum/pageSize;
			if(rownum%pageSize != 0) pageNum += 1;
			rNum = rownum%pageSize;
			model.put("pageNum", pageNum);
			model.put("rNum", rNum);
			
		}

		model.put("success", true);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/neuropsy/selectNeuropsyList.do")
	public ModelAndView selectNeuropsyList(HttpSession session, @ModelAttribute("NeuropsyVO")NeuropsyVO neuropsyVO
			, ModelMap model) throws Exception {
		
		String docNm = neuropsyVO.getDocNm();
		List resultList = new ArrayList();
		int totalCount = 0;
		String disClassDtl = neuropsyVO.getDisClassDtl();
		
		//리스트 조회
		
		//System.out.println(docId+"docId값 !!!");
		System.out.println(docNm+": 심리검사docNm List.do");

		System.out.println(disClassDtl+"심리검사disClassDtl값!!!! List.do");
		
		
		
		if("K-SADS".equals(docNm)) {
			List<NeuropsyS1VO> s1List = null;
			if("DS001".equals(disClassDtl)) {
				s1List = neuropsyService.selectNeuropsyS1List(neuropsyVO);
				totalCount = neuropsyService.selectNeuropsyS1ListTotal(neuropsyVO); 
			}else {
				s1List = neuropsyService.selectNeuropsyS1AsdList(neuropsyVO);
				totalCount = neuropsyService.selectNeuropsyS1AsdListTotal(neuropsyVO); 
			}
			resultList = s1List;
		}else if("ATA".equals(docNm)) {
			List<NeuropsyAtaVO> ataList = neuropsyService.selectNeuropsyAtaList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyAtaListTotal(neuropsyVO); 
			resultList = ataList;
		}else if("STROOP".equals(docNm)) {
			List<NeuropsyStroopVO> stroopList = neuropsyService.selectNeuropsyStroopList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyStroopListTotal(neuropsyVO); 
			resultList = stroopList;
		}else if("CCTT".equals(docNm)) {
			List<NeuropsyCcttVO> ccttList = neuropsyService.selectNeuropsyCcttList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyCcttListTotal(neuropsyVO); 
			resultList = ccttList;
		}else if("WCST".equals(docNm)) {
			List<NeuropsyWsctVO> wsctList = neuropsyService.selectNeuropsyWsctList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyWsctListTotal(neuropsyVO); 
			resultList = wsctList;
		}else if("CAT".equals(docNm)) {
			List<NeuropsyCatVO> catList = neuropsyService.selectNeuropsyCatList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyCatListTotal(neuropsyVO); 
			resultList = catList;
		}else if("EXIT-II".equals(docNm)) {
			List<NeuropsyExitiiVO> exitiiList = neuropsyService.selectNeuropsyExitiiList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyExitiiListTotal(neuropsyVO); 
			resultList = exitiiList;
		}else if("CPT-3".equals(docNm)) {
			List<NeuropsyCptVO> cptList = neuropsyService.selectNeuropsyCptList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyCptListTotal(neuropsyVO); 
			resultList = cptList;
		}else if("TMT".equals(docNm)) {
			List<NeuropsyTmtVO> tmtList = neuropsyService.selectNeuropsyTmtList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyTmtListTotal(neuropsyVO); 
			resultList = tmtList;
		}else if("Total".equals(docNm)) {
			List<NeuropsyTotalVO> totalList = neuropsyService.selectNeuropsyTotalList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyTotalListTotal(neuropsyVO); 
			resultList = totalList;
		}else if("PEP-R".equals(docNm)) {
			List<NeuropsyPepVO> pepList = neuropsyService.selectNeuropsyPepList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyPepListTotal(neuropsyVO); 
			resultList = pepList;
		}else if("ADOS".equals(docNm)) {
			List<NeuropsyAdos1VO> ados1List = neuropsyService.selectNeuropsyAdos1List(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyAdos1ListTotal(neuropsyVO); 
			resultList = ados1List;
		}else if("ADOS-2".equals(docNm)) {
			List<NeuropsyAdos2VO> ados2List = neuropsyService.selectNeuropsyAdos2List(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyAdos2ListTotal(neuropsyVO); 
			resultList = ados2List;
//		}else if("ADOS3".equals(docNm)) {
//			List<NeuropsyAdos3VO> ados3List = neuropsyService.selectNeuropsyAdos3List(neuropsyVO);
//			totalCount = neuropsyService.selectNeuropsyAdos3ListTotal(neuropsyVO); 
//			resultList = ados3List;
		}else if("SMS".equals(docNm)) {
			List<NeuropsySmsVO> smsList = neuropsyService.selectNeuropsySmsList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsySmsListTotal(neuropsyVO); 
			resultList = smsList;
		}else if("CARS".equals(docNm)) {
			List<NeuropsyCarsVO> carsList = neuropsyService.selectNeuropsyCarsList(neuropsyVO);
			totalCount = neuropsyService.selectNeuropsyCarsListTotal(neuropsyVO); 
			resultList = carsList;
		}

		model.put("success", true);
		model.put("result", resultList);
		model.put("total", totalCount);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/neuropsy/neuropsyExcelDownload.do")
	public ModelAndView neuropsyExcelDownload(@ModelAttribute("NeuropsyVO")NeuropsyVO neuropsyVO)
			throws Exception {
		ExcelFile excelFile = null;
		String docNm = neuropsyVO.getDocNm();
		String disClassDtl = neuropsyVO.getDisClassDtl();
		
		if("DS001".equals(disClassDtl)) {
			if("K-SADS".equals(docNm)) {
				excelFile = neuropsyService.neuropsyS1ExcelDownload(neuropsyVO);
			}else if("ATA".equals(docNm)) {
				excelFile = neuropsyService.neuropsyAtaExcelDownload(neuropsyVO);
			}else if("STROOP".equals(docNm)) {
				excelFile = neuropsyService.neuropsyStroopExcelDownload(neuropsyVO);
			}else if("CCTT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCcttExcelDownload(neuropsyVO);
			}else if("WCST".equals(docNm)) {
				excelFile = neuropsyService.neuropsyWsctExcelDownload(neuropsyVO);
			}else if("CAT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCatExcelDownload(neuropsyVO);
			}else if("EXIT-II".equals(docNm)) {
				excelFile = neuropsyService.neuropsyExitiiExcelDownload(neuropsyVO);
			}else if("CPT-3".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCptExcelDownload(neuropsyVO);
			}else if("TMT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyTmtExcelDownload(neuropsyVO);
			}else if("Total".equals(docNm)) {
				excelFile = neuropsyService.neuropsyTotalExcelDownload(neuropsyVO);
			}
		}else {
			if("K-SADS".equals(docNm)) {
				excelFile = neuropsyService.neuropsyS1ExcelDownload2(neuropsyVO);
			}else if("ATA".equals(docNm)) {
				excelFile = neuropsyService.neuropsyAtaExcelDownload2(neuropsyVO);
			}else if("STROOP".equals(docNm)) {
				excelFile = neuropsyService.neuropsyStroopExcelDownload2(neuropsyVO);
			}else if("CCTT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCcttExcelDownload2(neuropsyVO);
			}else if("WCST".equals(docNm)) {
				excelFile = neuropsyService.neuropsyWsctExcelDownload2(neuropsyVO);
			}else if("CAT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCatExcelDownload2(neuropsyVO);
			}else if("EXIT-II".equals(docNm)) {
				excelFile = neuropsyService.neuropsyExitiiExcelDownload2(neuropsyVO);
			}else if("CPT-3".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCptExcelDownload2(neuropsyVO);
			}else if("TMT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyTmtExcelDownload2(neuropsyVO);
			}else if("Total".equals(docNm)) {
				excelFile = neuropsyService.neuropsyTotalExcelDownload2(neuropsyVO);
			}else if("ADOS1".equals(docNm)) {
				excelFile = neuropsyService.neuropsyAdos1ExcelDownload(neuropsyVO);
			}else if("ADOS2".equals(docNm)) {
				excelFile = neuropsyService.neuropsyAdos2ExcelDownload(neuropsyVO);
//			}else if("ADOS3".equals(docNm)) {
//				excelFile = neuropsyService.neuropsyAdos3ExcelDownload(neuropsyVO);
			}else if("PEP".equals(docNm)) {
				excelFile = neuropsyService.neuropsyPepExcelDownload(neuropsyVO);
			}else if("SMS".equals(docNm)) {
				excelFile = neuropsyService.neuropsySmsExcelDownload(neuropsyVO);
			}else if("CARS".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCarsExcelDownload(neuropsyVO);
			}
		}
		
		
		return new ModelAndView("download", "download", excelFile);
	}
	
	@RequestMapping("/medical/neuropsy/neuropsySelectExcelDownload.do")
	public ModelAndView neuropsySelectExcelDownload(HttpServletRequest request, @ModelAttribute("NeuropsyVO")NeuropsyVO neuropsyVO)
			throws Exception {
		ExcelFile excelFile = null;
		String[] targetIdList = request.getParameterValues("targetId");
		String[] performCntList = request.getParameterValues("performCnt");
		String rndId = neuropsyVO.getRndId();
		String docNm = neuropsyVO.getDocNm();
		String disClassDtl = neuropsyVO.getDisClassDtl();
		
		String schKeyWord = "";
		NeuropsyVO vo = new NeuropsyVO();
		vo.setRndId(rndId);
		for(int i=0; i < targetIdList.length; i++) {
			schKeyWord += "('"+targetIdList[i]+"','"+performCntList[i]+"','"+rndId+"','"+disClassDtl+"')";
			if((i+1)!=targetIdList.length) schKeyWord += ",";
			
		}
		vo.setSchKeyField("selectDown");
		vo.setSchKeyWord(schKeyWord);
		vo.setLimit(60000);
		
		
		if("DS001".equals(disClassDtl)) {
			if("K-SADS".equals(docNm)) {
				excelFile = neuropsyService.neuropsyS1ExcelDownload(neuropsyVO);
			}else if("ATA".equals(docNm)) {
				excelFile = neuropsyService.neuropsyAtaExcelDownload(neuropsyVO);
			}else if("STROOP".equals(docNm)) {
				excelFile = neuropsyService.neuropsyStroopExcelDownload(neuropsyVO);
			}else if("CCTT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCcttExcelDownload(neuropsyVO);
			}else if("WCST".equals(docNm)) {
				excelFile = neuropsyService.neuropsyWsctExcelDownload(neuropsyVO);
			}else if("CAT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCatExcelDownload(neuropsyVO);
			}else if("EXIT-II".equals(docNm)) {
				excelFile = neuropsyService.neuropsyExitiiExcelDownload(neuropsyVO);
			}else if("CPT-3".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCptExcelDownload(neuropsyVO);
			}else if("TMT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyTmtExcelDownload(neuropsyVO);
			}else if("Total".equals(docNm)) {
				excelFile = neuropsyService.neuropsyTotalExcelDownload(neuropsyVO);
			}
		}else {
			if("K-SADS".equals(docNm)) {
				excelFile = neuropsyService.neuropsyS1ExcelDownload2(neuropsyVO);
			}else if("ATA".equals(docNm)) {
				excelFile = neuropsyService.neuropsyAtaExcelDownload2(neuropsyVO);
			}else if("STROOP".equals(docNm)) {
				excelFile = neuropsyService.neuropsyStroopExcelDownload2(neuropsyVO);
			}else if("CCTT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCcttExcelDownload2(neuropsyVO);
			}else if("WCST".equals(docNm)) {
				excelFile = neuropsyService.neuropsyWsctExcelDownload2(neuropsyVO);
			}else if("CAT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCatExcelDownload2(neuropsyVO);
			}else if("EXIT-II".equals(docNm)) {
				excelFile = neuropsyService.neuropsyExitiiExcelDownload2(neuropsyVO);
			}else if("CPT-3".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCptExcelDownload2(neuropsyVO);
			}else if("TMT".equals(docNm)) {
				excelFile = neuropsyService.neuropsyTmtExcelDownload2(neuropsyVO);
			}else if("Total".equals(docNm)) {
				excelFile = neuropsyService.neuropsyTotalExcelDownload2(neuropsyVO);
			}else if("ADOS1".equals(docNm)) {
				excelFile = neuropsyService.neuropsyAdos1ExcelDownload(neuropsyVO);
			}else if("ADOS2".equals(docNm)) {
				excelFile = neuropsyService.neuropsyAdos2ExcelDownload(neuropsyVO);
//			}else if("ADOS3".equals(docNm)) {
//				excelFile = neuropsyService.neuropsyAdos3ExcelDownload(neuropsyVO);
			}else if("PEP".equals(docNm)) {
				excelFile = neuropsyService.neuropsyPepExcelDownload(neuropsyVO);
			}else if("SMS".equals(docNm)) {
				excelFile = neuropsyService.neuropsySmsExcelDownload(neuropsyVO);
			}else if("CARS".equals(docNm)) {
				excelFile = neuropsyService.neuropsyCarsExcelDownload(neuropsyVO);
			}
		}
		
		return new ModelAndView("download", "download", excelFile);
	}
	
	//업로드 엑셀 다운로드
	@RequestMapping("/medical/neuropsy/neuropsyUploadExcelDownload.do")
	public ModelAndView neuropsyUploadExcelDownload(@ModelAttribute("UploadExcelVO")UploadExcelVO uploadExcelVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	 List<UploadExcelVO> uploadDownd = oImagingInfoService.selectUploadExcelInfo(uploadExcelVO);
	 String uploadDownload = uploadDownd.get(0).getFilePath();
	 uploadDownload = uploadDownload.replace("c:", "").toString();
	 
	 File file2 = new File("",uploadDownload);
	 BufferedInputStream in = new BufferedInputStream(new FileInputStream(file2));
	 String fileName = file2.getName();
	 if(uploadDownd != null) {
		 	//형식을 모르는 파일첨부용 contentType
		    response.setContentType("application/octet-stream");
		    //다운로드와 다운로드될 파일이름
		    response.setHeader("Content-Disposition", "attachment; filename=\""+ java.net.URLEncoder.encode(fileName, "utf-8") + "\"");
		    //파일복사
		    FileCopyUtils.copy(in, response.getOutputStream());
		    in.close();
		    response.getOutputStream().flush();
		    response.getOutputStream().close();
		 
	 }else {
		 throw new Exception("업로드 파일이 없습니다. 관리자에게 문의하세요.");
	 }
		return new ModelAndView("download", "download", uploadDownload);
	}
	
	@RequestMapping("/medical/neuropsy/neuropsyFileUpload.do")
	public ModelAndView neuropsyFileUpload(@RequestParam("uploadZipFile") MultipartFile uploadZipFile,
			@RequestParam("excelUploadFile") MultipartFile excelUploadFile,
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("DocFileVO") DocFileVO oDocFileVO) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		boolean uzTf =false;
		boolean euTf =false;
		List<String> oList = new ArrayList<String>();
		try {
			if (uploadZipFile != null && uploadZipFile.getSize() > 0) {
				uzTf = oImagingInfoService.targetPdfUpload(session, uploadZipFile, oDocFileVO);
				oList.add("uzTf");
			}
			if (excelUploadFile != null && excelUploadFile.getSize() > 0) {
				euTf = neuropsyService.neuropsyFileUpload(session, excelUploadFile, request, oDocFileVO);
				oList.add("euTf");
			}
			if(oList.size() > 0) {
				if(oList.size()==1) {
					if(oList.contains("uzTf") && uzTf)modelMap.put("success", true);
					else if(oList.contains("euTf") && euTf)modelMap.put("success", true);
					else modelMap.put("success", false);
				}else {
					if(uzTf && euTf)modelMap.put("success", true);
					else modelMap.put("success", false);
				}
			}else modelMap.put("success", false);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", e.getMessage());
			e.printStackTrace();
		}
		return new ModelAndView("jsonView", modelMap);
	}
	
	@RequestMapping("/medical/neuropsy/deleteNeuropsy.do")
	public ModelAndView deleteNeuropsy(@ModelAttribute("NeuropsyVO")NeuropsyVO neuropsyVO ,ModelMap model
					,HttpServletRequest request, HttpSession session)throws Exception {

		String[] targetIdList = request.getParameterValues("targetIdList");
		String[] performCntList = request.getParameterValues("performCntList");
		String[] performNmList = request.getParameterValues("performNmList");
		String docNm = neuropsyVO.getDocNm();
		String rndId = commonService.selectRndId();
		String disClassDtl = (String)session.getAttribute("disClassDtl");
		
		for(int i=0; i<targetIdList.length; i++) {
			neuropsyVO.setTargetId(targetIdList[i]);
			neuropsyVO.setPerformCnt(performCntList[i]);
			neuropsyVO.setPerformCntNm(performNmList[i]);
			neuropsyVO.setRndId(rndId);
			neuropsyVO.setDisClassDtl(disClassDtl);
			
			if("K-SADS".equals(docNm)) {
				neuropsyService.deleteNeuropsyS1(neuropsyVO);
			}else if("ATA".equals(docNm)) {
				neuropsyService.deleteNeuropsyAta(neuropsyVO);
			}else if("STROOP".equals(docNm)) {
				neuropsyService.deleteNeuropsyStroop(neuropsyVO);
			}else if("CCTT".equals(docNm)) {
				neuropsyService.deleteNeuropsyCctt(neuropsyVO);
			}else if("WCST".equals(docNm)) {
				neuropsyService.deleteNeuropsyWsct(neuropsyVO);
			}else if("CAT".equals(docNm)) {
				neuropsyService.deleteNeuropsyCat(neuropsyVO);
			}else if("EXIT-II".equals(docNm)) {
				neuropsyService.deleteNeuropsyExitii(neuropsyVO);
			}else if("CPT-3".equals(docNm)) {
				neuropsyService.deleteNeuropsyCpt(neuropsyVO);
			}else if("TMT".equals(docNm)) {
				neuropsyService.deleteNeuropsyTmt(neuropsyVO);
			}else if("ADOS1".equals(docNm)) {
				neuropsyService.deleteNeuropsyAdos1(neuropsyVO);
			}else if("ADOS2".equals(docNm)) {
				neuropsyService.deleteNeuropsyAdos2(neuropsyVO);
//			}else if("ADOS3".equals(docNm)) {
//				neuropsyService.deleteNeuropsyAdos3(neuropsyVO);
			}else if("PEP".equals(docNm)) {
				neuropsyService.deleteNeuropsyPep(neuropsyVO);
			}else if("SMS".equals(docNm)) {
				neuropsyService.deleteNeuropsySms(neuropsyVO);
			}else if("CARS".equals(docNm)) {
				neuropsyService.deleteNeuropsyCars(neuropsyVO);
			}else if("Total".equals(docNm)) {
				//전체탭에서 삭제 시 모든 심리검사 데이터 삭제,pdf삭제 추가 
				
				//심리검사 데이터 삭제
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
//				neuropsyService.deleteNeuropsyAdos3(neuropsyVO);
				neuropsyService.deleteNeuropsyPep(neuropsyVO);
				neuropsyService.deleteNeuropsySms(neuropsyVO);
				neuropsyService.deleteNeuropsyCars(neuropsyVO);
				
			}
		}
		
		model.put("success",true);
		return JsonUtils.describe(model);
	}
	
	
}