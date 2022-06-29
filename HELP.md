# Getting Started

## Set up eth node

> docker run -d --name ethereum -p 8545:8545 -p 30303:30303 ethereum/client-go:v1.9.25 --rpc --rpcaddr "0.0.0.0" --rpcapi="db,eth,net,web3,personal" --rpccorsdomain "*" --dev --allow-insecure-unlock

## Connect to container

> docker exec -it ethereum geth attach ipc:/tmp/geth.ipc

## Useful commands

> personal.newAccount('password')

> eth.accounts

> personal.unlockAccount(eth.accounts[1])

> eth.getBalance(eth.accounts[1])

> eth.getTransaction('0x449d7cfbca23f13e6ecc826fa9cd565bd61c9ed55a60e52a8ea7cd69973ef77f').then(console.log);