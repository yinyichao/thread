package util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON 工具类
 * 
 * @author 
 *
 */
public class JsonUtil {

	/**
	 * 将object、 list、map转换成json
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		String out = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			out = objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	/**
	 * 将json字符串转换为对象
	 * 
	 * @param <T>
	 * 
	 * @param json
	 * @param classz
	 * @return
	 */
	public static <T> T jsonObjToObject(String json, Class<T> classz) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			T ot = objectMapper.readValue(json, classz);
			return ot;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json字符串转换为list
	 * 
	 * @param <T>
	 * 
	 * @param json
	 * @param classz
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> List<T> jsonArrToList(String json, Class<T> classz) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			List<T> ot = (List<T>) objectMapper.readValue(
					json,
					objectMapper.getTypeFactory().constructParametrizedType(
							ArrayList.class, ArrayList.class, classz));
			return ot;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
