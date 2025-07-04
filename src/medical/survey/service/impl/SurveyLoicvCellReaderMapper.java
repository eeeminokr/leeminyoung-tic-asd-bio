package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyLoicvVO;

public class SurveyLoicvCellReaderMapper implements CellReaderMapper<SurveyLoicvVO>{

	protected final Log logger = LogFactory.getLog(getClass());
    
	@Override
	public SurveyLoicvVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyLoicvVO surveyLoicvVO = new SurveyLoicvVO();
		try {
			surveyLoicvVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyLoicvVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyLoicvVO.setLoicvExecDate(execDate.replace("-", ""));
			surveyLoicvVO.setCurrentTime(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));  
			surveyLoicvVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));  
			surveyLoicvVO.setA1Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA1Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));  	//지장
			surveyLoicvVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));  
			surveyLoicvVO.setA2Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA2Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));  	//지장
			surveyLoicvVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));  
			surveyLoicvVO.setA3Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA3Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));  	//지장
			surveyLoicvVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));  
			surveyLoicvVO.setA4Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA4Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));  	//지장
			surveyLoicvVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));  
			surveyLoicvVO.setA5Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA5Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));  	//지장
			surveyLoicvVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));  
			surveyLoicvVO.setA6Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA6Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));  	//지장
			surveyLoicvVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));  
			surveyLoicvVO.setA7Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA7Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));  	//지장
			surveyLoicvVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));  
			surveyLoicvVO.setA8Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA8Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));  	//지장
			surveyLoicvVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));  
			surveyLoicvVO.setA9Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA9Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));  	//지장
			surveyLoicvVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));  
			surveyLoicvVO.setA10Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA10Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));  //지장
			surveyLoicvVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));  
			surveyLoicvVO.setA11Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA11Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));  //지장
			surveyLoicvVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));  
			surveyLoicvVO.setA12Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA12Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));  //지장
			surveyLoicvVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));  
			surveyLoicvVO.setA13Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA13Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));  //지장
			surveyLoicvVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));  
			surveyLoicvVO.setA14Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA14Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));  //지장
			surveyLoicvVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));  
			surveyLoicvVO.setA15Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA15Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));  //지장
			surveyLoicvVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));  
			surveyLoicvVO.setA16Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA16Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));  //지장
			surveyLoicvVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));  
			surveyLoicvVO.setA17Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA17Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));  //지장
			surveyLoicvVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));  
			surveyLoicvVO.setA18Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA18Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));  //지장
			surveyLoicvVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));  
			surveyLoicvVO.setA19Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA19Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));  //지장
			surveyLoicvVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));  
			surveyLoicvVO.setA20Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA20Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));  //지장
			surveyLoicvVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));  
			surveyLoicvVO.setA21Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA21Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));  //지장
			surveyLoicvVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));  
			surveyLoicvVO.setA22Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA22Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));  //지장
			surveyLoicvVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("",""));  
			surveyLoicvVO.setA23Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA23Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("",""));  //지장
			surveyLoicvVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("",""));  
			surveyLoicvVO.setA24Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA24Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("",""));  //지장
			surveyLoicvVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("",""));  
			surveyLoicvVO.setA25Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA25Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("",""));  //지장
			surveyLoicvVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("",""));  
			surveyLoicvVO.setA26Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA26Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("",""));  //지장
			surveyLoicvVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("",""));  
			surveyLoicvVO.setA27Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA27Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("",""));  //지장
			surveyLoicvVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("",""));  
			surveyLoicvVO.setA28Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(86)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA28Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(87)).trim().replace("",""));  //지장
			surveyLoicvVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(88)).trim().replace("",""));  
			surveyLoicvVO.setA29Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(89)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA29Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(90)).trim().replace("",""));  //지장
			surveyLoicvVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(91)).trim().replace("",""));  
			surveyLoicvVO.setA30Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(92)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA30Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(93)).trim().replace("",""));  //지장
			surveyLoicvVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(94)).trim().replace("",""));  
			surveyLoicvVO.setA31Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(95)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA31Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(96)).trim().replace("",""));  //지장
			surveyLoicvVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(97)).trim().replace("",""));  
			surveyLoicvVO.setA32Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(98)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA32Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(99)).trim().replace("",""));  //지장
			surveyLoicvVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(100)).trim().replace("",""));  
			surveyLoicvVO.setA33Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(101)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA33Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(102)).trim().replace("",""));  //지장
			surveyLoicvVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(103)).trim().replace("",""));  
			surveyLoicvVO.setA34Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(104)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA34Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(105)).trim().replace("",""));  //지장
			surveyLoicvVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(106)).trim().replace("",""));  
			surveyLoicvVO.setA35Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(107)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA35Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(108)).trim().replace("",""));  //지장
			surveyLoicvVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(109)).trim().replace("",""));  
			surveyLoicvVO.setA36Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(110)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA36Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(111)).trim().replace("",""));  //지장
			surveyLoicvVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(112)).trim().replace("",""));  
			surveyLoicvVO.setA37Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(113)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA37Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(114)).trim().replace("",""));  //지장
			surveyLoicvVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(115)).trim().replace("",""));  
			surveyLoicvVO.setA38Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(116)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA38Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(117)).trim().replace("",""));  //지장
			surveyLoicvVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(118)).trim().replace("",""));  
			surveyLoicvVO.setA39Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(119)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA39Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(120)).trim().replace("",""));  //지장
			surveyLoicvVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(121)).trim().replace("",""));  
			surveyLoicvVO.setA40Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(122)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA40Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(123)).trim().replace("",""));  //지장
			surveyLoicvVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(124)).trim().replace("",""));  
			surveyLoicvVO.setA41Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(125)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA41Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(126)).trim().replace("",""));  //지장
			surveyLoicvVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(127)).trim().replace("",""));  
			surveyLoicvVO.setA42Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(128)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA42Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(129)).trim().replace("",""));  //지장
			surveyLoicvVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(130)).trim().replace("",""));  
			surveyLoicvVO.setA43Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(131)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA43Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(132)).trim().replace("",""));  //지장
			surveyLoicvVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(133)).trim().replace("",""));  
			surveyLoicvVO.setA44Feeling(POIUtil.getStringCellValue(sheet.getRow(row).getCell(134)).trim().replace("",""));		//느낌  
			surveyLoicvVO.setA44Encumbrance(POIUtil.getStringCellValue(sheet.getRow(row).getCell(135)).trim().replace("",""));  //지장
			surveyLoicvVO.setTotalYnScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(136)).trim().replace("",""));  //지장  
			surveyLoicvVO.setTotalFeelingScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(137)).trim().replace("",""));  //지장  
			surveyLoicvVO.setTotalEncumbranceScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(138)).trim().replace("",""));  //지장  
			surveyLoicvVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(139)).trim().replace("",""));  //지장  
			surveyLoicvVO.setCreateBy("excel_upload");
			surveyLoicvVO.setUpdateBy("excel_upload");
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
		return surveyLoicvVO;
	}
}
