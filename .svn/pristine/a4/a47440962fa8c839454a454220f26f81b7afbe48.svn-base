package medical.framework.file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import medical.framework.util.DateUtil;
import medical.framework.util.FileUtils;

public class DownloadView extends AbstractView {

	public DownloadView() {
		setContentType("application/octet-stream");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Assert.notNull(model, "model is null");

		Object o = model.get("download");
		Assert.notNull(o, "download file is empty");

		response.setContentType(getContentType());
		response.setHeader("Content-Transfer-Encoding", "binary");

		OutputStream out = response.getOutputStream();

		String fileName = null;
		InputStream is = null;
		File file = null;

		// attach. file
		if (o instanceof File) {
			file = (File) o;
			is = new FileInputStream(file);

			response.setContentLength((int) file.length());
			fileName = (String) model.get(FileUtils.ORIGINAL_FILE_NAME);

//			System.out.println(fileName);

			if (StringUtils.isEmpty(fileName)) {
				fileName = file.getName();
			}

			// generate file
		} else if (model.get("download") instanceof Map) {
			@SuppressWarnings("unchecked")
			HashMap<String, Object> map = (HashMap<String, Object>) model.get("download");
			file = (File) map.get("download");
			is = new FileInputStream(file);

			response.setContentLength((int) file.length());
			fileName = (String) map.get(FileUtils.ORIGINAL_FILE_NAME);
		// excel
		} else if (o instanceof InputStream) {
			is = (InputStream) o;
			fileName = "Download_" + DateUtil.getShortDateTimeString() + ".xls";
		// excel 2
		} else if (o instanceof ExcelFile) {
			ExcelFile excelFile = (ExcelFile) o;
			is = new ByteArrayInputStream(excelFile.getBytes());

			fileName = "download_" + DateUtil.getShortDateTimeString();

			if (excelFile.isXlsx()) {
				fileName += ".xlsx";
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			} else {
				fileName += ".xls";
				response.setContentType("application/vnd.ms-excel");
			}
		}

		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\";");

		try {
			FileCopyUtils.copy(is, out);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException ex) {
				}
			}
		}
		out.flush();
	}
}
