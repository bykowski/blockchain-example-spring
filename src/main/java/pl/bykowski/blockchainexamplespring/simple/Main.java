package pl.bykowski.blockchainexamplespring.simple;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //BlockChain
// Block - hashcode of previous block + transcations
// Chain
        TransactionPayload transactionPayload1 = new TransactionPayload("Anna", "Jan", BigDecimal.valueOf(11000L));
        TransactionPayload transactionPayload2 = new TransactionPayload("Jan", "Piotr", BigDecimal.valueOf(4000L));
        TransactionPayload transactionPayload3 = new TransactionPayload("Piotr", "Paweł", BigDecimal.valueOf(6000L));
        TransactionPayload transactionPayload4 = new TransactionPayload("Karolina", "Wiktoria", BigDecimal.valueOf(8000L));

        Block block1 = new Block(0, Arrays.asList(transactionPayload1, transactionPayload2));
        System.out.println(block1.hashCode());
        Block block2 = new Block(block1.hashCode(), Arrays.asList(transactionPayload3));
        System.out.println(block2.hashCode());
        Block block3 = new Block(block2.hashCode(), Arrays.asList(transactionPayload4));
        System.out.println(block3.hashCode());
    }
}
