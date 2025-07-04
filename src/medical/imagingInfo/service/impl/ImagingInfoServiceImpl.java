package medical.imagingInfo.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.IOD;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.ValidationResult;
import org.dcm4che3.io.DicomInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import medical.common.progress.ProgressDetails;
import medical.common.service.AbstractService;
import medical.common.service.CommonService;
import medical.commoninfo.member.service.MemberVO;
import medical.dataIntegration.service.DataIntegrationListVO;
import medical.dataIntegrationAsd.service.DataIntegrationAsdListVO;
import medical.framework.file.ExcelFile;
import medical.framework.file.ExcelFileReader;
import medical.framework.file.ExcelFileWriter;
import medical.framework.util.Constant;
import medical.framework.util.DateUtil;
import medical.framework.util.FileUtils;
import medical.framework.util.JsonUtils;
import medical.framework.util.ResourceBundleUtil;
import medical.framework.util.StringUtil;
import medical.framework.util.TarUtil;
import medical.framework.util.ZipUtil;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.ImageInfoVO;
import medical.imagingInfo.service.ImagingInfoService;
import medical.imagingInfo.service.ImagingTarFileVO;
import medical.imagingInfo.service.UpfileDecompVO;
import medical.imagingInfo.service.UpfileOriginVO;
import medical.imagingInfo.service.UploadExcelVO;

@Service("ImagingInfoService")
public class ImagingInfoServiceImpl extends AbstractService implements ImagingInfoService{
protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/** DAO Class */
	@Resource(name = "ImagingInfoDAO")
	ImagingInfoDAO oImagingInfoDAO;
	@Resource(name = "CommonService")
	private CommonService commonService;
	
	private ExcelFileReader<DataIntegrationListVO> imagingInfoFileReader;
	private ExcelFileReader<DataIntegrationAsdListVO> imagingInfoFileReader2;
	private ExcelFileWriter<ImageInfoVO> imagingInfoFileWriter;
	private ExcelFileWriter<ImageInfoVO> imagingInfoFileWriter2;

	public void setImagingInfoFileReader(ExcelFileReader<DataIntegrationListVO> imagingInfoFileReader) {
		this.imagingInfoFileReader = imagingInfoFileReader;
	}
	public void setImagingInfoFileReader2(ExcelFileReader<DataIntegrationAsdListVO> imagingInfoFileReader2) {
		this.imagingInfoFileReader2 = imagingInfoFileReader2;
	}

	public void setImagingInfoFileWriter(ExcelFileWriter<ImageInfoVO> imagingInfoFileWriter) {
		this.imagingInfoFileWriter = imagingInfoFileWriter;
	}
	public void setImagingInfoFileWriter2(ExcelFileWriter<ImageInfoVO> imagingInfoFileWriter2) {
		this.imagingInfoFileWriter2 = imagingInfoFileWriter2;
	}

	private static String docDir = ResourceBundleUtil.getResourceBundle("DorDir");
	private static String uploadPath = ResourceBundleUtil.getResourceBundle("ImagingOriginDir");
	private static String decompressPath = ResourceBundleUtil.getResourceBundle("ImagingDecompressDir");
	private static String imagingInfoPath = ResourceBundleUtil.getResourceBundle("ImagingClassifiDir");
	
	/****** Directory Naming ******/
	private static String asl = "ASL";	//01
	private static String dti = "DTI";	//02
	private static String fmri = "fMRI";	//03
	private static String t1 = "T1";		//04
	private static String t2 = "T2";		//05
	private static String etc = "Etc";	//06
	private static String swi = "SWI";
	
	private static String prefix = new String();
	
	private static List<String> zipPathList = null;
	
	private FileInputStream inputStream = null;
	private FileOutputStream outputStream = null;
	private FileChannel fcin = null;
	private FileChannel fcout = null;
	private IOD iod;
	
	private ExcelFileWriter<ImageInfoVO> imagingExcelFileWriter;
	
	public void setImagingExcelFileWriter(ExcelFileWriter<ImageInfoVO> imagingExcelFileWriter) {
		this.imagingExcelFileWriter = imagingExcelFileWriter;
	}
	//전체조회
	public List<ImageInfoVO> selectImageList(ImageInfoVO imageInfoVO){
		return oImagingInfoDAO.selectImageList(imageInfoVO);
	}
	//전체카운트
	public int selectImageListTotal(ImageInfoVO imageInfoVO) {
		return oImagingInfoDAO.selectImageListToTal(imageInfoVO);
	}
	public final void setIOD(IOD iod) {
        this.iod = iod;
    }
	
	public int insertDocFileInfo(DocFileVO oDocFileVO) {
		return oImagingInfoDAO.insertDocFileInfo(oDocFileVO);
	}
	public int deleteDocFileInfo(DocFileVO oDocFileVO) {
		return oImagingInfoDAO.deleteDocFileInfo(oDocFileVO);
	}
	public int insertImageInfoVO(ImageInfoVO oImageInfoVO) {
		return oImagingInfoDAO.insertImageInfoVO(oImageInfoVO);
	}
	public int insertUpfileOriginVO(UpfileOriginVO oUpfileOriginVO) {
		return oImagingInfoDAO.insertUpfileOriginVO(oUpfileOriginVO);
	}
	public int insertUpfileDecompVO(UpfileDecompVO oUpfileDecompVO) {
		return oImagingInfoDAO.insertUpfileDecompVO(oUpfileDecompVO);
	}
	public int insertTarFileInfo(ImagingTarFileVO oImagingTarFileVO) {
		return oImagingInfoDAO.insertTarFileInfo(oImagingTarFileVO);
	}
	public int deleteImageInfoVO(ImageInfoVO oImageInfoVO) {
		return oImagingInfoDAO.deleteImageInfoVO(oImageInfoVO);
	}
	public int deleteUpfileOriginVO(UpfileOriginVO oUpfileOriginVO) {
		return oImagingInfoDAO.deleteUpfileOriginVO(oUpfileOriginVO);
	}
	public int deleteUpfileDecompVO(UpfileDecompVO oUpfileDecompVO) {
		return oImagingInfoDAO.deleteUpfileDecompVO(oUpfileDecompVO);
	}
	public int deleteTarFileInfo(ImagingTarFileVO oImagingTarFileVO) {
		return oImagingInfoDAO.deleteTarFileInfo(oImagingTarFileVO);
	}
	public List<DocFileVO> selectDocFileInfo(DocFileVO oDocFileVO){
		return oImagingInfoDAO.selectDocFileInfo(oDocFileVO);
	}
	
