package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdCbcl2VO;
import medical.surveyAsd.service.SurveyAsdOcb15VO;

public class SurveyAsdOcb15CellReaderMapper implements CellReaderMapper<SurveyAsdOcb15VO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdOcb15VO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdOcb15VO surveyAsdOcb15VO = new SurveyAsdOcb15VO();
		try {
			surveyAsdOcb15VO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdOcb15VO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdOcb15VO.setOcbExecDate(execDate.replace("-", ""));
			
	
			
			surveyAsdOcb15VO.setC6PcsTts1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));                              
			surveyAsdOcb15VO.setC6PcsTin2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));                              
			surveyAsdOcb15VO.setC6PcsTout3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6PcsTdeLow4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PcsTshr5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6PcsTps6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));                              
			surveyAsdOcb15VO.setC6PcsTsoch7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6PcsTthinkp8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PcsTafp9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));                              
			surveyAsdOcb15VO.setC6PcsToffrls10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));                                  
			surveyAsdOcb15VO.setC6PcsTatp11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6PcsTetc12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));                                //	
			surveyAsdOcb15VO.setC6PcsPcntts1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));                                
			surveyAsdOcb15VO.setC6PcsPcntin2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));                                
			surveyAsdOcb15VO.setC6PcsPcntout3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PcsPcntdeLow4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));                                   
			surveyAsdOcb15VO.setC6PcsPcntshr5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PcsPcntps6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));                                
			surveyAsdOcb15VO.setC6PcsPcntsoch7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));                                  
			surveyAsdOcb15VO.setC6PcsPcntthinkp8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));                                    
			surveyAsdOcb15VO.setC6PcsPcntafp9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PcsPcntoffrls10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));                                     
			surveyAsdOcb15VO.setC6PcsPcntatp11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));                                  
			surveyAsdOcb15VO.setC6PcsPcntetc12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));                                   //
			surveyAsdOcb15VO.setC6PcsSts1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));                             
			surveyAsdOcb15VO.setC6PcsSin2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));                             
			surveyAsdOcb15VO.setC6PcsSout3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));                              
			surveyAsdOcb15VO.setC6PcsSdeLow4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));                                
			surveyAsdOcb15VO.setC6PcsSshr5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));                              
			surveyAsdOcb15VO.setC6PcsSps6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));                             
			surveyAsdOcb15VO.setC6PcsSsoch7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6PcsSthinkp8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PcsSafp9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PcsSoffrls10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));                                  
			surveyAsdOcb15VO.setC6PcsSatp11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6PcsSetc12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));                                   //
			surveyAsdOcb15VO.setC6DsmTemop1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6DsmTdep2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));                              
			surveyAsdOcb15VO.setC6DsmTphsp3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6DsmTadhd4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6DsmToppbhv5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6DsmTcdtp6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));                                //
			surveyAsdOcb15VO.setC6DsmPcntemop1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));                                  
			surveyAsdOcb15VO.setC6DsmPcntdep2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6DsmPcntphsp3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));                                  
			surveyAsdOcb15VO.setC6DsmPcntadhd4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));                                  
			surveyAsdOcb15VO.setC6DsmPcntoppbhv5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));                                    
			surveyAsdOcb15VO.setC6DsmPcntcdtp6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));                                   //
			surveyAsdOcb15VO.setC6DsmSemop1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6DsmSdep2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));                              
			surveyAsdOcb15VO.setC6DsmSphsp3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6DsmSadhd4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6DsmSoppbhv5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6DsmScdtp6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));                                //
			surveyAsdOcb15VO.setC6PbsTobsspt1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PbsTptsp2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6PbsTsct3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));                               //
			surveyAsdOcb15VO.setC6PbsPcntobsspt1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));                                    
			surveyAsdOcb15VO.setC6PbsPcntptsp2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));                                  
			surveyAsdOcb15VO.setC6PbsPcntsct3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));                                  //
			surveyAsdOcb15VO.setC6PbsSobsspt1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PbsSptsp2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));                               
			surveyAsdOcb15VO.setC6PbsSsct3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));                               //
			surveyAsdOcb15VO.setC6PbsAdptTts1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PbsAdptTsocial2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));                                     
			surveyAsdOcb15VO.setC6PbsAdptTschpfm3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));                                      //
			surveyAsdOcb15VO.setC6PbsAdptPcntts1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("",""));                                    
			surveyAsdOcb15VO.setC6PbsAdptPcntsocial2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("",""));                                        
			surveyAsdOcb15VO.setC6PbsAdptPcntschpfm3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("",""));                                         //
			surveyAsdOcb15VO.setC6PbsAdptSts1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("",""));                                 
			surveyAsdOcb15VO.setC6PbsAdptSsocial2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("",""));                                     
			surveyAsdOcb15VO.setC6PbsAdptSschpfm3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("",""));                                     
		
		
      			                                   
		
			 surveyAsdOcb15VO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("",""));		          	                         
			 surveyAsdOcb15VO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("",""));		                                     
			 surveyAsdOcb15VO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("",""));		                                     
			 surveyAsdOcb15VO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("",""));		                                     
			 surveyAsdOcb15VO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("",""));		                                     
			 surveyAsdOcb15VO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("",""));		                                     
			 surveyAsdOcb15VO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("",""));		                                     
			 surveyAsdOcb15VO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("",""));		                                     
			 surveyAsdOcb15VO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("",""));		                                     
			 surveyAsdOcb15VO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(86)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(87)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(88)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(89)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(90)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(91)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(92)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(93)).trim().replace("",""));			                                   
			 surveyAsdOcb15VO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(94)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(95)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(96)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(97)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(98)).trim().replace("",""));	                                       
			 surveyAsdOcb15VO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(99)).trim().replace("",""));                                        
			 surveyAsdOcb15VO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(100)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(101)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(102)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(103)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(104)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(105)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(106)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(107)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(108)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(109)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(110)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(111)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(112)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(113)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(114)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(115)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(116)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(117)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(118)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(119)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(120)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(121)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(122)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(123)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(124)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(125)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(126)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(127)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(128)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(129)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(130)).trim().replace("",""));                                       		                              
		    surveyAsdOcb15VO.setA56a(POIUtil.getStringCellValue(sheet.getRow(row).getCell(131)).trim().replace("",""));
			surveyAsdOcb15VO.setA56b(POIUtil.getStringCellValue(sheet.getRow(row).getCell(132)).trim().replace("",""));
			surveyAsdOcb15VO.setA56c(POIUtil.getStringCellValue(sheet.getRow(row).getCell(133)).trim().replace("",""));
			surveyAsdOcb15VO.setA56d(POIUtil.getStringCellValue(sheet.getRow(row).getCell(134)).trim().replace("",""));
			surveyAsdOcb15VO.setA56e(POIUtil.getStringCellValue(sheet.getRow(row).getCell(135)).trim().replace("",""));
			surveyAsdOcb15VO.setA56f(POIUtil.getStringCellValue(sheet.getRow(row).getCell(136)).trim().replace("",""));
			surveyAsdOcb15VO.setA56g(POIUtil.getStringCellValue(sheet.getRow(row).getCell(137)).trim().replace("",""));
			surveyAsdOcb15VO.setA56h(POIUtil.getStringCellValue(sheet.getRow(row).getCell(138)).trim().replace("",""));			 
			 surveyAsdOcb15VO.setA57(POIUtil.getStringCellValue(sheet.getRow(row).getCell(139)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA58(POIUtil.getStringCellValue(sheet.getRow(row).getCell(140)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA59(POIUtil.getStringCellValue(sheet.getRow(row).getCell(141)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA60(POIUtil.getStringCellValue(sheet.getRow(row).getCell(142)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA61(POIUtil.getStringCellValue(sheet.getRow(row).getCell(143)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA62(POIUtil.getStringCellValue(sheet.getRow(row).getCell(144)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA63(POIUtil.getStringCellValue(sheet.getRow(row).getCell(145)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA64(POIUtil.getStringCellValue(sheet.getRow(row).getCell(146)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA65(POIUtil.getStringCellValue(sheet.getRow(row).getCell(147)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA66(POIUtil.getStringCellValue(sheet.getRow(row).getCell(148)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA67(POIUtil.getStringCellValue(sheet.getRow(row).getCell(149)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA68(POIUtil.getStringCellValue(sheet.getRow(row).getCell(150)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA69(POIUtil.getStringCellValue(sheet.getRow(row).getCell(151)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA70(POIUtil.getStringCellValue(sheet.getRow(row).getCell(152)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA71(POIUtil.getStringCellValue(sheet.getRow(row).getCell(153)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA72(POIUtil.getStringCellValue(sheet.getRow(row).getCell(154)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA73(POIUtil.getStringCellValue(sheet.getRow(row).getCell(155)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA74(POIUtil.getStringCellValue(sheet.getRow(row).getCell(156)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA75(POIUtil.getStringCellValue(sheet.getRow(row).getCell(157)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA76(POIUtil.getStringCellValue(sheet.getRow(row).getCell(158)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA77(POIUtil.getStringCellValue(sheet.getRow(row).getCell(159)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA78(POIUtil.getStringCellValue(sheet.getRow(row).getCell(160)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA79(POIUtil.getStringCellValue(sheet.getRow(row).getCell(161)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA80(POIUtil.getStringCellValue(sheet.getRow(row).getCell(162)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA81(POIUtil.getStringCellValue(sheet.getRow(row).getCell(163)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA82(POIUtil.getStringCellValue(sheet.getRow(row).getCell(164)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA83(POIUtil.getStringCellValue(sheet.getRow(row).getCell(165)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA84(POIUtil.getStringCellValue(sheet.getRow(row).getCell(166)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA85(POIUtil.getStringCellValue(sheet.getRow(row).getCell(167)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA86(POIUtil.getStringCellValue(sheet.getRow(row).getCell(168)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA87(POIUtil.getStringCellValue(sheet.getRow(row).getCell(169)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA88(POIUtil.getStringCellValue(sheet.getRow(row).getCell(170)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA89(POIUtil.getStringCellValue(sheet.getRow(row).getCell(171)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA90(POIUtil.getStringCellValue(sheet.getRow(row).getCell(172)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA91(POIUtil.getStringCellValue(sheet.getRow(row).getCell(173)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA92(POIUtil.getStringCellValue(sheet.getRow(row).getCell(174)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA93(POIUtil.getStringCellValue(sheet.getRow(row).getCell(175)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA94(POIUtil.getStringCellValue(sheet.getRow(row).getCell(176)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA95(POIUtil.getStringCellValue(sheet.getRow(row).getCell(177)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA96(POIUtil.getStringCellValue(sheet.getRow(row).getCell(178)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA97(POIUtil.getStringCellValue(sheet.getRow(row).getCell(179)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA98(POIUtil.getStringCellValue(sheet.getRow(row).getCell(180)).trim().replace("",""));                                       
			 surveyAsdOcb15VO.setA99(POIUtil.getStringCellValue(sheet.getRow(row).getCell(181)).trim().replace("",""));                                       
			surveyAsdOcb15VO.setA100(POIUtil.getStringCellValue(sheet.getRow(row).getCell(182)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA101(POIUtil.getStringCellValue(sheet.getRow(row).getCell(183)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA102(POIUtil.getStringCellValue(sheet.getRow(row).getCell(184)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA103(POIUtil.getStringCellValue(sheet.getRow(row).getCell(185)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA104(POIUtil.getStringCellValue(sheet.getRow(row).getCell(186)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA105(POIUtil.getStringCellValue(sheet.getRow(row).getCell(187)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA106(POIUtil.getStringCellValue(sheet.getRow(row).getCell(188)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA107(POIUtil.getStringCellValue(sheet.getRow(row).getCell(189)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA108(POIUtil.getStringCellValue(sheet.getRow(row).getCell(190)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA109(POIUtil.getStringCellValue(sheet.getRow(row).getCell(191)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA110(POIUtil.getStringCellValue(sheet.getRow(row).getCell(192)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA111(POIUtil.getStringCellValue(sheet.getRow(row).getCell(193)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA112(POIUtil.getStringCellValue(sheet.getRow(row).getCell(194)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA113(POIUtil.getStringCellValue(sheet.getRow(row).getCell(195)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA114(POIUtil.getStringCellValue(sheet.getRow(row).getCell(196)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA115(POIUtil.getStringCellValue(sheet.getRow(row).getCell(197)).trim().replace("",""));                                      
			surveyAsdOcb15VO.setA116(POIUtil.getStringCellValue(sheet.getRow(row).getCell(198)).trim().replace("",""));                                      
                                   

			surveyAsdOcb15VO.setCreateBy("excel_upload");
			surveyAsdOcb15VO.setUpdateBy("excel_upload");	
			
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
		return surveyAsdOcb15VO;
	}
}
