package medical.dataIntegration.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import medical.dataIntegration.service.DataIntegrationListVO;
import medical.dataIntegration.service.DataIntegrationService;
import medical.dataIntegration.service.DataIntegrationVO;
import medical.framework.file.ExcelFile;
import medical.framework.util.JsonUtils;
import medical.imagingInfo.service.UploadExcelVO;
import medical.neuropsy.service.NeuropsyVO;
import medical.survey.service.SurveyTotalVO;
import medical.survey.service.SurveyVO;

@Controller
public class DataIntegrationController {
	@Resource(name = "DataIntegrationService")
	private DataIntegrationService dataIntegrationService;
	
	@RequestMapping("/medical/dataIntegration/selectTicDocDtlList.do")
	public ModelAndView selectTicDocDtlList(HttpSession session, @ModelAttribute("dataIntegrationVO") DataIntegrationVO dataIntegrationVO,
			ModelMap model) throws Exception {
		List<DataIntegrationVO> result =  dataIntegrationService.selectTicDocDtlList(dataIntegrationVO);
		model.put("success",true);
		model.put("result",result);
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/dataIntegration/selectTicDocDtl.do")
	public ModelAndView selectTicDocDtl(HttpSession session, @ModelAttribute("dataIntegrationVO") DataIntegrationVO dataIntegrationVO,
			ModelMap model) throws Exception {
		List<DataIntegrationVO> result =  dataIntegrationService.selectTicDocDtl(dataIntegrationVO);
		model.put("success",true);
		model.put("result",result);
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/dataIntegration/selectDataIntegrationList.do")
	public ModelAndView selectDataIntegrationList(HttpSession session, @ModelAttribute("dataIntegrationListVO") 
	DataIntegrationListVO dataIntegrationListVO, ModelMap model) {
		List<DataIntegrationListVO> dataIntegrationList = dataIntegrationService.selectDataIntegrationList(dataIntegrationListVO);
		int totalCount = dataIntegrationService.selectDataIntegrationListTotal(dataIntegrationListVO);
		model.put("success",true);
		model.put("result", dataIntegrationList);
		model.put("total", totalCount);
		return new ModelAndView("jsonView", model);
		
		
	}
	
	@RequestMapping("/medical/dataIntegration/dataIntgrationListSelectExcelDownload.do")
	public ModelAndView dataIntegrationListExcelList(HttpServletRequest request, @ModelAttribute("DataIntegrationListVO")
	DataIntegrationListVO dataIntegrationListVO) throws Exception {
		
		String[] targetIdList = request.getParameterValues("targetId");
		
		String schKeyWord = "";
		DataIntegrationListVO vo = new DataIntegrationListVO();
		
		for(int i=0; i < targetIdList.length; i++) {
			schKeyWord += "('"+targetIdList[i]+"')";
			if((i+1)!=targetIdList.length) schKeyWord += ",";
			
		}
		vo.setDisClassDtl(dataIntegrationListVO.getDisClassDtl());
		vo.setSchKeyField("selectDown");
		vo.setSchKeyWord(schKeyWord);
		
		ExcelFile excelFile = dataIntegrationService.dataIntegrationListExcelList(vo);
		
		return new ModelAndView("download", "download", excelFile);
	}
	
	@RequestMapping("/medical/dataIntegration/dataIntgrationListExcelDownload.do")
	public ModelAndView dataIntegrationListExcelList(@ModelAttribute("DataIntegrationListVO")
	DataIntegrationListVO dataIntegrationListVO) throws Exception {
		
		ExcelFile excelFile = dataIntegrationService.dataIntegrationListExcelList(dataIntegrationListVO);
		
		return new ModelAndView("download", "download", excelFile);
	}
	
	@RequestMapping("/medical/dataIntegration/selectDataIntegrationDtlList.do")
	public ModelAndView selectDataIntegrationDtlList(HttpSession session, @ModelAttribute("dataIntegrationListVO") 
	DataIntegrationListVO dataIntegrationListVO, ModelMap model) {
		List<DataIntegrationListVO> dataIntegrationList = dataIntegrationService.selectDataIntegrationDtlList(dataIntegrationListVO);
		model.put("success",true);
		model.put("result", dataIntegrationList);
		return new ModelAndView("jsonView", model);
	}
	
	//파일 다운로드
	@RequestMapping("/medical/dataIntegration/dataIntegrationDtlPDFDownload.do")
	public ModelAndView dataIntegrationDtlPDFDownload(@ModelAttribute("dataIntegrationListVO") DataIntegrationListVO dataIntegrationListVO
						, HttpServletRequest request, HttpServletResponse response)
	throws Exception {
	
	 String downFile = request.getParameter("downFile");
	 
	 downFile = downFile.replace("c:", "").toString();
	 File file2 = new File("",downFile);
	 BufferedInputStream in = new BufferedInputStream(new FileInputStream(file2));
	 String fileName = file2.getName();
	 if(downFile != null) {
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
		return new ModelAndView("download", "download", downFile);
	}
}
