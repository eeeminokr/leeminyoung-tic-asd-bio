package medical.framework.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import medical.framework.vo.KoriginCommonVO;

public class JsonUtils {

	public static final String FD_RESULT = "results";
	public static final String FD_TOTAL = "total";

	/**
	 * json Data 생성을 위한 Model (view.xml)- xmlFileViewResolver
	 * 
	 * @param List
	 *            result result
	 * @return ModelAndView
	 */
	public static ModelAndView describe(List<?> result) {
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		BigDecimal totalCount = new BigDecimal(0);

		if (result != null && result.size() > 0) {
			Object obj = result.get(0);
			if (obj instanceof KoriginCommonVO) {
				totalCount = ((KoriginCommonVO) (result.get(0))).getTotalCount();
			} else if (obj instanceof Integer) {
				totalCount = new BigDecimal(0); // new BigDecimal(
												// ((Integer)obj).doubleValue());
			} else if (obj instanceof HashMap) {
				try {
					HashMap<?, ?> map = (HashMap<?, ?>) obj;
					BigDecimal tmp = (BigDecimal) map.get("TOTALCOUNT");
					if (tmp == null)
						tmp = (BigDecimal) map.get("totalCount");
					if (tmp == null)
						tmp = new BigDecimal(0);

					totalCount = tmp;
				} catch (Exception e) {
					totalCount = new BigDecimal(0);
				}
			}
		}
		
		modelMap.put("success", true);
		modelMap.put("total", totalCount);
		modelMap.put("results", result);
		
		return new ModelAndView("jsonView", modelMap);
	}

	public static ModelAndView describe(Map<?, ?> result) {
		Map<String, Object> modelMap = new HashMap<String, Object>(2);

		modelMap.put("success", true);
		modelMap.put("total", result.get("totalCnt"));
		modelMap.put("results", result);
		return new ModelAndView("jsonView", modelMap);
	}

	/**
	 * json Data 생성을 위한 Model (페이징 처리 위해서 Total Count 추가)
	 * (view.xml)-xmlFileViewResolver
	 * 
	 * @param int totalCount
	 * @param List
	 *            result result
	 * @return ModelAndView
	 */
	public static ModelAndView describe(int totalCount, List<?> result) {

		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("total", totalCount);
		modelMap.put("results", result);

		return new ModelAndView("jsonView", modelMap);
	}

	/**
	 * json Data 생성을 위한 Model (Dynamic grid 시 사용) (view.xml)-xmlFileViewResolver
	 * 
	 * @param List
	 *            result
	 * @param List
	 *            columns
	 * @return ModelAndView
	 */
	public static ModelAndView describeDynamic(List<?> result, List<?> columns) {
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		BigDecimal totalCount = new BigDecimal(0);

		if (result.size() > 0) {
			try {
				totalCount = new BigDecimal((String) (((HashMap<?, ?>) result.get(0)).get("TOTALCOUNT")));
			} catch (Exception e) {
			}
		}

		modelMap.put("total", totalCount);
		modelMap.put("results", result);
		modelMap.put("columns", columns);

		return new ModelAndView("jsonView", modelMap);
	}

	/**
	 * json Data 생성을 위한 Model (extjs tree json용으로만 사용) (viewJson.jsp)-
	 * internalResourceViewResolver
	 * 
	 * @param List
	 *            result * @return ModelAndView
	 */
	public static ModelAndView viewJson(List<?> result) {

		JsonConfig config = new JsonConfig();
		// config.setIgnoreDefaultExcludes(false);
		config.setCycleDetectionStrategy(CycleDetectionStrategy.NOPROP);

		String jsonString = null;
		JSONArray jsonObject = JSONArray.fromObject(result, config);
		try {
			jsonString = jsonObject.toString();
		} catch (Exception e) {
			jsonString = "";
		}

		return getJsonModelAndView(jsonString);
	}

	/**
	 * InternalResourceViewResolver json Model return
	 * (view.xml)-xmlFileViewResolver
	 * 
	 * @param String
	 *            jsonString
	 * @return ModelAndView
	 */
	public static ModelAndView getJsonModelAndView(String jsonString) {
		// 반환값이 되는 ModelAndView인스턴스를 작성
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/viewJson");
		modelAndView.addObject("json", jsonString);

		return modelAndView;
	}

	/**
	 * 저정후 결과 정보 return (view.xml)-xmlFileViewResolver
	 * 
	 * @param List
	 *            result result
	 * @return ModelAndView
	 */
	public static ModelAndView insertResult(int rtn) {
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("total", rtn);
		modelMap.put("results", "success");
		if (rtn > 0)
			modelMap.put("success", true);
		else
			modelMap.put("success", false);
		return new ModelAndView("jsonView", modelMap);
	}

	/**
	 * 에러 내용을 json 유형으로 return (view.xml)-xmlFileViewResolver
	 * 
	 * @param String
	 *            message
	 * @return ModelAndView
	 */
	public static ModelAndView describeException(String message) {

		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("success", false);

		Map<String, Object> errorMap = new HashMap<String, Object>(2);
		errorMap.put("reason", message);

		modelMap.put("errors", errorMap);
		return new ModelAndView("jsonView", modelMap);
	}

	public static ModelAndView describeException(Map<String, String> map) {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", false);
		modelMap.put("errors", map);

		return new ModelAndView("jsonView", modelMap);
	}

	/**
	 * process 처리 내용을 json 유형으로 return (view.xml)-xmlFileViewResolver
	 * 
	 * @param String
	 *            message
	 * @return ModelAndView
	 */
	public static ModelAndView describeMessage(String message) {
		// String jsonString = "{results:{message:'"+message+"'}}";
		// return getJsonModelAndView(jsonString);

		Map<String, String> result = new HashMap<String, String>();
		result.put("message", message);
		Map<String, Object> modelMap = new HashMap<String, Object>(2);

		modelMap.put("success", true);
		modelMap.put("total", 1);
		modelMap.put("results", result);

		return new ModelAndView("jsonView", modelMap);

	}

	/**
	 * process 처리 결과를 json 유형으로 return (view.xml)-xmlFileViewResolver
	 * 
	 * @param String
	 *            message
	 * @return ModelAndView
	 */
	public static ModelAndView processResult(String message) {

		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("success", true);

		if (!StringUtils.isEmpty(message)) {

			Map<String, Object> errorMap = new HashMap<String, Object>(2);
			errorMap.put("message", message);
			modelMap.put("messages", errorMap);
		}
		return new ModelAndView("jsonView", modelMap);
	}
}
