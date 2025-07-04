package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdQpgsrVO;

public class SurveyAsdQpgsrCellReaderMapper implements CellReaderMapper<SurveyAsdQpgsrVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdQpgsrVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {

		SurveyAsdQpgsrVO surveyAsdQpgsrVO = new SurveyAsdQpgsrVO();
		
		try {
			surveyAsdQpgsrVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdQpgsrVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdQpgsrVO.setQpgsrExecDate(execDate.replace("-", ""));
			surveyAsdQpgsrVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdQpgsrVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));
			surveyAsdQpgsrVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	
			surveyAsdQpgsrVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	
			surveyAsdQpgsrVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));		
			surveyAsdQpgsrVO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));
			surveyAsdQpgsrVO.setCreateBy("excel_upload");
			surveyAsdQpgsrVO.setUpdateBy("excel_upload");	
			
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
		return surveyAsdQpgsrVO;
	}
	
	

}
