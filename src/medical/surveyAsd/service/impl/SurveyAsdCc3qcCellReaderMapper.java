package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdCc3qcVO;

public class SurveyAsdCc3qcCellReaderMapper implements CellReaderMapper<SurveyAsdCc3qcVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdCc3qcVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdCc3qcVO surveyAsdCc3qcVO = new SurveyAsdCc3qcVO();
		try {
			surveyAsdCc3qcVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdCc3qcVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdCc3qcVO.setCc3qcExecDate(execDate.replace("-", ""));
			surveyAsdCc3qcVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdCc3qcVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdCc3qcVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdCc3qcVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdCc3qcVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdCc3qcVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdCc3qcVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdCc3qcVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdCc3qcVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdCc3qcVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));			
			surveyAsdCc3qcVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyAsdCc3qcVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));
			surveyAsdCc3qcVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));
			surveyAsdCc3qcVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));
			surveyAsdCc3qcVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));
			surveyAsdCc3qcVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));
			surveyAsdCc3qcVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));
			surveyAsdCc3qcVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));
			surveyAsdCc3qcVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));
			surveyAsdCc3qcVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));
			surveyAsdCc3qcVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));
			surveyAsdCc3qcVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));
			surveyAsdCc3qcVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));
			surveyAsdCc3qcVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));
			surveyAsdCc3qcVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));
			surveyAsdCc3qcVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));
			surveyAsdCc3qcVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));
			surveyAsdCc3qcVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));
			surveyAsdCc3qcVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));
			surveyAsdCc3qcVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));
			surveyAsdCc3qcVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));
			surveyAsdCc3qcVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));
			surveyAsdCc3qcVO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));
			surveyAsdCc3qcVO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));
			surveyAsdCc3qcVO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));
			surveyAsdCc3qcVO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));
			surveyAsdCc3qcVO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));
			surveyAsdCc3qcVO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));
			
			surveyAsdCc3qcVO.setB1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));
			surveyAsdCc3qcVO.setB2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));
			surveyAsdCc3qcVO.setB3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));
			surveyAsdCc3qcVO.setB4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));
			surveyAsdCc3qcVO.setB5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));
			surveyAsdCc3qcVO.setB6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));
			surveyAsdCc3qcVO.setB7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));
			surveyAsdCc3qcVO.setB8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));
			surveyAsdCc3qcVO.setB9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));
			surveyAsdCc3qcVO.setB10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));
			surveyAsdCc3qcVO.setB11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));
			surveyAsdCc3qcVO.setB12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));
			surveyAsdCc3qcVO.setB13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));
			surveyAsdCc3qcVO.setB14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));
			surveyAsdCc3qcVO.setB15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));
			surveyAsdCc3qcVO.setB16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));
			surveyAsdCc3qcVO.setB17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("",""));
			surveyAsdCc3qcVO.setB18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("",""));
			surveyAsdCc3qcVO.setB19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("",""));
			surveyAsdCc3qcVO.setB20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("",""));
			surveyAsdCc3qcVO.setB21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("",""));
			surveyAsdCc3qcVO.setB22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("",""));
			surveyAsdCc3qcVO.setB23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("",""));
			surveyAsdCc3qcVO.setB24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("",""));
			surveyAsdCc3qcVO.setB25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("",""));
			surveyAsdCc3qcVO.setB26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("",""));
			surveyAsdCc3qcVO.setB27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("",""));
			surveyAsdCc3qcVO.setB28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("",""));
			surveyAsdCc3qcVO.setB29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("",""));
			surveyAsdCc3qcVO.setB30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("",""));
			surveyAsdCc3qcVO.setB31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("",""));
			surveyAsdCc3qcVO.setB32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("",""));
			surveyAsdCc3qcVO.setB33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(86)).trim().replace("",""));
			surveyAsdCc3qcVO.setB34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(87)).trim().replace("",""));
			surveyAsdCc3qcVO.setB35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(88)).trim().replace("",""));
			surveyAsdCc3qcVO.setB36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(89)).trim().replace("",""));
			surveyAsdCc3qcVO.setB37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(90)).trim().replace("",""));
			surveyAsdCc3qcVO.setB38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(91)).trim().replace("",""));
			surveyAsdCc3qcVO.setB39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(92)).trim().replace("",""));
			surveyAsdCc3qcVO.setB40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(93)).trim().replace("",""));
			surveyAsdCc3qcVO.setB41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(94)).trim().replace("",""));
			surveyAsdCc3qcVO.setB42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(95)).trim().replace("",""));
			surveyAsdCc3qcVO.setB43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(96)).trim().replace("",""));
			surveyAsdCc3qcVO.setB44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(97)).trim().replace("",""));
			surveyAsdCc3qcVO.setB45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(98)).trim().replace("",""));
			surveyAsdCc3qcVO.setB46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(99)).trim().replace("",""));
			surveyAsdCc3qcVO.setB47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(100)).trim().replace("",""));
			surveyAsdCc3qcVO.setB48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(101)).trim().replace("",""));
			surveyAsdCc3qcVO.setB49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(102)).trim().replace("",""));
			surveyAsdCc3qcVO.setB50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(103)).trim().replace("",""));
			surveyAsdCc3qcVO.setB51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(104)).trim().replace("",""));
			surveyAsdCc3qcVO.setB52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(105)).trim().replace("",""));
			surveyAsdCc3qcVO.setB53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(106)).trim().replace("",""));
			surveyAsdCc3qcVO.setB54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(107)).trim().replace("",""));
			surveyAsdCc3qcVO.setB55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(108)).trim().replace("",""));

			surveyAsdCc3qcVO.setCreateBy("excel_upload");
			surveyAsdCc3qcVO.setUpdateBy("excel_upload");	
			
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
		return surveyAsdCc3qcVO;
	}
}
