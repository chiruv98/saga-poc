package main.java.com.owlft.models;

import java.util.List;

public class DistributedTransaction {

    private String id;
    public List<Operation> statements;

    public OperationResponse execute (String id) {};

    public String getId() {
        return id;
    }

    public List<Operation> getStatements() {
        return statements;
    }

    public void setStatements(List<Operation> statements) {
        this.statements = statements;
    }
    
}
