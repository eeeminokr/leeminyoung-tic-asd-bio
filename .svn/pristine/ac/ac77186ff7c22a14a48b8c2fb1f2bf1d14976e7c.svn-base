package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyMbriVO;

public class SurveyMbriCellReaderMapper implements CellReaderMapper<SurveyMbriVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyMbriVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {

		SurveyMbriVO surveyMbriVO = new SurveyMbriVO();
		
		try {
			surveyMbriVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyMbriVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyMbriVO.setMbriExecDate(execDate.replace("-", ""));
			surveyMbriVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		
			surveyMbriVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyMbriVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyMbriVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyMbriVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyMbriVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyMbriVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyMbriVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyMbriVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyMbriVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));	
			surveyMbriVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyMbriVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyMbriVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyMbriVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyMbriVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyMbriVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyMbriVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyMbriVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));			
			surveyMbriVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
			surveyMbriVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyMbriVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyMbriVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyMbriVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyMbriVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyMbriVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyMbriVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	
			surveyMbriVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));	
			surveyMbriVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));	
			surveyMbriVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));	
			surveyMbriVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));	
			surveyMbriVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	
			surveyMbriVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));	
			surveyMbriVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));	
			surveyMbriVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));	
			surveyMbriVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));	
			surveyMbriVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));	
			surveyMbriVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));	
			surveyMbriVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));	
			surveyMbriVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));	
			surveyMbriVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));	
			surveyMbriVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	
			surveyMbriVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));	
			surveyMbriVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));	
			surveyMbriVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));	
			surveyMbriVO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));	
			surveyMbriVO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));	
			surveyMbriVO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));	
			surveyMbriVO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));	
			surveyMbriVO.setAffectionateAttitude(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));	
			surveyMbriVO.setDenyAttitude(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));	
			surveyMbriVO.setAutonomousAttitude(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));	
			surveyMbriVO.setControlledAttitude(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));
			surveyMbriVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));
			surveyMbriVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));
			surveyMbriVO.setCreateBy("excel_upload");
			surveyMbriVO.setUpdateBy("excel_upload");	
			
		} catch (Exception e) {
			if(logger.isDebugEnabled()){
				logger.error("[Error Message] There is an Exception while mapping between cells and the object!!");
				logger.error("[Error Line] Col : " + col + ", Row : " + (row + 1) );
				logger.error("[Error Detail]");
				logger.error(e.getMessage());
				e.printStackTrace();
			}
			throw new CellReaderMapperException("There is an Exception on CellMapper!!");
		}
		
		return surveyMbriVO;
	}
	

}
