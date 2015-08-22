import com.cedarsoftware.util.io.JsonReader;
import net.minidev.json.JSONValue;

public enum RefsResolver {;

	public static String resolve(final String json) {
		return JSONValue.toJSONString(extractItems(JsonReader.jsonToMaps(json)));
	}

	private static Object extractItems(final java.util.Map<?,?> jMap) {
		return jMap.containsKey("@items")? jMap.get("@items") : jMap;
	}

}