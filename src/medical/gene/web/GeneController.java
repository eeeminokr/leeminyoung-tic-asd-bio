package medical.gene.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import medical.common.service.CommonService;
import medical.framework.file.ExcelFile;
import medical.framework.util.JsonUtils;
import medical.gene.service.GeneService;
import medical.gene.service.GeneTotalVO;
import medical.gene.service.GeneVO;
import medical.gene.service.TAnalGenVO;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.ImagingInfoService;

@Controller
public class GeneController {
	
	/** Service Class */
	@Resource(name="GeneService")
	private GeneService geneService;
	
	@Resource(name="ImagingInfoService")
	private ImagingInfoService oImagingInfoService;
	
	@Resource(name="CommonService")
	private CommonService commonService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/medical/gene/selectGeneList.do")
	public ModelAndView selectGeneList(HttpSession session, @ModelAttribute("GeneVO") GeneVO geneVO
	 ,@ModelAttribute("GeneTotalVO") GeneTotalVO geneTotalVO, ModelMap model) throws Exception { 
		
		String docNm = geneVO.getDocNm(); 
		List resultList = new ArrayList<>();
		int totalCount = 0;
		String disClassDtl = geneVO.getDisClassDtl();
		
		//리스트 조회
		
		if("유전자정보".equals(docNm)) {
			List<TAnalGenVO> genList = geneService.selectTAnalGenList(geneVO);
			totalCount = geneService.selectTAnalGenListTotal(geneVO);
			resultList = genList;
		}else if("Total".equals(docNm)) {
			List<GeneTotalVO> totalList = geneService.selectGeneTotalList(geneTotalVO);
			totalCount = geneService.selectGeneTotalListTotal(geneTotalVO);
			resultList = totalList;
		}
		
		
		model.put("success", true);
		model.put("result", resultList);
		model.put("total", totalCount);
		return new ModelAndView("jsonView", model);
	}
	
	
	@RequestMapping("/medical/gene/selectGeneMenuList.do")
	public ModelAndView selectAnalysisTabList(HttpSession session, @ModelAttribute("GeneVO")GeneVO geneVO
			, ModelMap model) throws Exception {
		
		List<GeneVO> tabList = geneService.selectGeneMenuList(geneVO);
		model.put("success", true);
		model.put("result", tabList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/gene/geneFileUpload.do")
	public ModelAndView GeneFileUpload(@RequestParam("uploadZipFile") MultipartFile uploadZipFile,
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
				euTf = geneService.GeneFileUpload(session, excelUploadFile, request, oDocFileVO);
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
	
	
	@RequestMapping("/medical/gene/geneExcelList.do")
	public ModelAndView GeneList(@ModelAttribute("GeneVO")GeneVO geneVO, 
	@ModelAttribute("geneTotalVO")GeneTotalVO geneTotalVO) throws Exception {
		
		  ExcelFile excelFile = null;
		  String docId = geneVO.getDocId();
		  String disClassDtl = geneVO.getDisClassDtl();
		  
		  String targetIds = geneVO.getTargetIds();
		  String performCnts = geneVO.getPerformCnts();
		  String[] targetIdList = null;
		  String[] performCntList = null;
		  String[] targetIdList2 = null;
		  String[] performCntList2 = null;
		  List<GeneVO> geneVOList = new ArrayList<GeneVO>();
		  List<GeneTotalVO> geneTotalVOList = new ArrayList<GeneTotalVO>();
		  GeneVO oGeneVO = null;
		  GeneTotalVO tGeneVO;
		  
		  if(targetIds != null && performCnts !=null) {
		      targetIdList = targetIds.split("\\|");
		  performCntList = performCnts.split("\\|");
		  
		      targetIdList2 = targetIds.split("\\|");
		  performCntList2 = performCnts.split("\\|");
		      
		      for(int i = 0 ; i < targetIdList.length ; i++) {
		    	  oGeneVO  = new GeneVO();
		          oGeneVO.setTargetId(targetIdList[i]);
		          oGeneVO.setPerformCnt(performCntList[i]);
		          oGeneVO.setDisClassDtl(disClassDtl);
		          oGeneVO.setLimit(60000);
		          geneVOList.add(oGeneVO);
		      }
		      for(int i = 0 ; i < targetIdList2.length ; i++) {
		    	  tGeneVO  = new GeneTotalVO();
		          tGeneVO.setTargetId(targetIdList2[i]);
		          tGeneVO.setPerformCnt(performCntList2[i]);
		          tGeneVO.setDisClassDtl(disClassDtl);
		          tGeneVO.setLimit(60000);
		          geneTotalVOList.add(tGeneVO);
		      }
		  }
		  
		  
		  if("Total".equals(docId)){
			geneTotalVO.setStart(0);
			geneTotalVO.setLimit(60000);
			 excelFile = geneService.GeneTotalExcelList(geneTotalVO, geneTotalVOList);
		  }else if("유전자정보".equals(docId)) {
			 geneVO.setStart(0);
			 geneVO.setLimit(60000);
			 excelFile = geneService.GeneExcelList(geneVO, geneVOList);
		  }
		  return new ModelAndView("download", "download", excelFile);
	}
	
	
	@RequestMapping("/medical/gene/deleteGene.do")
	public ModelAndView deleteGene(@ModelAttribute("GeneVO")GeneVO geneVO ,ModelMap model
					,HttpServletRequest request, HttpSession session)throws Exception {

		String[] targetIdList = request.getParameterValues("targetIdList");
		String[] performCntList = request.getParameterValues("performCntList");
		String[] performNmList = request.getParameterValues("performNmList");
		String docNm = geneVO.getDocNm();
		String rndId = commonService.selectRndId();
		String disClassDtl = (String)session.getAttribute("disClassDtl");
		
		for(int i=0; i<targetIdList.length; i++) {
			geneVO.setTargetId(targetIdList[i]);
			geneVO.setPerformCnt(performCntList[i]);
			geneVO.setPerformCntNm(performNmList[i]);
			geneVO.setRndId(rndId);
			geneVO.setDisClassDtl(disClassDtl);
			
			
			if("유전자정보".equals(docNm)) {
				geneService.deleteGene(geneVO);
			}else if("Total".equals(docNm)) {
				geneService.deleteGene(geneVO);
				
			}
		}
		
		model.put("success",true);
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/gene/selectGenePage.do")
	public ModelAndView selectGenePage(HttpSession session, @ModelAttribute("GeneVO")GeneVO geneVO
			, ModelMap model) throws Exception {
		
		String docNm = geneVO.getDocNm();
		String schKeyWord = geneVO.getSchKeyWord();
		int totalCount = 0;
		
		if("schTargetId".equals(schKeyWord)) {
			int rownum = 0;
			int pageSize = geneVO.getLimit();
			int pageNum,rNum;
			//해당 탭의 TargetID 위치로 이동
			if("유전자정보".equals(docNm)) {
				List<TAnalGenVO> genList = geneService.selectTAnalGenList(geneVO);
				rownum = genList.get(0).getRownum();
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
	
}
