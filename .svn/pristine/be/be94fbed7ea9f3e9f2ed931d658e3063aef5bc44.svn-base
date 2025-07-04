package medical.target.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.target.service.TargetVO;


public class TargetCellReaderMapper2 implements CellReaderMapper<TargetVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public TargetVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		TargetVO targetVO = new TargetVO();
		try{
			
			targetVO.setDisClassDtl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			String targetId = POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("'","");
			targetVO.setTargetId(targetId);
			targetVO.setTargetOrgId(targetId);
			targetVO.setTargetDisId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'",""));
			String sex = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","");
			if("여".equals(sex)) sex ="F";
			else sex ="M";
			targetVO.setSex(sex);
			String birthYm = POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'","");
			targetVO.setBirthYm(birthYm.replace("-", ""));
		//	targetVO.setProtocol(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			targetVO.setDrugKind(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			String performCntNm = POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'","");
			targetVO.setPerformCntNm(performCntNm);
			targetVO.setCxtDiag(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			targetVO.setCxtDetail(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			String visitDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'","");
			visitDate = visitDate.replace("-", "");
			if(!"".equals(visitDate) && visitDate.length() != 8 ) visitDate = "";
			targetVO.setVisitDate(visitDate);
			String nextVisitDate = ""; 
			
			if(!"".equals(visitDate)) {
				Calendar cal = Calendar.getInstance();
				DateFormat df = new SimpleDateFormat("yyyyMMdd");
				Date date = df.parse(visitDate);
				cal.setTime(date);
	
				if(performCntNm.toUpperCase().contains("V")) {
					//방문예정일자 V- 인 경우 1년후로 셋팅
					cal.add(Calendar.YEAR, 1);
					nextVisitDate = df.format(cal.getTime());
				}else if(performCntNm.toUpperCase().contains("W")) {
					//방문예정일자 -W 인 경우 30일 후로 셋팅
					cal.add(Calendar.DATE, 30);
					nextVisitDate = df.format(cal.getTime());
				}
			}
			targetVO.setNextVisitDate(nextVisitDate.replace("-", ""));
			targetVO.setResearchInterview(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'","")));
			targetVO.setPsychology(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'","")));
			targetVO.setDevelopment(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'","")));
			targetVO.setBloodF(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'","")));
			targetVO.setBloodM(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'","")));
			targetVO.setBloodC(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'","")));
			targetVO.setPaxGene(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("'","")));
			targetVO.setUrine(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'","")));
			targetVO.setFeces(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'","")));
			targetVO.setAgreeRpF(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'","")));
			targetVO.setAgreeRpM(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("'","")));
			targetVO.setAgreeRhbmF(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("'","")));
			targetVO.setAgreeRhbmM(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("'","")));
			targetVO.setAgreeRhbmC(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("'","")));
//			targetVO.setRemainsAgreeP(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'","")));
//			targetVO.setRemainsAgreeC(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'","")));
//			targetVO.setAgreeGuardian(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'","")));
//			targetVO.setAgreeTarget(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("'","")));
			targetVO.setSurveyDistrib(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("'","")));
			targetVO.setSurveyReclam(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("'","")));
			targetVO.setSendResult(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("'","")));
			String interviewDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("'","");
			targetVO.setInterviewDate(returnLowerOX(interviewDate.replace("-", "")));
			targetVO.setInterviewer(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("'","")));
//			targetVO.setInterviewMethod(returnLowerOX(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("'","")));
			targetVO.setTargetRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("'",""));

			targetVO.setCreateBy("excel_upload");
			targetVO.setUpdateBy("excel_upload");
			
			
		} catch(Exception e) {
			if(logger.isDebugEnabled()){
				logger.error("[Error Message] There is an Exception while mapping between cells and the object!!");
				logger.error("[Error Line] Col : " + col + ", Row : " + (row + 1) );
				logger.error("[Error Detail]");
				logger.error(e.getMessage());
				e.printStackTrace();
			}
			throw new CellReaderMapperException("There is an Exception on CellMapper!!");
		}
		return targetVO;
	}
	
	public String returnLowerOX(String str) {
		if("x".equals(str.toLowerCase())) str = "x";
		else if("o".equals(str.toLowerCase())) str = "o";
		return str;
	}
}
