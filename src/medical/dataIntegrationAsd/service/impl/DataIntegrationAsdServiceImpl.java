package medical.dataIntegrationAsd.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;

import medical.common.service.AbstractService;
import medical.commoninfo.code.service.CodeVO;
import medical.commoninfo.code.service.impl.CodeDAO;
import medical.dataIntegrationAsd.service.DataIntegrationAsdListVO;
import medical.dataIntegrationAsd.service.DataIntegrationAsdService;
import medical.dataIntegrationAsd.service.DataIntegrationAsdVO;
import medical.framework.file.ExcelFile;
import medical.framework.file.ExcelFileWriter;
import medical.framework.util.ResourceBundleUtil;
import medical.framework.util.StringUtil;
import medical.target.service.TargetVO;

@Service("DataIntegrationAsdService")
public class DataIntegrationAsdServiceImpl extends AbstractService implements DataIntegrationAsdService{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/** DAO Class */
	@Resource(name = "DataIntegrationAsdDAO")
	private DataIntegrationAsdDAO dataIntegrationAsdDAO;
	@Resource(name = "CodeDAO")
	private CodeDAO codeDAO;
	
	private ExcelFileWriter<DataIntegrationAsdListVO> dataIntegrationAsdListExcelFileWriter;

	public void setDataIntegrationAsdListExcelFileWriter(
			ExcelFileWriter<DataIntegrationAsdListVO> dataIntegrationAsdListExcelFileWriter) {
		this.dataIntegrationAsdListExcelFileWriter = dataIntegrationAsdListExcelFileWriter;
	}
	
	@Override
	public List<DataIntegrationAsdListVO> selectDataIntegrationListAo(
			DataIntegrationAsdListVO dataIntegrationAsdListVO) {
		List<DataIntegrationAsdListVO> list = dataIntegrationAsdDAO.selectDataIntegrationAsdList(dataIntegrationAsdListVO);
		if(list.size() > 0) {
			String cntArr[] = null;
			int maxSeq = 1;
			int cntArrLen = 0;
			for(DataIntegrationAsdListVO vo : list) {
				String cnt = vo.getPerformNm();
				
				if(cnt != null) cntArr = cnt.split(", ");
				
				cntArrLen = cntArr.length;
				
				if(maxSeq < cntArrLen) {
					maxSeq = cntArrLen;
				}
			}
			if(list == null || maxSeq < 2) maxSeq = 2;
			if(list != null) {
				list.get(0).setMaxSeq(maxSeq);
			}
		}
		return list;
	}
	@Override
	public int selectDataIntegrationListAoTotal(DataIntegrationAsdListVO dataIntegrationAsdListVO) {
		return dataIntegrationAsdDAO.selectDataIntegrationListAoTotal(dataIntegrationAsdListVO);
	
	
	}
	
