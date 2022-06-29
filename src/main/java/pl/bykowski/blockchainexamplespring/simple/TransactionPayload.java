package pl.bykowski.blockchainexamplespring.simple;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionPayload {

    public TransactionPayload(String to, String from, BigDecimal value) {
        this.to = to;
        this.from = from;
        this.value = value;
    }

    private String id;
    private String to;
    private String from;
    private BigDecimal value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionPayload that = (TransactionPayload) o;
        return Objects.equals(id, that.id) && Objects.equals(to, that.to) && Objects.equals(from, that.from) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, to, from, value);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }


}
