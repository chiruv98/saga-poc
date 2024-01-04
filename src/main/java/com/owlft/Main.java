package com.owlft;

import java.util.ArrayList;
import java.util.List;

import main.java.com.owlft.models.Operation;
import main.java.com.owlft.models.OperationResponse;
import main.java.com.owlft.models.ActionRecovery;
import main.java.com.owlft.models.DistributedTransaction;
import main.java.com.owlft.implementation.ExecuteDTImpl;

public class Main {
    public static void main(String[] args) {
        
        ActionRecovery action1 = new ActionRecovery();
        action1.setUrl("action1 successfull");
        action1.setHeaders("{'authorization': '1234567890'}");
        action1.setParams("");
        action1.setBody("body");
 
        ActionRecovery recovery1 = new ActionRecovery();
        recovery1.setUrl("recovery for action 1");
        recovery1.setHeaders("{}");
        recovery1.setParams("{}");
        recovery1.setBody("body 2");
        
        Operation st1 = new Operation();
        st1.setAction(action1);
        st1.setRecovery(recovery1);
        st1.setSequence(0);
        
        ActionRecovery action2 = new ActionRecovery();
        action2.setUrl("action2 successfull");
        action2.setHeaders("");
        action2.setParams("");
        action2.setBody("{}");
        
        ActionRecovery recovery2 = new ActionRecovery();
        recovery2.setUrl("recovery for action 2");
        recovery2.setHeaders(" ");
        recovery2.setParams(" ");
        recovery2.setBody(" ");
        
        Operation st2 = new Operation();
        st2.setAction(action2);
        st2.setRecovery(recovery2);
        st2.setSequence(1);

        ActionRecovery action3 = new ActionRecovery();
        action3.setUrl("action3 failed");
        action3.setHeaders("");
        action3.setParams("");
        action3.setBody("{}");
        
        ActionRecovery recovery3 = new ActionRecovery();
        recovery3.setUrl("recovery for action 3");
        recovery3.setHeaders(" ");
        recovery3.setParams(" ");
        recovery3.setBody(" ");
        
        Operation st3 = new Operation();
        st3.setAction(action3);
        st3.setRecovery(recovery3);
        st3.setSequence(1);
        
        ActionRecovery action4 = new ActionRecovery();
        action4.setUrl("action4 failed");
        action4.setHeaders("");
        action4.setParams("");
        action4.setBody("{}");
        
        ActionRecovery recovery4 = new ActionRecovery();
        recovery4.setUrl("recovery for action 4");
        recovery4.setHeaders(" ");
        recovery4.setParams(" ");
        recovery4.setBody(" ");
        
        Operation st4 = new Operation();
        st4.setAction(action4);
        st4.setRecovery(recovery4);
        st4.setSequence(1);

        List<Operation> stmts = new ArrayList<Operation>();
        stmts.add(st1);
        stmts.add(st2);
        stmts.add(st3);
        stmts.add(st4);
        
        DistributedTransaction dt = new DistributedTransaction();
        dt.setStatements (stmts);

        ExecuteDTImpl edt = new ExecuteDTImpl();
        
        List<OperationResponse> response = edt.execute(dt);
    }
}