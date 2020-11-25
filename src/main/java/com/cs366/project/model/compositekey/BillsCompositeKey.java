package com.cs366.project.model.compositekey;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillsCompositeKey implements Serializable {

    @Column(name = "beers")
    private long beers;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "bill_id")
    private String billId;

    public BillsCompositeKey() {
    }

    public BillsCompositeKey(long beers, int quantity, String billId) {
        this.beers = beers;
        this.quantity = quantity;
        this.billId = billId;
    }

    public long getBeer() {
        return beers;
    }

    public void setBeer(long beer) {
        this.beers = beer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String bill_id) {
        this.billId = bill_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillsCompositeKey that = (BillsCompositeKey) o;
        return quantity == that.quantity &&
                Objects.equals(beers, that.beers) &&
                Objects.equals(billId, that.billId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beers, quantity, billId);
    }
}
