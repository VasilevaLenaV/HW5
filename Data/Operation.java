package Data;

import java.util.Collection;

interface Operation<T> {
     void replaceValue(T oldValue, T newValue);

     void setValue(T value);

     Collection<T> getValue();
}
