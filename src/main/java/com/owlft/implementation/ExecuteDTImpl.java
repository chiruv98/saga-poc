package main.java.com.owlft.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.com.owlft.models.DistributedTransaction;
import main.java.com.owlft.models.Operation;
import main.java.com.owlft.models.OperationResponse;
import main.java.com.owlft.models.ActionRecovery;

public class ExecuteDTImpl {

    public List<OperationResponse> execute (DistributedTransaction dt) {
            List<Operation> statements = dt.getStatements();

            System.out.println("------------------ Fetched Statements List ---------------");
            System.out.println();

            List<Operation> recoveries = new ArrayList<>();
            List<OperationResponse> opResponse = new ArrayList<>();

            for (Operation operation : statements) {

                System.out.println("executing action: " + operation.getAction());

                OperationResponse response = executeAction(operation.getAction());

                System.out.println("Action Response");
                System.out.println("----------------------------------------");
                System.out.println("success: " + response.getSuccess());
                System.out.println("response: " + response.getResponse());
                System.out.println("----------------------------------------");

                opResponse.add(response);

                if(response.getSuccess()) {
                   operation.setIsExecuted(true);
                   System.out.println("setting isExecuted to true for:" + operation.getAction());
                }

                else {
                     recoveries = statements.stream()
                                    .filter(op -> (op.getSequence() <= operation.getSequence()) && (op.getIsExecuted()))
                                    .collect(Collectors.toList());
                    break;
                }

            }
            if (!recoveries.isEmpty()) {
                for (Operation recovery : recoveries) {

                    System.out.println("executing recovery: " + recovery.getRecovery());

                    OperationResponse response = executeRecovery(recovery.getRecovery());
                    opResponse.add(response);

                    System.out.println("Recovery Response");
                    System.out.println("----------------------------------------");
                    System.out.println("success: " + response.getSuccess());
                    System.out.println("response: " + response.getResponse());
                    System.out.println("----------------------------------------");
                }
            }

            return opResponse;
        }
    
    private OperationResponse executeAction (ActionRecovery action) {

        OperationResponse response = new OperationResponse();

        response.setSuccess(true);

        if(action.getUrl() == "action3 failed"){
            response.setSuccess(false);
        }

        response.setResponse (action.getUrl());

        return response;

    };
    private OperationResponse executeRecovery (ActionRecovery recovery) {

        OperationResponse response = new OperationResponse();

        response.setSuccess(true);
        response.setResponse (recovery.getUrl());

        return response;

    };
}
