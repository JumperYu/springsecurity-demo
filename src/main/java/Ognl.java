import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author https://github.com/JumperYu
 * @version 2019/09/29
 */
public class Ognl {

    public static boolean isNotNull(Object o) throws IllegalArgumentException {
        return o != null;
    }

    /**
     * 可以用于判断 Map,Collection,String,Array是否为空
     *
     * @param o
     * @return
     */
    public static boolean isEmpty(Object o) throws IllegalArgumentException {
        if (o == null)
            return true;
        if (o instanceof String) {
            return StringUtils.isEmpty((String) o);
        } else if (o instanceof Collection) {
            return ((Collection<?>) o).isEmpty();
        } else if (o.getClass().isArray()) {
            return ArrayUtils.isEmpty((Object[]) o);
        } else if (o instanceof Map) {
            return ((Map<?, ?>) o).isEmpty();
        } else if (o instanceof java.sql.Date) {
            return o == null;
        } else if (o instanceof java.util.Date) {
            return o == null;
        } else if (o instanceof Number) {
            return o == null;
        } else if (o instanceof Boolean) {
            return o == null;
        } else {
            throw new IllegalArgumentException(
                    "Illegal argument type,must be : Map,Collection,Array,String. but was:"
                            + o.getClass());
        }

    }

    /**
     * 可以用于判断 Map,Collection,String,Array是否不为空
     *
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    public static boolean isNotBlank(Object o) {
        return !isBlank(o);
    }

    public static boolean isNumber(Object o) {
        if (o instanceof Number) {
            return true;
        } else if (o instanceof String) {
            return NumberUtils.isDigits((String) o);
        } else {
            return false;
        }
    }

    public static boolean isBlank(Object o) {
        return StringUtils.isBlank((String) o);
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }
}
