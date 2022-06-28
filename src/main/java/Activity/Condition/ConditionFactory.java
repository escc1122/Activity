package Activity.Condition;

public class ConditionFactory {
    public static ConditionStrategy get(String type){
        ConditionStrategy conditionStrategy = null;
        try {
            conditionStrategy = (ConditionStrategy)Class.forName(type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conditionStrategy;
    }
}
