###           Banking Service

## Requirements
- Java 17 or newer (`java -version` to check)
- make (GNU make)

## How to build, run, and test
- Compile: `make`
- Run: `make run`
- Test: `make test`
- Clean compiled classes: `make clean`

## Usage

After running `make run`, you can use the following commands:

### Deposit money
```
deposit <amount> <date>
```
Example:
```
> deposit 1000 10-01-2012
```

### Withdraw money
```
withdraw <amount> <date>
```
Example:
```
> withdraw 500 14-01-2012
```

### Print statement
```
print
```
Example:
```
> print
DATE       || AMOUNT || BALANCE
14-01-2012 || -500   || 1500
10-01-2012 || 1000   || 1000
```

### Exit program
```
exit
```

**Notes:**
- Date format must be `dd-MM-yyyy` (`10-01-2012`)
- Amount must be a positive integer
- Transactions must be in chronological order (cannot add a transaction with a date earlier than existing transactions)


