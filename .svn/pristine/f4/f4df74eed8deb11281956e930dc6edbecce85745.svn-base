package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdMbriVO;

public class SurveyAsdMbriCellReaderMapper implements CellReaderMapper<SurveyAsdMbriVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdMbriVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {

		SurveyAsdMbriVO surveyAsdMbriVO = new SurveyAsdMbriVO();
		
		try {
			surveyAsdMbriVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdMbriVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdMbriVO.setMbriExecDate(execDate.replace("-", ""));
			surveyAsdMbriVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdMbriVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdMbriVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdMbriVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdMbriVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdMbriVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdMbriVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdMbriVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdMbriVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdMbriVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdMbriVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyAsdMbriVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyAsdMbriVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyAsdMbriVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyAsdMbriVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyAsdMbriVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyAsdMbriVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyAsdMbriVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));			
			surveyAsdMbriVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyAsdMbriVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyAsdMbriVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyAsdMbriVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyAsdMbriVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyAsdMbriVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyAsdMbriVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	
			surveyAsdMbriVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));	
			surveyAsdMbriVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));	
			surveyAsdMbriVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));	
			surveyAsdMbriVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));	
			surveyAsdMbriVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	
			surveyAsdMbriVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));	
			surveyAsdMbriVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));	
			surveyAsdMbriVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));	
			surveyAsdMbriVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));	
			surveyAsdMbriVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));	
			surveyAsdMbriVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));	
			surveyAsdMbriVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));	
			surveyAsdMbriVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));	
			surveyAsdMbriVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));	
			surveyAsdMbriVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	
			surveyAsdMbriVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));	
			surveyAsdMbriVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));	
			surveyAsdMbriVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));	
			surveyAsdMbriVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));	
			surveyAsdMbriVO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));	
			surveyAsdMbriVO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));	
			surveyAsdMbriVO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));	
			surveyAsdMbriVO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));	
			surveyAsdMbriVO.setAffectionateAttitude(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));	
			surveyAsdMbriVO.setDenyAttitude(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));	
			surveyAsdMbriVO.setAutonomousAttitude(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));	
			surveyAsdMbriVO.setControlledAttitude(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));
			surveyAsdMbriVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));
			surveyAsdMbriVO.setCreateBy("excel_upload");
			surveyAsdMbriVO.setUpdateBy("excel_upload");	
			
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
		
		return surveyAsdMbriVO;
	}
	

}
