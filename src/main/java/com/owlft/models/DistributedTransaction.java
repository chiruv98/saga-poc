package main.java.com.owlft.models;

import java.util.List;

public class DistributedTransaction {

    String id;
    List<Operation> statements;

    OperationResponse execute (Operation action) {};
    OperationResponse compensation (Operation recovery) {};
    
}
