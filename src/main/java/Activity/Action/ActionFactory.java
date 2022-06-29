package Activity.Action;

import java.lang.reflect.InvocationTargetException;

public class ActionFactory {
    public static ActionStrategy get(String type) {
        ActionStrategy actionStrategy = null;
        try {
            actionStrategy = (ActionStrategy) Class.forName(type).getDeclaredConstructor().newInstance();
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
        return actionStrategy;
    }
}
