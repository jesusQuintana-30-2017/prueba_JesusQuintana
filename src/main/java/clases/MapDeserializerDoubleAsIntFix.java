package clases;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;

public class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>>{

	@SuppressWarnings("unchecked")
    public HashMap<String, Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new HashMap<String, Object>((Map<String, Object>)read(json));
    }


    public Object read(JsonElement in) {

        if(in.isJsonArray()){
            List<Object> list = new ArrayList<Object>();
            JsonArray arr = in.getAsJsonArray();
            for (JsonElement anArr : arr) {
                list.add(read(anArr));
            }
            return list;
        }else if(in.isJsonObject()){
        	//HashMap<String, Object> hasmap = new LinkedTree
            Map<String, Object> map = new LinkedTreeMap<String, Object>();
        	//LinkedHashTreeMap<String, Object> map = new LinkedHashTreeMap<String,Object>(); //= new LinkedTreeMap<String, Object>();
            JsonObject obj = in.getAsJsonObject();
            Set<Map.Entry<String, JsonElement>> entitySet = obj.entrySet();
            for(Map.Entry<String, JsonElement> entry: entitySet){
                map.put(entry.getKey(), read(entry.getValue()));
            }
            return map;
        }else if( in.isJsonPrimitive()){
            JsonPrimitive prim = in.getAsJsonPrimitive();
            if(prim.isBoolean()){
                return prim.getAsBoolean();
            }else if(prim.isString()){
                return prim.getAsString();
            }else if(prim.isNumber()){
                Number num = prim.getAsNumber();
                // here you can handle double int/long values
                // and return any type you want
                // this solution will transform 3.0 float to long values
                if(Math.ceil(num.doubleValue())  == num.intValue())
                   return num.intValue();//.longValue();
                else{
                    return num.doubleValue();
                }
            }
        }
        return null;
    }
}