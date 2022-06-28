package Activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Activity.Action.ActionStrategy;
import Activity.Condition.ConditionStrategy;
import com.google.gson.Gson;

public class Activity {
    private String type = "";
    private String name = "";
    private List<ConditionStrategy> conditions = new ArrayList<>();
    private List<ActionStrategy> actions = new ArrayList<>();

    public void addCondition(ConditionStrategy conditionStrategy) {
        this.conditions.add(conditionStrategy);
    }

    public void addAction(ActionStrategy actionStrategy) {
        this.actions.add(actionStrategy);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(RunTimeData runTimeData) {
        boolean conditionCheck = true;
        for (int i = 0; i < conditions.size(); i++) {
            if (!conditions.get(i).check(runTimeData)) {
                conditionCheck = false;
                break;
            }
        }
        if (conditionCheck) {
            actions.stream().forEach(x -> x.doSomething());
        }
    }

    public void save() {
        Gson gson = new Gson();
        String data = gson.toJson(this);
        String url = "e:/git_project/" + this.name + ".json";
        try {
            PrintWriter writer =
                new PrintWriter(
                    new File(url));
            writer.write(data);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void load(String name) throws ClassNotFoundException {
        String url = "e:/git_project/" + name + ".json";
        File file = new File(url);
        String data = "";
        BufferedReader br
            = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                data = data + st;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        HashMap<String, Object> m = gson.fromJson(data, HashMap.class);
        ArrayList<Map<String, String>> actions = (ArrayList<Map<String, String>>) m.get("actions");
        for (int i = 0; i < actions.size(); i++) {
            Class c = Class.forName(actions.get(i).get("type"));
            ActionStrategy actionStrategy = (ActionStrategy) gson.fromJson(gson.toJson(actions.get(i)), c);
            this.actions.add(actionStrategy);
        }
        ArrayList<Map<String, String>> conditions = (ArrayList<Map<String, String>>) m.get("conditions");
        for (int i = 0; i < conditions.size(); i++) {
            Class c = Class.forName(conditions.get(i).get("type"));
            ConditionStrategy conditionStrategy = (ConditionStrategy) gson.fromJson(gson.toJson(conditions.get(i)), c);
            this.conditions.add(conditionStrategy);
        }
    }


}
