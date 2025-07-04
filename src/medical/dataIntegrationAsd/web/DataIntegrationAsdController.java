package medical.dataIntegrationAsd.web;

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

import medical.dataIntegrationAsd.service.DataIntegrationAsdListVO;
import medical.dataIntegrationAsd.service.DataIntegrationAsdService;
import medical.dataIntegrationAsd.service.DataIntegrationAsdVO;
import medical.framework.file.ExcelFile;
import medical.framework.util.JsonUtils;

@Controller
public class DataIntegrationAsdController {
	@Resource(name = "DataIntegrationAsdService")
	private DataIntegrationAsdService dataIntegrationAsdService;
	
	@RequestMapping("/medical/dataIntegrationAsd/selectDataIntegrationListAo.do")
	public ModelAndView selectDataIntegrationListAo(HttpSession session, @ModelAttribute("dataIntegrationAsdListVO") 
	DataIntegrationAsdListVO dataIntegrationAsdListVO, ModelMap model) {
		List<DataIntegrationAsdListVO> dataIntegrationAsdList = dataIntegrationAsdService.selectDataIntegrationListAo(dataIntegrationAsdListVO);
		int totalCount = dataIntegrationAsdService.selectDataIntegrationListAoTotal(dataIntegrationAsdListVO);
		model.put("success",true);
		model.put("result", dataIntegrationAsdList);
		model.put("total", totalCount);
		return new ModelAndView("jsonView", model);
		
	}
	
	@RequestMapping("/medical/dataIntegrationAsd/selectTicDocDtlList.do")
	public ModelAndView selectTicDocDtlList(HttpSession session, @ModelAttribute("dataIntegrationAsdVO") DataIntegrationAsdVO dataIntegrationAsdVO,
			ModelMap model) throws Exception {
		List<DataIntegrationAsdVO> result =  dataIntegrationAsdService.selectTicDocDtlList(dataIntegrationAsdVO);
		
		System.out.println("selectTicDocDtlList----S");
		
		String docClassDtl = dataIntegrationAsdVO.getDocClassDtl();
		String disClassDtl = dataIntegrationAsdVO.getDisClassDtl();
		
		System.out.println("dosClassDtl(selectTicDocDtlList.do)---->:"+docClassDtl);
		System.out.println("disClassDtl---->:"+disClassDtl);
		System.out.println("selectTicDocDtlList----E");
		
		model.put("success",true);
		model.put("result",result);
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/dataIntegrationAsd/selectTicDocDtl.do")
	public ModelAndView selectTicDocDtl(HttpSession session, @ModelAttribute("dataIntegrationAsdVO") DataIntegrationAsdVO dataIntegrationAsdVO,
			ModelMap model) throws Exception {
		List<DataIntegrationAsdVO> result =  dataIntegrationAsdService.selectTicDocDtl(dataIntegrationAsdVO);
		
		System.out.println("selectTicDocDtl----S");
		
		String docClassDtl = dataIntegrationAsdVO.getDocClassDtl();
		String disClassDtl = dataIntegrationAsdVO.getDisClassDtl();
		System.out.println("dosClassDtl(selectTicDocDtl.do)---->:"+docClassDtl);
		System.out.println("disClassDtl---->:"+disClassDtl);
		System.out.println("selectTicDocDtl----E");
		
		model.put("success",true);
		model.put("result",result);
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/dataIntegrationAsd/selectDataIntegrationDtlListAo.do")
	public ModelAndView selectDataIntegrationDtlList(HttpSession session, @ModelAttribute("dataIntegrationAsdListVO") 
	DataIntegrationAsdListVO dataIntegrationAsdListVO, ModelMap model) {
		List<DataIntegrationAsdListVO> dataIntegrationList = dataIntegrationAsdService.selectDataIntegrationDtlListAo(dataIntegrationAsdListVO);
		
		System.out.println("");
		model.put("success",true);
		model.put("result", dataIntegrationList);
		return new ModelAndView("jsonView", model);
	}

	
	@RequestMapping("/medical/dataIntegrationAsd/dataIntgrationListSelectExcelDownload.do")
	public ModelAndView dataIntegrationListExcelList(HttpServletRequest request, @ModelAttribute("DataIntegrationAsdListVO")
	DataIntegrationAsdListVO dataIntegrationAsdListVO) throws Exception {
		
		String[] targetIdList = request.getParameterValues("targetId");
		
		String schKeyWord = "";
		DataIntegrationAsdListVO vo = new DataIntegrationAsdListVO();
		
		for(int i=0; i < targetIdList.length; i++) {
			schKeyWord += "('"+targetIdList[i]+"')";
			if((i+1)!=targetIdList.length) schKeyWord += ",";
			
		}
		vo.setDisClassDtl(dataIntegrationAsdListVO.getDisClassDtl());
		vo.setSchKeyField("selectDown");
		vo.setSchKeyWord(schKeyWord);
		
		ExcelFile excelFile = dataIntegrationAsdService.dataIntegrationAsdListExcelList(vo);
		
		return new ModelAndView("download", "download", excelFile);
	}
	
	@RequestMapping("/medical/dataIntegrationAsd/dataIntgrationListExcelDownload.do")
	public ModelAndView dataIntegrationAsdListExcelList(@ModelAttribute("DataIntegrationAsdListVO")
	DataIntegrationAsdListVO dataIntegrationAsdListVO) throws Exception {
		
		ExcelFile excelFile = dataIntegrationAsdService.dataIntegrationAsdListExcelList(dataIntegrationAsdListVO);
		
		return new ModelAndView("download", "download", excelFile);
	}

	
	//파일 다운로드
	@RequestMapping("/medical/dataIntegrationAsd/dataIntegrationDtlPDFDownload.do")
	public ModelAndView dataIntegrationDtlPDFDownload(@ModelAttribute("dataIntegrationAsdListVO") DataIntegrationAsdListVO dataIntegrationAsdListVO
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
