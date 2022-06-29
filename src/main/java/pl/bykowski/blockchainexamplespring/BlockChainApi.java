package pl.bykowski.blockchainexamplespring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.bykowski.blockchainexamplespring.simple.TransactionPayload;

import java.io.IOException;

@RestController
public class BlockChainApi {

    BlockChainService blockChainService;

    public BlockChainApi(BlockChainService blockChainService) {
        this.blockChainService = blockChainService;
    }

    @PostMapping
    public TransactionPayload get(@RequestBody TransactionPayload transactionPayload) throws IOException {
        return blockChainService.proceed(transactionPayload);
    }
}