	public boolean targetPdfUpload(HttpSession session, 
			MultipartFile file, 
			DocFileVO oDocFileVO) throws Exception {
		boolean tf = false;
		MemberVO memberVo = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		try {
			if (file != null) {
				String rndId = oDocFileVO.getRndId();
				//DocDir 내의 연구과제 폴더 생성
				String ddocDir = docDir + rndId;
				makeDir(ddocDir,"N");
				String fileName = new String();
				String fileExtension = new String();
				File targetZipFile = null;
				File targetPdfFile;
				String filePureName = new String();
				String[] nameSplit;
				String pdfSavePath = new String();
				fileName = file.getOriginalFilename();
				filePureName = fileName.substring(0,fileName.lastIndexOf("."));
				fileExtension = fileName.substring(fileName.lastIndexOf("."));
				if(".zip".equals(fileExtension)||".gz".equals(fileExtension)||".tar".equals(fileExtension)){
					targetZipFile = new File(uploadPath +fileName );
					ZipUtil.grantFileAuth(targetZipFile);
					file.transferTo(targetZipFile);
					
					// File Decompression
					ZipUtil.deleteDir(decompressPath+filePureName);
					File deCompressDir = new File(decompressPath+filePureName);
					if(".zip".equals(fileExtension))ZipUtil.unzip(targetZipFile, deCompressDir, false);
					else if(".gz".equals(fileExtension))ZipUtil.unGz(targetZipFile, deCompressDir, 2048);
					else if(".tar".equals(fileExtension))
						try {
							TarUtil.untar(targetZipFile, deCompressDir);
						} catch (Throwable e) {
							e.printStackTrace();
						}
//					File[] pdfList = deCompressDir.listFiles();
					List<File> fileList = listFiles(deCompressDir);
					File[] pdfList = fileList.toArray(new File[fileList.size()]);
					if(pdfList != null) {
						for(int p = 0 ; p < pdfList.length ; p++){
							File pFile = pdfList[p];
							fileName = pFile.getName();
							filePureName = fileName.substring(0,fileName.lastIndexOf("."));
							fileExtension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
							if(".pdf".equals(fileExtension)) {
								nameSplit = filePureName.split("_",3);
								if(nameSplit.length >= 3) {
									pdfSavePath = ddocDir
											+StringUtil.PathSep(nameSplit[0].toUpperCase())
											+StringUtil.PathSep(nameSplit[1].toUpperCase());
									makeDir(pdfSavePath,"N");
									targetPdfFile = new File(pdfSavePath +StringUtil.PathSep(fileName) );
									inputStream = new FileInputStream(pFile);
									outputStream = new FileOutputStream(targetPdfFile);
									fcin = inputStream.getChannel();
									fcout = outputStream.getChannel();
									long size = fcin.size();
									fcin.transferTo(0, size, fcout);
									if(fcin.isOpen())fcin.close();
									if(fcout.isOpen())fcout.close();
									ZipUtil.grantAuth(ddocDir);
									
									//pdf info insertion
									oDocFileVO.setPerformCntNm(nameSplit[1].toUpperCase());
									oDocFileVO.setTargetId(nameSplit[0].toUpperCase());
									oDocFileVO.setFileClassDtlNm(filePureName.substring(filePureName.indexOf(nameSplit[2])).toUpperCase());
									oDocFileVO.setFilePath(targetPdfFile.getAbsolutePath());
									oDocFileVO.setSessionUserId(memberVo.getUserId());
									if(deleteDocFileInfo(oDocFileVO)>-1)
										insertDocFileInfo(oDocFileVO);
								}
							}
						}
					}
					ZipUtil.deleteDir(deCompressDir.getAbsolutePath());
				}
				if(targetZipFile != null)targetZipFile.delete();
			}
			tf = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tf;
	}
	
	public List<File> listFiles(File deCompressDir ){
		List<File> fList = new ArrayList<File>();
		Stack<String> stack = new Stack<String>();
		try {
			// Traverse the directory in width-first manner, no-recursively
	    	String root = deCompressDir.getParent();
			stack.push(deCompressDir.getName());
			String current = new String();
			while (!stack.empty()) {
				current = (String) stack.pop();
	    		File curDir = new File(root, current);
	    		String[] fileList = curDir.list();
	    		if(fileList != null){
	    			for (String entry : fileList) {
	    				File f = new File(curDir, entry);
//	    				System.out.println("entry ===> "+ entry);
	    				if (f.isFile()) {
	    					if("PDF".equals(FilenameUtils.getExtension(entry).toUpperCase())) {
	    						fList.add(f);
	    					//	System.out.println("pdf File ===> "+ f.getName());
	    					}
	    				} else if (f.isDirectory()) {
					    	stack.push(current + File.separator + f.getName());
					    } else {
					    	throw new IOException("Unknown entry: " + f.getPath());
					    }
	    			}
	    		}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return fList;
	}
	
	public boolean dataUpload(List<MultipartFile> file, 
			ImageInfoVO oImageInfoVO, 
			ProgressDetails taskProgress) throws Exception {
		boolean tf = false;
		String classRst = new String();
		String rndId = oImageInfoVO.getRndId();
		String disClassDtl = oImageInfoVO.getDisClassDtl();
		FileOutputStream out = null;
        //성능향상을 위한 버퍼 스트림 사용
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        String taskId = oImageInfoVO.getTaskIdentity();
		try {
			String fileName = "";
			String fileExtension = "";
			String filePureName;
			// read the tadkId;
			taskProgress.setTaskId(taskId);
			if (file.size() > 0) {
				taskProgress.setzTotal(file.size());
				ProgressDetails.taskProgressHash.put(taskId, taskProgress);
				String timeStamp = DateUtil.getShortDateTimeStampString();
				String dicomUploadPath = new String();
				String dicomDecompressPath = new String();
				File targetFile;
				UpfileOriginVO oUpfileOriginVO = null;
				String[] fileInfo;
				String tarPureName = new String();
				File srcDir = null;
				int zFileCnt = 0;
				for(int i=0; i<file.size(); i++) {
					zipPathList = new ArrayList<String>();
					fileName = file.get(i).getOriginalFilename();
					filePureName = FilenameUtils.getBaseName(fileName);
					fileInfo = filePureName.split("_");
					if(fileInfo.length != 3) {
						ZipUtil.deleteDir(new File(file.get(i).getOriginalFilename()).getPath());
						throw new Exception("규격화된 파일명 형식이 아닙니다. 확인해 보시기 바랍니다.\n ex :  연구번호_차수_파일구분명.zip");
					}
					taskProgress.setzTotalProcessed(++zFileCnt);
					ProgressDetails.taskProgressHash.put(taskId, taskProgress);
					dicomUploadPath = ResourceBundleUtil.getDirIncludedInfo("ImagingOriginDir", "", fileInfo[0].toUpperCase(), timeStamp);
					dicomDecompressPath = ResourceBundleUtil.getDirIncludedInfo("ImagingDecompressDir", "", fileInfo[0].toUpperCase(), timeStamp);
					//업로드폴더 생성
					makeDir(dicomUploadPath,"N");
					//업로드파일압축해제 폴더 생성
					makeDir(dicomDecompressPath,"N");
					targetFile = new File(dicomUploadPath +StringUtil.PathSep(fileName) );
					file.get(i).transferTo(targetFile);
					ZipUtil.grantAuth(targetFile.getParentFile().getAbsolutePath());
					//insert origin table
					oUpfileOriginVO = new UpfileOriginVO();
					oUpfileOriginVO.setSessionUserId(oImageInfoVO.getSessionUserId());
					oUpfileOriginVO.setRndId(rndId);
					oUpfileOriginVO.setDisClassDtl(disClassDtl);
					oUpfileOriginVO.setPerformCntNm(fileInfo[1].toUpperCase());
					oUpfileOriginVO.setTargetId(fileInfo[0].toUpperCase());
					oUpfileOriginVO.setFilePath(targetFile.getAbsolutePath());
					oUpfileOriginVO.setRemarks("");
					insertUpfileOriginVO(oUpfileOriginVO);
					
					// File Decompression
					taskProgress.setTaskNum(1);
					ProgressDetails.taskProgressHash.put(taskId, taskProgress);
					srcDir = new File(dicomDecompressPath+StringUtil.PathSep(filePureName));
					fileExtension = FilenameUtils.getExtension(fileName).toUpperCase();
					if("ZIP".equals(fileExtension))ZipUtil.unzip(targetFile, srcDir, false);
					else if("GZ".equals(fileExtension))ZipUtil.unGz(targetFile, srcDir, 2048);
					else if("TAR".equals(fileExtension))
						try {
							TarUtil.untar(targetFile, srcDir);
						} catch (Throwable e) {
							e.printStackTrace();
						}
					
					//insert decompile table
//						oUpfileDecompVO = new UpfileDecompVO();
//						oUpfileDecompVO.setSessionUserId(oImageInfoVO.getSessionUserId());
//						oUpfileDecompVO.setRndId(rndId);
//						oUpfileDecompVO.setDisClassDtl(disClassDtl);
//						oUpfileDecompVO.setPerformCntNm(fileInfo[1]);
//						oUpfileDecompVO.setTargetId(fileInfo[0]);
//						oUpfileDecompVO.setDecompPath(srcDir.getAbsolutePath());
//						insertUpfileDecompVO(oUpfileDecompVO);
					
					// File Classification
					taskProgress.setTaskNum(2);
					taskProgress.setTaskId(taskId);
					oImageInfoVO.setTargetId(fileInfo[0].toUpperCase());
					oImageInfoVO.setPerformCntNm(fileInfo[1].toUpperCase());
					ProgressDetails.taskProgressHash.put(taskId, taskProgress);
					int instCnt = 0;
					prefix = oImageInfoVO.getTargetId()+"_"+oImageInfoVO.getPerformCntNm()+"_";
					classRst = dicomClassification(srcDir.getAbsolutePath(),
									targetFile.getAbsolutePath(), 
									oImageInfoVO,
									taskProgress, instCnt);
					taskProgress.setTaskNum(3);
					taskProgress.setTotalProcessed(0);
					ProgressDetails.taskProgressHash.put(taskId, taskProgress);
					
					/** zip file compression **/
					boolean bl = zipProcess(taskProgress, oImageInfoVO);

					if(bl && zipPathList.size() > 0) {
						//dicom directories delete
						for(String delPath : zipPathList)ZipUtil.deleteDir(delPath);
						tarPureName = file.get(i).getOriginalFilename().substring(0,file.get(i).getOriginalFilename().lastIndexOf("."));
						//create Tar File
						File targetDirFile = new File(zipPathList.get(0)).getParentFile();	//targetId Path
						File tarFile = new File(targetDirFile.getAbsolutePath()+StringUtil.PathSep(tarPureName+".tar"));
						File filePath = new File(zipPathList.get(0)).getParentFile();
						if(TarUtil.createTarArchive(tarFile, filePath.listFiles())) {
							//Insertion Tar File info
							ImagingTarFileVO oImagingTarFileVO = new ImagingTarFileVO();
							oImagingTarFileVO.setSessionUserId(oImageInfoVO.getSessionUserId());
							oImagingTarFileVO.setRndId(rndId);
							oImagingTarFileVO.setDisClassDtl(disClassDtl);
							oImagingTarFileVO.setPerformNm(fileInfo[1].toUpperCase());
							oImagingTarFileVO.setTargetId(fileInfo[0].toUpperCase());
							oImagingTarFileVO.setFilePath(tarFile.getAbsolutePath());
							insertTarFileInfo(oImagingTarFileVO);
						}
					}
					//decompression 폴더 삭제. 용량관리를 위해 삭제하기로 함 20200316 Martin Jang
					if(srcDir != null) {
						ZipUtil.grantAuth(srcDir.getParentFile().getParentFile().getAbsolutePath());
						ZipUtil.deleteDir(srcDir.getParentFile().getParentFile().getAbsolutePath());
					}	
				}	//for end
			}
			if("0".equals(classRst))tf = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bout!=null)bout.close();
		    if (out != null)out.close();
		    if(bin!=null)bin.close();
		}
		return tf;
	}
	
	/**
	 * Dicom File Classification Main Process
	 * @param sourcPath
	 * 
	 */	
	public String dicomClassification(String sourcPath, 
			String orginPath, 
			ImageInfoVO oImageInfoVO,
			ProgressDetails taskProgress,
			int instCnt){
		String[] tagResult = new String[3];
		String seriesDescription = null;
		String protocolNm = null;
		String suffix = null;
		File dir = new File(sourcPath);
		File[] fileList = dir.listFiles();
		String savePath;
		String rst = "0";
		String taskId = oImageInfoVO.getTaskIdentity();
		String disClassDtl = oImageInfoVO.getDisClassDtl();
		try{
			if(fileList != null) {
		        taskProgress.setTotal(fileList.length);
		        ProgressDetails.taskProgressHash.put(taskId, taskProgress);
				for(int i = 0 ; i < fileList.length ; i++){
					File file = fileList[i];
					savePath = imagingInfoPath + oImageInfoVO.getRndId();
					if(file.isFile()){
						if(isDicomFile(file)) {
							tagResult = getTagInfo(file);
							
						
							
							seriesDescription = tagResult[0].toUpperCase();
							System.out.println("DICOM 파일 이름 ############>>>>>>> : "+file.getName());
							System.out.println("시리즈디스크립션name **********>>>> : "+seriesDescription);
					
							protocolNm = tagResult[2].toUpperCase();
							System.out.println("프로토콜name ---------> :"+protocolNm);
							if(instCnt == 0) {
			                	oImageInfoVO.setStudyDate(tagResult[1]);
			                	instCnt = oImagingInfoDAO.updateMriDate(oImageInfoVO);
			                }
			                //아이디가 불일치하는 경우
/*			                if (!targetId.equals(candId)) {
			                	System.out.println("targetId : " + targetId + " , candId : "+candId);
			                	UpfileDecompVO oUpfileDecompVO = new UpfileDecompVO();
			                	oUpfileDecompVO.setRndId(rndId);
			                	oUpfileDecompVO.setYyyy(yyyy);
			                	oUpfileDecompVO.setPerformCnt(performCnt);
			                	oUpfileDecompVO.setTargetId(targetId);
			                	oImagingInfoService.deleteUpfileDecompVO(oUpfileDecompVO);
			                	ZipUtil.deleteDir(sourcPath);
			                	UpfileOriginVO oUpfileOriginVO = new UpfileOriginVO();
			                	oUpfileOriginVO.setRndId(rndId);
			                	oUpfileOriginVO.setYyyy(yyyy);
			                	oUpfileOriginVO.setPerformCnt(performCnt);
			                	oUpfileOriginVO.setTargetId(targetId);
			                	oImagingInfoService.deleteUpfileOriginVO(oUpfileOriginVO);
			                	ZipUtil.deleteDir(orginPath);
			                	throw new Exception("대상자ID("+targetId+")와  PatiendID("+candId+")가 불일치합니다. 확인해 보시기 바랍니다.");
							} */
			                savePath += StringUtil.PathSep(oImageInfoVO.getTargetId())+StringUtil.PathSep(oImageInfoVO.getPerformCntNm());
			                makeDir(savePath,"N");
			                /** Medical Imaging Information Classification */
			                if(seriesDescription.indexOf("EP2D_TRA_PASL")!=-1)suffix = asl + StringUtil.PathSep(prefix+"ASL_ep2d_tra_PASL");
							else if(seriesDescription.indexOf("MOCOSERIES")!=-1
									&& protocolNm.indexOf("EP2D_TRA_PASL_64_81_TI2=1800")!=-1)suffix = asl + StringUtil.PathSep(prefix+"ASL_MoCoSeries");
							else if(seriesDescription.indexOf("PERFUSION")!=-1)suffix = asl + StringUtil.PathSep(prefix+"ASL_Perfusion");
							else if(seriesDescription.indexOf("DTI")!=-1) {
								if(seriesDescription.indexOf("ADC")!=-1)suffix = dti + StringUtil.PathSep(prefix+"dti_ADC");
								else if(seriesDescription.indexOf("COLFA")!=-1)suffix = dti + StringUtil.PathSep(prefix+"dti_ColFA");
								else if(seriesDescription.indexOf("EXP")!=-1)suffix = dti + StringUtil.PathSep(prefix+"dti_EXP");
								else if(seriesDescription.indexOf("FA")!=-1)suffix = dti + StringUtil.PathSep(prefix+"dti_FA");  //prefix => 3
								else if(seriesDescription.indexOf("TRACEW")!=-1)suffix = dti + StringUtil.PathSep(prefix+"dti_TRACEW");
								else suffix = dti + StringUtil.PathSep(prefix+"dti");
							    
								
							}
							else if(seriesDescription.indexOf("MOCOSERIES")!=-1
									&& protocolNm.indexOf("RFMRI_190PHASE_EP2D_BOLD_MOCO")!=-1)suffix = fmri + StringUtil.PathSep(prefix+"fMRI_MoCoseries");
							else if(seriesDescription.indexOf("RFMRI_190PHASE_EP2D_BOLD_MOCO")!=-1)suffix = fmri + StringUtil.PathSep(prefix+"fMRI");
							else if(seriesDescription.indexOf("T1_MPR_SAG_P2_ISO")!=-1)suffix = t1 + StringUtil.PathSep(prefix+"T1_sag");
							else if(seriesDescription.indexOf("T1_MPR_TRA_P2_ISO")!=-1)suffix = t1 + StringUtil.PathSep(prefix+"T1_tra");
							else if(seriesDescription.indexOf("PHA_IMAGES")!=-1)suffix = t2 + StringUtil.PathSep(prefix+"T2_Pha_images");
							else if(seriesDescription.indexOf("SWI_IMAGES")!=-1)suffix = t2 + StringUtil.PathSep(prefix+"T2_SWI");
							else if(seriesDescription.indexOf("RELCBF")!=-1)suffix = t2 + StringUtil.PathSep(prefix+"T2_relCBF");
							else if(seriesDescription.indexOf("AX_T2_TSE")!=-1)suffix = t2 + StringUtil.PathSep(prefix+"ASL_Perfusion");
							else{
								System.out.println("Etc 파일 이름 = " + file.getName());
								System.out.println("SeriesDescription = " + seriesDescription);
								suffix = etc + StringUtil.PathSep(prefix+"etc");
							}
			                if("DS003".equals(disClassDtl) && seriesDescription.indexOf("SWI_IMAGES")!=-1)suffix = swi + StringUtil.PathSep(prefix+"SWI");
							/** DicomFile Classification */
							if(oImageInfoVO.getTargetId() != null) {
								savePath += StringUtil.PathSep(suffix);
								if(makeDir(savePath,"Y"))classDicomFileDcm4che3(savePath, file, suffix, oImageInfoVO);
							}
						}
						taskProgress.setTotalProcessed(i+1);
						taskProgress.setTotal(fileList.length);
						ProgressDetails.taskProgressHash.put(taskId, taskProgress);
					}else if(file.isDirectory()){
//						System.out.println("디렉토리 이름 : " + file.getName());
						// 서브디렉토리가 존재하면 재귀적 방법으로 다시 탐색
						dicomClassification(file.getAbsolutePath(), 
								orginPath, 
								oImageInfoVO, 
								taskProgress, instCnt); 
					}
//					System.out.println("process Time : " +classiDicomWatch.toString()+" , NO : " + i + " , source file : " + file.getName());
				}	//end for
						
						/** create mnc image */
/*						if(subDirs[i].isDirectory() && subDirs[i].getName().indexOf("_jpg")==-1) {
							String dname = subDirs[i].getParentFile().getName();
							String fname = subDirs[i].getName();
							String inputList = subDirs[i].getAbsolutePath();
							File mncDir = new File(this.mincDir);
							if(!mncDir.exists())mncDir.mkdir();
							String cmd = "dcm2mnc -debug -usecoordinates " + inputList 
									+" -dname "+ dname 
									+" -fname " + fname
									+" " + mncDir.getAbsolutePath();
					    	System.out.println("cmd ===> " + cmd);
					    	Runtime rt = Runtime.getRuntime();
					    	Process p = null;
					    	try {
					    			p = rt.exec(cmd);
					    			
					    			int rst = p.waitFor();
					    			System.out.println("p.waitFor() ===> " + rst);
					    			
					    	    } catch (InterruptedException e1) {
					    		  e1.printStackTrace();
					    	    }
						}	 // create mnc image finish
						
					}	//for end
				}*/
			}else {
				System.out.println(dir + " 데이터가 존재하지 않습니다.");
			}
		}catch(Exception e){
			rst = oImageInfoVO.getTargetId();
		}
		return rst;
	}
	
	/**
	 * Classification process For Dcm4che3
	 * @param conn
	 * @param finalPath
	 * @param srcFile
	 * @param medicId
	 * @param suffix
	 */
	private void classDicomFileDcm4che3(String finalPath, File srcFile, String suffix, ImageInfoVO oImageInfoVO) {
		try {
			File destFile = new File(makeFileName(finalPath,srcFile.getName()));
			inputStream = new FileInputStream(srcFile);
			outputStream = new FileOutputStream(destFile);
			fcin = inputStream.getChannel();
			fcout = outputStream.getChannel();
			long size = fcin.size();
			fcin.transferTo(0, size, fcout);
			if(fcin.isOpen())fcin.close();
			if(fcout.isOpen())fcout.close();
			
			/** Dicom Tags Info */
			DicomInputStream din = new DicomInputStream(destFile);
			Attributes dataset = din.readDataset(-1, -1);
	        din.close();
	        
	        if(!etc.equals(suffix)) {
	        	/** DB Insert start */
				oImageInfoVO.setPath(finalPath.substring(0,finalPath.lastIndexOf("/")));
				oImageInfoVO.setModality(StringUtil.NVL(dataset.getString(Tag.Modality),""));
				oImageInfoVO.setMnuFactr(StringUtil.NVL(dataset.getString(Tag.Manufacturer),""));
				oImageInfoVO.setInstNm(StringUtil.NVL(dataset.getString(Tag.InstitutionName),""));
				oImageInfoVO.setSeriesDesc(StringUtil.NVL(dataset.getString(Tag.SeriesDescription),""));
				oImageInfoVO.setMnufactrMdnm(StringUtil.NVL(dataset.getString(Tag.ManufacturerModelName),""));
				oImageInfoVO.setMgfStrength(StringUtil.NVL(dataset.getString(Tag.MagneticFieldStrength),"0"));
				oImageInfoVO.setStudyDate(StringUtil.NVL(dataset.getString(Tag.StudyDate),""));
				oImageInfoVO.setPatientId(dataset.getString(Tag.PatientID));
				oImageInfoVO.setPatientSex(StringUtil.NVL(dataset.getString(Tag.PatientSex),""));
				oImageInfoVO.setPatientAge(dataset.getString(Tag.PatientAge));
				oImageInfoVO.setSeriesId(suffix.substring(0,suffix.lastIndexOf("/")));
				insertImageInfoVO(oImageInfoVO);
	        	/** DB Insert end */
	        }
	        ZipUtil.grantFileAuth(destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String makeFileName(String path, String fileNm) {
		String rst = new String();
		File oFile;
		try {
			while(true) {
				oFile = new File(path+StringUtil.PathSep(fileNm));
				if(!oFile.exists()) {
					break;
				}else {
					fileNm += Math.random()*100+1;
				}
			}
			rst = path+StringUtil.PathSep(fileNm);
		}catch(Exception e) {
			
		}
		return rst;
	}
	
	public String[] getTagInfo(File file) {
		String seriesDescription = new String();
		String studyDate = new String();
		String protocolNm = new String();
		String[] results = new String[3];
		try {
			DicomInputStream din = new DicomInputStream(file);
			Attributes dataset = din.readDataset(-1, -1);
			din.close();
			seriesDescription = dataset.getString(org.dcm4che3.data.Tag.SeriesDescription, null);
			if(seriesDescription == null)seriesDescription = dataset.getString(org.dcm4che3.data.Tag.ProtocolName, null);
			studyDate = dataset.getString(org.dcm4che3.data.Tag.StudyDate, null);
			if(studyDate != null)studyDate = studyDate.replaceAll("-", "");
			protocolNm = dataset.getString(org.dcm4che3.data.Tag.ProtocolName,null);
			results[0] = seriesDescription;
			results[1] = studyDate;
			results[2] = protocolNm;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
    String iodFile = ResourceBundleUtil.getResourceBundle("DicomDirIodFilePath");
    public boolean isDicomFile(File oFile){
    	boolean tf = false;
    	DicomInputStream dis = null;
    	try {
    		 setIOD(IOD.load(iodFile));
    		 if (iod == null) {
    //			 System.out.println("iodFile path ===> "+ iodFile);
    			 throw new IllegalStateException("IOD not initialized");
    		 }
    	     dis = new DicomInputStream(oFile);
    	     Attributes attrs = dis.readDataset(-1, -1);
    	     if(dis!=null)dis.close();
             ValidationResult result = attrs.validate(iod);
             if (result.isValid()) {
//            	 System.out.println("OK Dicom File ");
                 tf = true;
             }else {
//                 System.out.println(result.asText(attrs));
//                 System.out.println("FAILED Dicom File ");
//                 System.out.println(oFile.getAbsolutePath());
             }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return tf;
    }
    
	public boolean zipProcess(ProgressDetails taskProgress, ImageInfoVO oImageInfoVO) {
		String zipName = "";
		boolean tf = false;
		String taskId = oImageInfoVO.getTargetId();
		try {
			if(zipPathList.size() > 0) {
				taskProgress.setmTotal(zipPathList.size());
				String[] arry = zipPathList.toArray(new String[zipPathList.size()]);
				for(int i = 0 ; i < arry.length ; i++) {
					File pathFile = new File(arry[i]);
					ZipUtil.grantAuth(pathFile.getAbsolutePath());
					zipName = pathFile.getName();
					taskProgress.setmTotalProcessed(i+1);
					ProgressDetails.taskProgressHash.put(taskId, taskProgress);
					ZipUtil.makeZip(pathFile.getParentFile().getAbsolutePath(), zipName, taskProgress, taskId);
				}
			}
			tf = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tf;
	}
	
	/**
	 * Directory maker
	 * @param createPath
	 */
	public static boolean makeDir(String createPath, String addYn) {
		Path path = Paths.get(createPath);
		boolean tf = false;
		String zipPath = new String();
		try {
			if(!Files.exists(path)) {
				Files.createDirectories(path);
				Files.setPosixFilePermissions(path, PosixFilePermissions.fromString("rwxrwxrwx"));
				if("Y".equals(addYn)) {
//					zipPath = createPath.indexOf(etc)!=-1?createPath:createPath.substring(0,createPath.lastIndexOf("/"));
					zipPath = createPath.substring(0,createPath.lastIndexOf("/"));
					if(!zipPathList.contains(zipPath))zipPathList.add(zipPath);
				}
		    	tf = true;
			}else tf = true;
		}catch(Exception e) {
			tf =false;
			e.printStackTrace();
		}
		return tf;
	}
	
	@RequestMapping("/medical/imagingInfo/fileDownload.do")
	public ModelAndView fileDownload(HttpSession session,
			@RequestParam("path") String path,
			@RequestParam("fileType") String fileType,
			ModelMap model) throws Exception {
		File oFile = new File(path);
		try {
			if(oFile.exists()) {
				model.put("success", true);
			}else {
				model.put("success", false);
			}
		}catch(Exception e) {
			model.put("success", false);
			e.printStackTrace();
		}
		model.put("success", true);
		return 	JsonUtils.describe(model);
	}
	
	public void completeDel(String rndId, String disClassDtl, String targetId) {
		ZipUtil.deleteDir(docDir+rndId+StringUtil.PathSep(targetId));
		ZipUtil.deleteDir(uploadPath+StringUtil.PathSep(targetId));
		ZipUtil.deleteDir(imagingInfoPath+rndId+StringUtil.PathSep(targetId));
		DocFileVO oDocFileVO = new DocFileVO();
		oDocFileVO.setRndId(rndId);
		oDocFileVO.setDisClassDtl(disClassDtl);
		oDocFileVO.setTargetId(targetId);
		deleteDocFileInfo(oDocFileVO);
		ImagingTarFileVO oImagingTarFileVO = new ImagingTarFileVO();
		oImagingTarFileVO.setRndId(rndId);
		oImagingTarFileVO.setDisClassDtl(disClassDtl);
		oImagingTarFileVO.setTargetId(targetId);
		deleteTarFileInfo(oImagingTarFileVO);
		ImageInfoVO oImageInfoVO = new ImageInfoVO();
		oImageInfoVO.setRndId(rndId);
		oImageInfoVO.setDisClassDtl(disClassDtl);
		oImageInfoVO.setTargetId(targetId);
		deleteImageInfoVO(oImageInfoVO);
		UpfileOriginVO oUpfileOriginVO = new UpfileOriginVO();
		oUpfileOriginVO.setRndId(rndId);
		oUpfileOriginVO.setDisClassDtl(disClassDtl);
		oUpfileOriginVO.setTargetId(targetId);
		deleteUpfileOriginVO(oUpfileOriginVO);
	}
	
	public int updateBlankMriDate(ImageInfoVO oImageInfoVO) {
		return oImagingInfoDAO.updateBlankMriDate(oImageInfoVO);
	} 
	public int deleteImagingInfo(ImageInfoVO oImageInfoVO) {
		return oImagingInfoDAO.deleteImagingInfo(oImageInfoVO);
	} 
	
	
	
	
	
	//대상자정보 에서 쓰임 
	public void removeImagingInfoByPerformCnt(ImageInfoVO oImageInfoVO) {
		String rndId = new String();
		String targetId = new String();
		String disClassDtl = new String();
		String performCntNm = new String();
		try {
			if(oImageInfoVO != null) {
				if(!"".equals(oImageInfoVO.getRndId())
						&& !"".equals(oImageInfoVO.getTargetId())
						&& !"".equals(oImageInfoVO.getDisClassDtl())
						&& !"".equals(oImageInfoVO.getPerformCntNm())) {
					rndId = oImageInfoVO.getRndId();
					targetId = oImageInfoVO.getTargetId();
					disClassDtl = oImageInfoVO.getDisClassDtl();
					performCntNm = oImageInfoVO.getPerformCntNm().toUpperCase();
					ZipUtil.grantAuth(imagingInfoPath+rndId+StringUtil.PathSep(targetId));
					ZipUtil.deleteDir(imagingInfoPath+rndId+StringUtil.PathSep(targetId) + StringUtil.PathSep(performCntNm));
					deleteImageInfoVO(oImageInfoVO);
					ZipUtil.grantAuth(docDir+rndId+StringUtil.PathSep(targetId));
					ZipUtil.deleteDir(docDir+rndId+StringUtil.PathSep(targetId) + StringUtil.PathSep(performCntNm));
					DocFileVO oDocFileVO = new DocFileVO();
					oDocFileVO.setRndId(rndId);
					oDocFileVO.setDisClassDtl(disClassDtl);
					oDocFileVO.setTargetId(targetId);
					oDocFileVO.setPerformCntNm(performCntNm);
					deleteDocFileInfo(oDocFileVO);
					UpfileOriginVO oUpfileOriginVO = new UpfileOriginVO();
					oUpfileOriginVO.setRndId(rndId);
					oUpfileOriginVO.setDisClassDtl(disClassDtl);
					oUpfileOriginVO.setTargetId(targetId);
					oUpfileOriginVO.setPerformCntNm(performCntNm);
					List<UpfileOriginVO> oList = selectUpfileOrigin(oUpfileOriginVO);
					if(oList != null) {
						File oFile;
						ZipUtil.grantAuth(uploadPath+StringUtil.PathSep(targetId));
						for(UpfileOriginVO fUpfileOriginVO : oList) {
							oFile = new File(fUpfileOriginVO.getFilePath());
							ZipUtil.deleteDir(uploadPath+StringUtil.PathSep(targetId)
							+StringUtil.PathSep(oFile.getParentFile().getName()));
						}
					}
					deleteUpfileOriginVO(oUpfileOriginVO);
					ImagingTarFileVO imagingTarFileVO = new ImagingTarFileVO();
					imagingTarFileVO.setRndId(rndId);
					imagingTarFileVO.setDisClassDtl(disClassDtl);
					imagingTarFileVO.setTargetId(targetId);
					imagingTarFileVO.setPerformCntNm(performCntNm);
					oImagingInfoDAO.deleteTarFileInfo(imagingTarFileVO);
				}
				File oFile = new File(imagingInfoPath+rndId+StringUtil.PathSep(targetId));
				if(oFile.exists()) {
					File[] files1 = oFile.listFiles();
					if(files1.length == 0)oFile.delete();
				}
				File iFile = new File(uploadPath+targetId);
				if(iFile.exists()) {
					File[] files2 = iFile.listFiles();
					if(files2.length == 0)iFile.delete();
				}
				File dFile = new File(docDir+rndId+StringUtil.PathSep(targetId));
				if(dFile.exists()) {
					File[] files3 = dFile.listFiles();
					if(files3.length == 0)dFile.delete();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteImagingInfoByPerformCnt(ImageInfoVO oImageInfoVO) {
		
		String rndId = oImageInfoVO.getRndId();
		String targetId = new String();
		String disClassDtl = new String();
		String performCntNm = new String();
		try {
			if(oImageInfoVO != null) { 
				if(!"".equals(oImageInfoVO.getRndId())
						&& !"".equals(oImageInfoVO.getTargetId())
						&& !"".equals(oImageInfoVO.getDisClassDtl())
						&& !"".equals(oImageInfoVO.getPerformCntNm())) {
					targetId = oImageInfoVO.getTargetId();
					disClassDtl = oImageInfoVO.getDisClassDtl();
					performCntNm = oImageInfoVO.getPerformCntNm().toUpperCase();
					File pFile = new File(imagingInfoPath+rndId+StringUtil.PathSep(targetId) + StringUtil.PathSep(performCntNm));
					ZipUtil.grantAuth(pFile.getParentFile().getAbsolutePath());
					ZipUtil.deleteDir(pFile.getAbsolutePath());
					if(pFile.getParentFile().listFiles() != null) {
						if(pFile.getParentFile().listFiles().length == 0)ZipUtil.deleteDir(pFile.getParentFile().getAbsolutePath());
					}
					deleteImageInfoVO(oImageInfoVO);
					UpfileOriginVO oUpfileOriginVO = new UpfileOriginVO();
					ImagingTarFileVO imagingTarFileVO = new ImagingTarFileVO();
					oUpfileOriginVO.setRndId(rndId); imagingTarFileVO.setRndId(rndId);
					oUpfileOriginVO.setDisClassDtl(disClassDtl); imagingTarFileVO.setDisClassDtl(disClassDtl);
					oUpfileOriginVO.setTargetId(targetId); imagingTarFileVO.setTargetId(targetId);
					oUpfileOriginVO.setPerformCntNm(performCntNm); imagingTarFileVO.setPerformCntNm(performCntNm);
					List<UpfileOriginVO> oList = selectUpfileOrigin(oUpfileOriginVO);
					if(oList != null) {
						File oFile;
						File targetDir;
						File[] child;
						for(UpfileOriginVO fUpfileOriginVO : oList) {
							oFile = new File(fUpfileOriginVO.getFilePath());
							if(oFile.exists()) {
								ZipUtil.grantAuth(oFile.getParentFile().getAbsolutePath());
								ZipUtil.deleteDir(oFile.getParentFile().getAbsolutePath());
								targetDir = new File(oFile.getParentFile().getParentFile().getAbsolutePath());
								child = targetDir.listFiles();
								if(child != null) {
									if(child.length == 0) {
										ZipUtil.grantAuth(targetDir.getAbsolutePath());
										ZipUtil.deleteDir(targetDir.getAbsolutePath());
									}
								}
							}
						}
					}
					oImagingInfoDAO.deleteUpfileOriginVO(oUpfileOriginVO);
					oImagingInfoDAO.deleteTarFileInfo(imagingTarFileVO);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<UpfileOriginVO> selectUpfileOrigin(UpfileOriginVO oUpfileOriginVO){
		return oImagingInfoDAO.selectUpfileOrigin(oUpfileOriginVO);
	}
	
	public void deleteDocFile(DocFileVO oDocFileVO) {
		List<DocFileVO> oList = new ArrayList<DocFileVO>();
		File oFile;
		try {
			oList = selectDocFileInfo(oDocFileVO);
			if(oList.size() > 0) {
				for(DocFileVO df : oList) {
					oFile = new File(df.getFilePath());
					if(oFile.delete())deleteDocFileInfo(oDocFileVO);
					File[] files = oFile.getParentFile().listFiles();
					if(files.length==0) {
						oFile.getParentFile().delete();
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<UploadExcelVO> selectUploadExcelInfo(UploadExcelVO oUploadExcelVO){
		return oImagingInfoDAO.selectUploadExcelInfo(oUploadExcelVO);
	}
	public int insertUploadExcelInfo(UploadExcelVO oUploadExcelVO) {
		return oImagingInfoDAO.insertUploadExcelInfo(oUploadExcelVO);
	}
	public int deleteUploadExcelInfo(UploadExcelVO oUploadExcelVO) {
		return oImagingInfoDAO.deleteUploadExcelInfo(oUploadExcelVO);
	}
	public int updateImagingInfo(DataIntegrationListVO oDataIntegrationListVO) {
		return oImagingInfoDAO.updateImagingInfo(oDataIntegrationListVO);
	}
	public int updateAsdImagingInfo(DataIntegrationAsdListVO dataIntegrationAsdListVO) {
		return oImagingInfoDAO.updateAsdImagingInfo(dataIntegrationAsdListVO);
	}
	
	//엑셀 다운로드
	public ExcelFile imagingExcelDownload(ImageInfoVO imageInfoVO) {
		return imagingInfoFileWriter.excelWrite(oImagingInfoDAO.selectImageList(imageInfoVO), ExcelFile.XLSX);
	}
	public ExcelFile imagingExcelDownload2(ImageInfoVO imageInfoVO) {
		return imagingInfoFileWriter2.excelWrite(oImagingInfoDAO.selectImageList(imageInfoVO), ExcelFile.XLSX);
	}
	
	public boolean imagingExcelFileUpload(MultipartFile file, 
			DataIntegrationListVO oDataIntegrationListVO,
			DataIntegrationAsdListVO dataIntegrationAsdListVO,
			ProgressDetails taskProgress) throws Exception {
		boolean tf = false;
		// read the tadkId;
		String taskId = oDataIntegrationListVO.getRndId();
		String disClassDtl = oDataIntegrationListVO.getDisClassDtl();	
		try {
			if (file != null) {
				taskProgress.setTaskNum(5);
				ProgressDetails.taskProgressHash.put(taskId, taskProgress);
				String fileName = file.getOriginalFilename();
				String fileExtension = fileName.substring(fileName.lastIndexOf("."));
				String fileNameWOExtenstion = fileName.substring(0, fileName.lastIndexOf("."));
				String docDir = ResourceBundleUtil.getResourceBundle("DorDir");
				String uploadExcelPath = docDir + "Excel";
				
				if (!FileUtils.makeDir(uploadExcelPath)) {
					throw new Exception(uploadExcelPath + " 폴더 생성이 실패하였습니다. 관리자에게 문의하세요.");
				}
				UploadExcelVO oUploadExcelVO = new UploadExcelVO();
				oUploadExcelVO.setRndId(oDataIntegrationListVO.getRndId());
				oUploadExcelVO.setDisClassDtl(oDataIntegrationListVO.getDisClassDtl());
				oUploadExcelVO.setFileClassDtl(oDataIntegrationListVO.getFileClassDtl());
				List<UploadExcelVO> oList = new ArrayList<UploadExcelVO>();
				oList = oImagingInfoDAO.selectUploadExcelInfo(oUploadExcelVO);
				if(oList.size() != 0) {
					new File(oList.get(0).getFilePath()).delete();
					oImagingInfoDAO.deleteUploadExcelInfo(oUploadExcelVO);
					
				}
				File temp = null;
				if("DS003".equals(disClassDtl)) {
				 temp = new File(uploadExcelPath + StringUtil.PathSep(fileNameWOExtenstion) + "__"
						+ dataIntegrationAsdListVO.getFileClassDtl() + fileExtension);
				
				file.transferTo(temp);
				}else {
					 temp = new File(uploadExcelPath + StringUtil.PathSep(fileNameWOExtenstion) + "__"
							+ oDataIntegrationListVO.getFileClassDtl() + fileExtension);
					
					file.transferTo(temp);
				}
				
				oUploadExcelVO.setFilePath(temp.getAbsolutePath());
				oUploadExcelVO.setSessionUserId(oDataIntegrationListVO.getSessionUserId());
				oImagingInfoDAO.insertUploadExcelInfo(oUploadExcelVO);
				
				if("DS003".equals(disClassDtl)) {
					excelAsdDataUpload(temp,dataIntegrationAsdListVO);
				}else {
					excelDataUpload(temp, oDataIntegrationListVO);			
				}
		
				//파일삭제
				if( temp.exists() ){
					if(temp.delete()){ System.out.println("파일삭제 성공"); }else{ System.out.println("파일삭제 실패"); }

				}
			}
			tf = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tf;
	}
	
	/*
	public boolean imagingAsdExcelFileUpload(MultipartFile file, 
			DataIntegrationAsdListVO dataIntegrationAsdListVO,
			ProgressDetails taskProgress) throws Exception {
		boolean tf = false;
		// read the tadkId;
		String taskId = dataIntegrationAsdListVO.getRndId();
		String disClassDtl = dataIntegrationAsdListVO.getDisClassDtl();	
		try {
			if (file != null) {
				taskProgress.setTaskNum(5);
				ProgressDetails.taskProgressHash.put(taskId, taskProgress);
				String fileName = file.getOriginalFilename();
				String fileExtension = fileName.substring(fileName.lastIndexOf("."));
				String fileNameWOExtenstion = fileName.substring(0, fileName.lastIndexOf("."));
				String docDir = ResourceBundleUtil.getResourceBundle("DorDir");
				String uploadExcelPath = docDir + "Excel";
//				if (!FileUtils.makeDir(uploadExcelPath)) {
//					throw new Exception(uploadExcelPath + " 폴더 생성이 실패하였습니다. 관리자에게 문의하세요.");
//				}
//				UploadExcelVO oUploadExcelVO = new UploadExcelVO();
//				oUploadExcelVO.setRndId(oDataIntegrationListVO.getRndId());
//				oUploadExcelVO.setDisClassDtl(oDataIntegrationListVO.getDisClassDtl());
//				oUploadExcelVO.setFileClassDtl(oDataIntegrationListVO.getFileClassDtl());
//				List<UploadExcelVO> oList = new ArrayList<UploadExcelVO>();
//				oList = oImagingInfoDAO.selectUploadExcelInfo(oUploadExcelVO);
//				if(oList.size() != 0) {
//					new File(oList.get(0).getFilePath()).delete();
//					oImagingInfoDAO.deleteUploadExcelInfo(oUploadExcelVO);
//					
//				}
				File temp = new File(uploadExcelPath + StringUtil.PathSep(fileNameWOExtenstion) + "__"
						+ dataIntegrationAsdListVO.getFileClassDtl() + fileExtension);
				
				file.transferTo(temp);
//				oUploadExcelVO.setFilePath(temp.getAbsolutePath());
//				oUploadExcelVO.setSessionUserId(oDataIntegrationListVO.getSessionUserId());
//				oImagingInfoDAO.insertUploadExcelInfo(oUploadExcelVO);
			
				excelAsdDataUpload(temp,dataIntegrationAsdListVO);
				//파일삭제
				if( temp.exists() ){
					if(temp.delete()){ System.out.println("ASD 파일삭제 성공"); }else{ System.out.println("ASD 파일삭제 실패"); }

				}
			}
			tf = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tf;
	}
	
	*/
	
	//DS001
	public int excelDataUpload(File file, DataIntegrationListVO oDataIntegrationListVO) throws Exception {
		
		
		int result = 0;
		String disClassDtl1 = oDataIntegrationListVO.getDisClassDtl();
//	String disClassDtl2= dataIntegrationAsdListVO.getDisClassDtl();
		System.out.println("영상(excelDataUpload) disClassDtl name -----> : "+disClassDtl1);
//		System.out.println("영상(excelAsdDataUpload) disClassDtl name -----> : "+disClassDtl2);
		
		
		
	
		try {
//			if("DS001".equals(disClassDtl1)) {
				List<DataIntegrationListVO> excelList1 = null;	
				excelList1 = imagingInfoFileReader.excelRead(file);
	
		//  	else excelList = imagingInfoFileReader2.excelRead(file);
			for(DataIntegrationListVO dv : excelList1) {
				dv.setRndId(oDataIntegrationListVO.getRndId());
				dv.setDisClassDtl(oDataIntegrationListVO.getDisClassDtl());
				dv.setUpdateBy("excel_upload");
				oImagingInfoDAO.updateImagingInfo(dv);
				result++;
			}
//			}else {
//			
//			
//				List<DataIntegrationAsdListVO> excelList2 = null;
//				for(DataIntegrationAsdListVO dAv : excelList2) {
//					
//					
//					
//					
//					dAv.setRndId(dataIntegrationAsdListVO.getRndId());
//					dAv.setDisClassDtl(dataIntegrationAsdListVO.getDisClassDtl());
//					dAv.setUpdateBy("excel_upload");
//					oImagingInfoDAO.updateAsdImagingInfo(dAv);
//					result++;
//				}
//			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int excelAsdDataUpload(File file, DataIntegrationAsdListVO dataIntegrationAsdListVO) throws Exception {
		int result = 0;
		String disClassDtl = dataIntegrationAsdListVO.getDisClassDtl();
		System.out.println("영상(excelAsdDataUpload) disClassDtl name -----> : "+disClassDtl);
		List<DataIntegrationAsdListVO> excelList2 = null;
		try {
			if("DS003".equals(disClassDtl))
			{
				excelList2 = imagingInfoFileReader2.excelRead(file);
		 //   excelList = imagingInfoFileReader2.excelRead(file);
			for(DataIntegrationAsdListVO dAv : excelList2) {
				dAv.setRndId(dataIntegrationAsdListVO.getRndId());
				dAv.setDisClassDtl(dataIntegrationAsdListVO.getDisClassDtl());
				dAv.setUpdateBy("excel_upload");
				oImagingInfoDAO.updateAsdImagingInfo(dAv);
				result++;
			}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
