package Activity.Action;

import Activity.ClassName;

public class PrintAction extends ClassName implements ActionStrategy{
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean doSomething() {
        System.out.print("message : " + this.message);
        return true;
    }
}
