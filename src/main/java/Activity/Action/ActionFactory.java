package Activity.Action;

public class ActionFactory {
    public static ActionStrategy get(String type){
        ActionStrategy actionStrategy = null;
        try {
            actionStrategy =  (ActionStrategy)Class.forName(type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return actionStrategy;
    }
}
