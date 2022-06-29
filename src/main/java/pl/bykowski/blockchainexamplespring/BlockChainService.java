package pl.bykowski.blockchainexamplespring;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.utils.Convert;
import pl.bykowski.blockchainexamplespring.simple.TransactionPayload;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Service
public class BlockChainService {

    private final Web3j web3j;

    public BlockChainService(Web3j web3j) {
        this.web3j = web3j;
    }

    public static final BigInteger INTRINSIC_GAS = BigInteger.valueOf(21000);
    public static final BigInteger GAS_PRICE = Convert.toWei("5", Convert.Unit.SZABO).toBigIntegerExact();

    public TransactionPayload proceed(TransactionPayload transactionPayload) throws IOException {
        List<String> accounts = web3j.ethAccounts().send().getAccounts();

        EthGetTransactionCount transactionCount = web3j
                .ethGetTransactionCount(accounts.get(Integer.parseInt(transactionPayload.getFrom())), DefaultBlockParameterName.LATEST)
                .send();

        BigInteger nonce = transactionCount.getTransactionCount();

        Transaction etherTransaction = Transaction.createEtherTransaction(
                accounts.get(Integer.parseInt(transactionPayload.getFrom())),
                nonce,
                GAS_PRICE,
                INTRINSIC_GAS,
                accounts.get(Integer.parseInt(transactionPayload.getTo())),
                transactionPayload.getValue().toBigInteger());

//        Transaction etherTransaction = Transaction.createEtherTransaction(
//                transactionPayload.getFrom(),
//                nonce,
//                GAS_PRICE,
//                INTRINSIC_GAS,
//                transactionPayload.getTo(),
//                transactionPayload.getValue().toBigInteger());

        EthSendTransaction send = web3j.ethSendTransaction(etherTransaction).send();
        System.out.println(send.getError().getMessage());
        transactionPayload.setId(send.getTransactionHash());
        return transactionPayload;
    }
}
