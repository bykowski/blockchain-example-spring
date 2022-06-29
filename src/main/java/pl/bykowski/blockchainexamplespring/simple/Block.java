package pl.bykowski.blockchainexamplespring.simple;

import java.util.List;
import java.util.Objects;

public class Block {

    public Block(int previousHash, List<TransactionPayload> transactionPayloadList) {
        this.previousHash = previousHash;
        this.transactionPayloadList = transactionPayloadList;
    }

    private int previousHash;
    private List<TransactionPayload> transactionPayloadList;

    public int getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(int previousHash) {
        this.previousHash = previousHash;
    }

    public List<TransactionPayload> getTransactionList() {
        return transactionPayloadList;
    }

    public void setTransactionList(List<TransactionPayload> transactionPayloadList) {
        this.transactionPayloadList = transactionPayloadList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return previousHash == block.previousHash && Objects.equals(transactionPayloadList, block.transactionPayloadList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(previousHash, transactionPayloadList);
    }
}
