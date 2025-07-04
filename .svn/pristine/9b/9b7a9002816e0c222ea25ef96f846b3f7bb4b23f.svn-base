package medical.framework.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Vector;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class StringUtil {
	/** String = "" */
	public static final String BLANK = "";
	/** String = " " */
	public static final String SPACE = " ";
	/** String = "0" */
	public static final String ZERO_STRING = "0";
	/** String = "1" */
	public static final String ONE_STRING = "1";
	/** String = "Y" */
	public static final String YES = "Y";
	/** String = "N" */
	public static final String NO = "N";
	/** String = "-" */
	public static final String DASH = "-";	
	/** String = "," */
	public static final String COMMA = ",";
	/** String = "ALL" */
	public static final String ALL = "ALL";
	/** String = "." */
	public static final String DOT = ".";
	
	public static String decode(String src, String comp, String thenValue) {
		return decode(src, comp, thenValue, src);
	}

	public static String decode(String src, String comp, String thenValue, String elseValue) {
		if (comp.equals(NVL(src)))
			return thenValue;
		return elseValue;
	}

	public static String NVL(Object obj) {
		return NVL(obj, "");
	}

	public static String NVL(Object obj, String defValue) {
		if (obj != null)
			return obj.toString();
		else
			return defValue;
	}

	public static String toUpperCase(String value) {
		return StringUtil.NVL(value).toUpperCase();
	}

	public static String ascToKsc(String value) {
		try {
			int i = value != null && value.length() > 0 ? value.charAt(0) : -1;
			value = value != null ? (i >= 164 ? new String(value.getBytes("ISO-8859-1"), "UTF-8")
					: value) : null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String kscToAsc(String value) {
		String strRet = null;
		try {
			strRet = new String(value.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return strRet;
	}

	public static String[] split(String source, String separator) {

		if (source == null) {
			return new String[] { "" };
		}

		if (separator == null) {
			return new String[] { source };
		}

		final int sourceLength = source.length();
		final int separatorLength = separator.length();

		Vector<String> splittedStrings = new Vector<String>();
		int currentCursor = 0;
		int nextCursor = 0;

		while (currentCursor <= sourceLength) {
			nextCursor = source.indexOf(separator, currentCursor);
			if (currentCursor == nextCursor) {
				// Two sequential separators, skip increment and continue.
				splittedStrings.addElement("");
				currentCursor += separatorLength;
				continue;
			} else if (nextCursor == -1) {
				// No more separators, add the rest of the string and break.
				splittedStrings.addElement(source.substring(currentCursor));
				break;
			} else {
				// Add the string between the separators and increment the
				// initial one.
				splittedStrings.addElement(source.substring(currentCursor, nextCursor));
				currentCursor = nextCursor + separatorLength;
			}
		}

		String[] result = new String[splittedStrings.size()];
		splittedStrings.copyInto(result);
		return result;
	}

	/**
	 * String문자열을 HTML String으로 변환 시킨다.
	 * 
	 * @param string
	 * @return
	 */
	public static String stringToHTMLString(Object o) {
		String string = null;

		if (o == null) {
			string = "";
		} else if (o instanceof String) {
			string = (String) o;
		} else if (o instanceof StringBuffer) {
			string = ((StringBuffer) o).toString();
		} else {
			string = o.toString();
		}
		
		StringBuffer sb = new StringBuffer(string.length());
		// true if last char was blank
		boolean lastWasBlankChar = false;
		int len = string.length();
		char c;
		for (int i = 0; i < len; i++) {

			c = string.charAt(i);
			if (c == ' ') {
				// blank gets extra work,
				// this solves the problem you get if you replace all
				// blanks with &nbsp;, if you do that you loss
				// word breaking
				if (lastWasBlankChar) {
					lastWasBlankChar = false;
					sb.append("&nbsp;");
				} else {
					lastWasBlankChar = true;
					sb.append(' ');
				} /* end of else */
			} else {
				lastWasBlankChar = false;
				//
				// HTML Special Chars
				if (c == '"')
					sb.append("&quot;");
				else if (c == '&')
					sb.append("&amp;");
				else if (c == '<')
					sb.append("&lt;");
				else if (c == '>')
					sb.append("&gt;");
				else if (c == '\n')
					// Handle Newline
					sb.append("&lt;br/&gt;");
				else {
					int ci = 0xffff & c;
					if (ci < 160)
						// nothing special only 7 Bit
						sb.append(c);
					else {
						// Not 7 Bit use the unicode system
						sb.append("&#");
						sb.append(new Integer(ci).toString());
						sb.append(';');
					} /* end of else */
				} /* end of else */
			} /* end of else */
		} /* end of for */

		return sb.toString();
	} /* end of method */

	/**
	 * base64암호화 한다.
	 * 
	 * @param src
	 * @return
	 */
	public static String base64ToEncode(String src) {
		return new BASE64Encoder().encodeBuffer(src.getBytes());
	}

	public static String base64toDecode(String src, String charset) throws IOException {
		byte[] bySrc = new BASE64Decoder().decodeBuffer(src);

		return new String(bySrc, charset);
	}

	/**
	 * base64 복구화 한다.
	 * 
	 * @param src
	 * @return
	 * @throws IOException
	 */
	public static String base64toDecode(String src) throws IOException {
		return base64toDecode(src, "UTF-8");
	}

	/**
	 * Is empty string value
	 * 
	 * @param value
	 * @return true : empty, false : not empty
	 */
	public static boolean isEmptyString(String value) {
		if (value == null || "".equals(value)) {
			return true;
		}
		return false;
	}

	/**
	 * 파일 확장자 구하기
	 * 
	 * @param fileName
	 * @return 파일 확장자
	 */
	public static String getFileExtension(String fileName) {

		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	/**
	 * String이 null이명 ""리턴
	 * 
	 * @param value
	 * @return
	 */
	public static String removeNull(String value) {
		if (value == null){
			return "";
		}else if(value == "null"){
			return "";
		}
		return value;			
	}
	
	/**
	 * 문자 비교
	 * 1. 둘다 Null ==> true;
	 *
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isEquals(String str1, String str2) {
		if ( str1 == null && str2 == null ) return true;
		if ( str1 == null && str2 != null ) return false;
		if ( str1 != null && str2 == null ) return false;
		
		return StringUtil.trim(str1).equals(StringUtil.trim(str2));
	}
	
	/**
	 * String null 이면 ""
	 * 아니면 trim()
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		if ( str == null ) return "";
		
		return str.trim();
	}
	
	/**
	 * "Y" 여부 확인 
	 * 대소문자 관계없이 확인
	 * @param str
	 * @return
	 */
	public static boolean isYes(String str) {
		if ( str == null ) return false;		
		return StringUtil.isEquals(YES, str.toUpperCase());
	}
	
	/**
	 * "N" 여부 확인 
	 * 대소문자 관계없이 확인
	 * @param str
	 * @return
	 */
	public static boolean isNo(String str) {
		if ( str == null ) return false;		
		return StringUtil.isEquals(NO, str.toUpperCase());
	}
	
	/**
	 * String to BigDecimal
	 * Conversion
	 * @param str
	 * @return BigDecimal
	 */
	public static BigDecimal stringToBigDecimal(String str) {
		if( str == null) return null;
		return new BigDecimal(str);
		
	}

	
	public static String converDateToPer(String yyyymmdd) {
		if (StringUtil.isEmptyString(yyyymmdd)) {
			return "";
		}

		String s = "";
		s += yyyymmdd.substring(0, 4);
		s += "-";
		s += yyyymmdd.substring(4, 6);
		s += "-";
		s += yyyymmdd.substring(6, 8);
		return s;
	} 
	
	/**
	 * yyyymmdd -> yyyy.mm.dd
	 * @param yyyymmdd
	 * @return
	 */
	public static String converDateToDot(String yyyymmdd) {
		if (StringUtil.isEmptyString(yyyymmdd)) {
			return "";
		}

		String s = "";
		s += yyyymmdd.substring(0, 4);
		s += ".";
		s += yyyymmdd.substring(4, 6);
		s += ".";
		s += yyyymmdd.substring(6, 8);
		return s;
	}

	/**
	 * 
	 * @param newStr
	 * @param oldStr
	 * @return
	 */
	public static boolean isChange(String newStr, String oldStr) {
		return !StringUtil.isEquals(StringUtil.NVL(newStr), StringUtil.NVL(oldStr));
	}
	
	public static boolean isChangedName(String Name) {
		if ( StringUtil.isEmptyString(Name) ) {
			return true;
		}		
		if ( StringUtil.isEquals("NULL", Name.toUpperCase()) ) {
			return true;	
		}
		return false;
	}
	
	public static boolean isChangedSpec(String Spec) {
		if ( StringUtil.isEmptyString(Spec) ) {
			return true;
		}		
		if ( StringUtil.isEquals("NULL", Spec.toUpperCase()) ) {
			return true;	
		}
		return false;
	}
	
	/**
	 * path seperator on the Linux
	 * @param name
	 */
	public static String PathSep(String name) {
		if("".equals(name))return "/";
		else return "/" + name;
	}
	
	public static void main(String[] args) {
		String[] items = StringUtil.split("aaa|||a", "|");
		for (String item : items) {
			System.out.println("I > " + item);
		}
	}
}
