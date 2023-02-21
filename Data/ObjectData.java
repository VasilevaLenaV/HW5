package Data;

import java.util.ArrayList;
import java.util.Collection;

public class  ObjectData<T> implements Operation<T> {
     public static final String replaceTel = null;
     Collection<T> data =new ArrayList<>();

     @Override
     public Collection<T> getValue() {
          return data;
     }

     @Override
     public void replaceValue(T oldValue, T newValue) {
          if (data.contains(oldValue))
               data.remove(newValue);

               setValue(newValue);
     }

     @Override
     public void setValue(T value) {
          if (!data.contains(value))
               data.add(value);
     }
}
