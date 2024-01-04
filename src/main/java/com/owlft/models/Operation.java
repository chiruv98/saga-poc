package main.java.com.owlft.models;

public class Operation {
    
    private ActionRecovery action;
    private ActionRecovery recovery;
    private int sequence;
    private boolean isExecuted;

    public ActionRecovery getAction() {
        return action;
    }

    public void setAction(ActionRecovery action) {
        this.action = action;
    }

    public ActionRecovery getRecovery() {
        return recovery;
    }

    public void setRecovery(ActionRecovery recovery) {
        this.recovery = recovery;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public boolean getIsExecuted() {
        return isExecuted;
    }

    public void setIsExecuted(boolean isExecuted) {
        this.isExecuted = isExecuted;
    }

}
