package Activity;

import Activity.Action.PrintAction;
import Activity.Condition.ConditionStrategy;
import Activity.Condition.GreaterCondition;

public class ActivityBuilder {
    private String type;
    private String name;

    public ActivityBuilder(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public Activity buildA(String activityName, int conditionMoney) {
        Activity a = new Activity();
        a.setType("buildA");
        a.setName(activityName);
        ConditionStrategy c = new GreaterCondition(conditionMoney);
        a.addCondition(c);
        PrintAction r = new PrintAction();
        r.setMessage("test");
        a.addAction(r);
        return a;
    }

}
