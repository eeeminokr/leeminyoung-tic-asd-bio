package medical.dataIntegration.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import medical.common.service.AbstractService;
import medical.commoninfo.code.service.CodeVO;
import medical.commoninfo.code.service.impl.CodeDAO;
import medical.dataIntegration.service.DataIntegrationListVO;
import medical.dataIntegration.service.DataIntegrationService;
import medical.dataIntegration.service.DataIntegrationVO;
import medical.framework.file.ExcelFile;
import medical.framework.file.ExcelFileWriter;
import medical.framework.util.ResourceBundleUtil;
import medical.framework.util.StringUtil;
import medical.target.service.TargetVO;

@Service("DataIntegrationService")
public class DataIntegrationServiceImpl extends AbstractService implements DataIntegrationService{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/** DAO Class */
	@Resource(name = "DataIntegrationDAO")
	private DataIntegrationDAO dataIntegrationDAO;
	@Resource(name = "CodeDAO")
	private CodeDAO codeDAO;
	
	private ExcelFileWriter<DataIntegrationListVO> dataIntegrationListExcelFileWriter;

	public void setDataIntegrationListExcelFileWriter(
			ExcelFileWriter<DataIntegrationListVO> dataIntegrationListExcelFileWriter) {
		this.dataIntegrationListExcelFileWriter = dataIntegrationListExcelFileWriter;
	}
	
	
	public List<DataIntegrationVO> selectTicDocDtlList(DataIntegrationVO dataIntegrationVO) {
		return dataIntegrationDAO.selectTicDocDtlList(dataIntegrationVO);
	}
	public List<DataIntegrationVO> selectTicDocDtl(DataIntegrationVO dataIntegrationVO) {
		return dataIntegrationDAO.selectTicDocDtl(dataIntegrationVO);
	}
	@SuppressWarnings("unused")
	@Override
	public List<DataIntegrationListVO> selectDataIntegrationList(DataIntegrationListVO dataIntegrationListVO) {
		List<DataIntegrationListVO> list = dataIntegrationDAO.selectDataIntegrationList(dataIntegrationListVO);
		if(list.size() > 0) {
			String cntArr[] = null;
			int maxSeq = 1;
			int cntArrLen = 0;
			int wkCnt = 0;
			int wkCntTmp=0;
			for(DataIntegrationListVO vo : list) {
				wkCntTmp = 0;
				String cnt = vo.getPerformNm();
				
				if(cnt != null) cntArr = cnt.split(", ");
				for(String str : cntArr) {
					if(str.equals("4WK")||str.equals("8WK")||str.equals("12WK")) wkCntTmp++;
				}
				
				cntArrLen = cntArr.length;
				cntArrLen = cntArrLen-wkCntTmp;
				
				if(maxSeq < cntArrLen) {
					maxSeq = cntArrLen;
				}
				if(wkCnt < wkCntTmp ) wkCnt = wkCntTmp;
			}
			
			
			
			if(list == null || maxSeq < 2) maxSeq = 2;
			if(wkCnt == 0) wkCnt = 2;
			if(list != null) {
				list.get(0).setMaxSeq(maxSeq);
				list.get(0).setMaxSeq4wk(wkCnt);
			}
		}
		return list;
	}
	@Override
	public int selectDataIntegrationListTotal(DataIntegrationListVO dataIntegrationListVO) {
		return dataIntegrationDAO.selectDataIntegrationListTotal(dataIntegrationListVO);
	}
	@Override
	public ExcelFile dataIntegrationListExcelList(DataIntegrationListVO dataIntegrationListVO) {
		return  dataIntegrationListExcelFileWriter.excelWrite(dataIntegrationDAO.selectDataIntegrationList(dataIntegrationListVO), ExcelFile.XLSX);
	}
	
	public List<DataIntegrationListVO> selectDataIntegrationDtlList(DataIntegrationListVO dataIntegrationListVO) {
		
		
		List<DataIntegrationListVO> list = dataIntegrationDAO.selectDataIntegrationDtlList(dataIntegrationListVO);
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
		for(DataIntegrationListVO dvo : list) {
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
	
}
