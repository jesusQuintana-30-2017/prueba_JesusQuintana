package clases;

import java.io.IOException;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class StringAdapter extends TypeAdapter<String> {
	
	
	public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        	 Class<T> rawType = (Class<T>) type.getRawType();
             if (rawType != String.class) {
                 return null;
             }
             return (TypeAdapter<T>) new StringAdapter();
        }
    };
    
    public String read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return "";
        }
        return reader.nextString();
    }
    public void write(JsonWriter writer, String value) throws IOException {
        if (value == null) 
        {
        	value = "";
        }
        writer.value(value);
    }
}