	@Override
	public List<DataIntegrationAsdVO> selectTicDocDtlList(DataIntegrationAsdVO dataIntegrationAsdVO) {
		List<DataIntegrationAsdVO> result = dataIntegrationAsdDAO.selectTicDocDtlList(dataIntegrationAsdVO);
		List<DataIntegrationAsdVO> dataAsdListVO = new ArrayList<DataIntegrationAsdVO>();
		DataIntegrationAsdVO dataInterAsdVO;
		
		for(DataIntegrationAsdVO vo : result) {
			dataInterAsdVO = new DataIntegrationAsdVO();
			
			
			System.out.println("DOC_ID "+vo.getDocId());
			System.out.println("DOC_CLASS_DTL CLASS id:----> "+vo.getDocClassDtl());
			System.out.println("DIS_CLASS_DTL CLASS id:----> "+vo.getDisClassDtl());
			
			dataInterAsdVO.setDisClassDtl(vo.getDisClassDtl());
			dataInterAsdVO.setDocClassDtl(vo.getDocClassDtl());
			
			dataAsdListVO.add(dataInterAsdVO);
			dataIntegrationAsdVO.setDocClassDtl(vo.getDocClassDtl());
			}

		
		return dataIntegrationAsdDAO.selectTicDocDtlList(dataIntegrationAsdVO);
			//return dataAsdListVO;
		
	}
	@Override
	public List<DataIntegrationAsdVO> selectTicDocDtl(DataIntegrationAsdVO dataIntegrationAsdVO) {

			System.out.println("TicDocDtl에서 docId vo 첫번째 값은???========> :"+dataIntegrationAsdVO.getDocId());

		if(dataIntegrationAsdVO.getDocId().equals("SRS01") || dataIntegrationAsdVO.getDocId().equals("CYBO1") 
		   || dataIntegrationAsdVO.getDocId().equals("YBOCS") ) {
			dataIntegrationAsdVO.setDocClassDtl("DC004");
			
		}else if(dataIntegrationAsdVO.getDocId().equals("KMCHT") || dataIntegrationAsdVO.getDocId().equals("OCBCL") 
		   || dataIntegrationAsdVO.getDocId().equals("CBCL2") || dataIntegrationAsdVO.getDocId().equals("OCB15")
		   || dataIntegrationAsdVO.getDocId().equals("CBC15") || dataIntegrationAsdVO.getDocId().equals("LSD01")
		   || dataIntegrationAsdVO.getDocId().equals("ARS01") || dataIntegrationAsdVO.getDocId().equals("ABC01")
		   || dataIntegrationAsdVO.getDocId().equals("SIB01") || dataIntegrationAsdVO.getDocId().equals("BPI01")
		   || dataIntegrationAsdVO.getDocId().equals("SRS03") || dataIntegrationAsdVO.getDocId().equals("SCQ01")
		   || dataIntegrationAsdVO.getDocId().equals("PC3Q1") || dataIntegrationAsdVO.getDocId().equals("KASDS")
		   || dataIntegrationAsdVO.getDocId().equals("SSIS1") || dataIntegrationAsdVO.getDocId().equals("TRAUM")) {
			dataIntegrationAsdVO.setDocClassDtl("DC002");
		}
		
		List<DataIntegrationAsdVO> result = dataIntegrationAsdDAO.selectTicDocDtl(dataIntegrationAsdVO);
		
		
		
		List<DataIntegrationAsdVO> dataAsdListVO = new ArrayList<DataIntegrationAsdVO>();
		DataIntegrationAsdVO dataInterAsdVO;
		
		for(DataIntegrationAsdVO vo : result) {
			dataInterAsdVO = new DataIntegrationAsdVO();
			
			
			
			dataInterAsdVO.setDisClassDtl(vo.getDisClassDtl());
			dataInterAsdVO.setDocClassDtl(vo.getDocClassDtl());
			
			
			
			System.out.println("selectTicDocDtl[DOC_CLASS_DTL CLASS] id(vo값다시 넣음):----> "+vo.getDocClassDtl());
			System.out.println("=======[DIS_CLASS_DTL CLASS] id:----> "+vo.getDisClassDtl());
			dataAsdListVO.add(dataInterAsdVO);
			dataIntegrationAsdVO.setDocClassDtl(vo.getDocClassDtl());
		}
		
		return dataIntegrationAsdDAO.selectTicDocDtl(dataIntegrationAsdVO);
		//return dataAsdListVO;
	}
	
	public List<DataIntegrationAsdListVO> selectDataIntegrationDtlListAo(DataIntegrationAsdListVO dataIntegrationAsdListVO) {
		System.out.println("selectDataIntegrationDtlListAo----------1 >");
		List<DataIntegrationAsdListVO> list = dataIntegrationAsdDAO.selectDataIntegrationDtlListAo(dataIntegrationAsdListVO);
		//공존진단 설명 내용 추가
		CodeVO codeVO = new CodeVO();
		HashMap<String,String> cxtDetatilMap = new HashMap<String,String>();
		codeVO.setClassCd("CXTD1");
		List<CodeVO> cxtDetailList = codeDAO.selectCodeDetailSearchCondition(codeVO);
		for(CodeVO cvo : cxtDetailList) {
			if(!cxtDetatilMap.containsKey(cvo.getClassCdDtl())) {
				cxtDetatilMap.put(cvo.getClassCdDtl(), cvo.getClassCdDtlNm());
			}
		}
		String cxtDStrT="";
		String[] cxtDArr;
		String[] cxtArr;
		String cxtK = "";
		for(DataIntegrationAsdListVO dvo : list) {
			if(!StringUtil.isEmptyString(dvo.getCxtDetail())) {
				cxtDArr = dvo.getCxtDetail().split(",");
				cxtArr = dvo.getCxtDiag().split(",");
				cxtDStrT = "";
				for(int i=0; i<cxtArr.length; i++) {
					cxtK = cxtArr[i].trim();
					if(cxtDetatilMap.containsKey(cxtK)){
						cxtDStrT += cxtK+". "+cxtDetatilMap.get(cxtK);
						if("5".equals(cxtK) || "6".equals(cxtK) || "7".equals(cxtK)) {
							//정동장애, 불안장애, 기타 인 경우
							cxtDStrT += "("+cxtDArr[i]+")";
						}
						if(i!=cxtDArr.length-1) cxtDStrT += "<br/>";
					}
				}
				dvo.setCxtDetail(cxtDStrT);
			}
		}
		
		
		return list;
	}

	@Override
	public ExcelFile dataIntegrationAsdListExcelList(DataIntegrationAsdListVO dataIntegrationAsdListVO) {
		return  dataIntegrationAsdListExcelFileWriter.excelWrite(dataIntegrationAsdDAO.selectDataIntegrationAsdList(dataIntegrationAsdListVO), ExcelFile.XLSX);
	}
	
}
