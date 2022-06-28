package Activity.Condition;

import Activity.ClassName;
import Activity.RunTimeData;

public class GreaterCondition extends ClassName implements ConditionStrategy {
    private int greaterCondition = 0;
    public GreaterCondition(){
    }
    public GreaterCondition(int greaterCondition){
//        this.type = "GreaterCondition";
        this.greaterCondition = greaterCondition;
    }

    @Override
    public boolean check(RunTimeData runTimeData){
        boolean r = false;
        if (runTimeData.getMoney()>greaterCondition){
            r = true;
        }
        return r;
    }
}
