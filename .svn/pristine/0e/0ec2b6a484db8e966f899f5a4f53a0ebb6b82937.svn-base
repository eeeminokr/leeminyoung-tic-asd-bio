package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdSrs03VO;

public class SurveyAsdSrs03CellReaderMapper implements CellReaderMapper<SurveyAsdSrs03VO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdSrs03VO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {
      System.out.println("CELL값에들어온다!!!!!!!!!!!!!!!!!!!!!!!!!!");
		SurveyAsdSrs03VO surveyAsdSrs03VO = new SurveyAsdSrs03VO();
		
		try {
			surveyAsdSrs03VO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdSrs03VO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdSrs03VO.setSrs03ExecDate(execDate.replace("-", ""));
			surveyAsdSrs03VO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdSrs03VO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdSrs03VO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdSrs03VO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdSrs03VO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdSrs03VO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdSrs03VO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdSrs03VO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdSrs03VO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdSrs03VO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdSrs03VO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		
			surveyAsdSrs03VO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));		
			surveyAsdSrs03VO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));		
			surveyAsdSrs03VO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));		
			surveyAsdSrs03VO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));		
			surveyAsdSrs03VO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));		
			surveyAsdSrs03VO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));		
			surveyAsdSrs03VO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));		
			surveyAsdSrs03VO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));		
			surveyAsdSrs03VO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));
			surveyAsdSrs03VO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));		
			surveyAsdSrs03VO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));		
			surveyAsdSrs03VO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));		
			surveyAsdSrs03VO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));		
			surveyAsdSrs03VO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));		
			surveyAsdSrs03VO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));		
			surveyAsdSrs03VO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));		
			surveyAsdSrs03VO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));		
			surveyAsdSrs03VO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));		
			surveyAsdSrs03VO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	
			surveyAsdSrs03VO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));		
			surveyAsdSrs03VO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));		
			surveyAsdSrs03VO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));		
			surveyAsdSrs03VO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));		
			surveyAsdSrs03VO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));		
			surveyAsdSrs03VO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));		
			surveyAsdSrs03VO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));		
			surveyAsdSrs03VO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));		
			surveyAsdSrs03VO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));		
			surveyAsdSrs03VO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	
			surveyAsdSrs03VO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));		
			surveyAsdSrs03VO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));		
			surveyAsdSrs03VO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));		
			surveyAsdSrs03VO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));		
			surveyAsdSrs03VO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));		
			surveyAsdSrs03VO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));		
			surveyAsdSrs03VO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));		
			surveyAsdSrs03VO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));		
			surveyAsdSrs03VO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));		
			surveyAsdSrs03VO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));	
			surveyAsdSrs03VO.setA51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));		
			surveyAsdSrs03VO.setA52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));		
			surveyAsdSrs03VO.setA53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));		
			surveyAsdSrs03VO.setA54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));		
			surveyAsdSrs03VO.setA55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));		
			surveyAsdSrs03VO.setA56(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));		
			surveyAsdSrs03VO.setA57(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));		
			surveyAsdSrs03VO.setA58(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));		
			surveyAsdSrs03VO.setA59(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));		
			surveyAsdSrs03VO.setA60(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));	
			surveyAsdSrs03VO.setA61(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));		
			surveyAsdSrs03VO.setA62(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));		
			surveyAsdSrs03VO.setA63(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));		
			surveyAsdSrs03VO.setA64(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));		
			surveyAsdSrs03VO.setA65(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));		
			surveyAsdSrs03VO.setA66(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));		
			surveyAsdSrs03VO.setA67(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("",""));		
			surveyAsdSrs03VO.setA68(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("",""));		
			surveyAsdSrs03VO.setA69(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("",""));		
			surveyAsdSrs03VO.setA70(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("",""));	
			surveyAsdSrs03VO.setA71(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("",""));		
			surveyAsdSrs03VO.setA72(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("",""));		
			surveyAsdSrs03VO.setA73(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("",""));		
			surveyAsdSrs03VO.setA74(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("",""));		
			surveyAsdSrs03VO.setA75(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("",""));		
			surveyAsdSrs03VO.setA76(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("",""));		
			surveyAsdSrs03VO.setA77(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("",""));		
			surveyAsdSrs03VO.setA78(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("",""));		
			surveyAsdSrs03VO.setA79(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("",""));		
			surveyAsdSrs03VO.setA80(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("",""));
			surveyAsdSrs03VO.setCreateBy("excel_upload");
			surveyAsdSrs03VO.setUpdateBy("excel_upload");	
			
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
		return surveyAsdSrs03VO;
	}
	
	

}
