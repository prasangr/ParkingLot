import java.util.HashMap;
import java.util.Map;

public class ObjectContainter {

    Map<String,Object> objectMap;

    public ObjectContainter(){
        this.objectMap=new HashMap<>();
    }

    public void register(String key, Object o){
        objectMap.put(key,o);
    }

    public Object get(String key){
        return objectMap.get(key);
    }

}
