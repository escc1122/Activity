package Activity.Condition;

import java.lang.reflect.InvocationTargetException;

public class ConditionFactory {
    public static ConditionStrategy get(String type) {
        ConditionStrategy conditionStrategy = null;
        try {
            conditionStrategy = (ConditionStrategy) Class.forName(type).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return conditionStrategy;
    }
}
