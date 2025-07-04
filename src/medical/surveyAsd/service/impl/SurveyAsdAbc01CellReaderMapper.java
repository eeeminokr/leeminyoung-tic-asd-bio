package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdAbc01VO;
import medical.surveyAsd.service.SurveyAsdKmchatVO;

public class SurveyAsdAbc01CellReaderMapper implements CellReaderMapper<SurveyAsdAbc01VO> {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdAbc01VO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		
		SurveyAsdAbc01VO surveyAsdAbc01VO = new SurveyAsdAbc01VO();
		try {
			surveyAsdAbc01VO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdAbc01VO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdAbc01VO.setAbc01ExecDate(execDate.replace("-", ""));
			surveyAsdAbc01VO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdAbc01VO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdAbc01VO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdAbc01VO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdAbc01VO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdAbc01VO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdAbc01VO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdAbc01VO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdAbc01VO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdAbc01VO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdAbc01VO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyAsdAbc01VO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyAsdAbc01VO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyAsdAbc01VO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyAsdAbc01VO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyAsdAbc01VO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyAsdAbc01VO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyAsdAbc01VO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));			
			surveyAsdAbc01VO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyAsdAbc01VO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyAsdAbc01VO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyAsdAbc01VO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyAsdAbc01VO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));
			surveyAsdAbc01VO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));
			surveyAsdAbc01VO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));
			surveyAsdAbc01VO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));
			surveyAsdAbc01VO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));
			surveyAsdAbc01VO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));
			surveyAsdAbc01VO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));
			surveyAsdAbc01VO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));
			surveyAsdAbc01VO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));
			surveyAsdAbc01VO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));
			surveyAsdAbc01VO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));
			surveyAsdAbc01VO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));
			surveyAsdAbc01VO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));
			surveyAsdAbc01VO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));
			surveyAsdAbc01VO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));
			surveyAsdAbc01VO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));
			surveyAsdAbc01VO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));
			surveyAsdAbc01VO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));
			surveyAsdAbc01VO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));
			surveyAsdAbc01VO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));
			surveyAsdAbc01VO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));
			surveyAsdAbc01VO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));
			surveyAsdAbc01VO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));
			surveyAsdAbc01VO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));
			surveyAsdAbc01VO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));
			surveyAsdAbc01VO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));
			surveyAsdAbc01VO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));
			surveyAsdAbc01VO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));
			surveyAsdAbc01VO.setA51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));
			surveyAsdAbc01VO.setA52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));
			surveyAsdAbc01VO.setA53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));
			surveyAsdAbc01VO.setA54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));
			surveyAsdAbc01VO.setA55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));
			surveyAsdAbc01VO.setA56(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));
			surveyAsdAbc01VO.setA57(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));
			surveyAsdAbc01VO.setA58(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));
			surveyAsdAbc01VO.setA59(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));
			surveyAsdAbc01VO.setA60(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));
			surveyAsdAbc01VO.setA61(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));
			surveyAsdAbc01VO.setA62(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));
			surveyAsdAbc01VO.setA63(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));
			surveyAsdAbc01VO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));	
			surveyAsdAbc01VO.setCreateBy("excel_upload");
			surveyAsdAbc01VO.setUpdateBy("excel_upload");	
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
		return surveyAsdAbc01VO;
	}
}
