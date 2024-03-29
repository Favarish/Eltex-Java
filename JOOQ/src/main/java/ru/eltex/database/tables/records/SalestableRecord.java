/*
 * This file is generated by jOOQ.
 */
package ru.eltex.database.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;

import ru.eltex.database.tables.Salestable;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SalestableRecord extends TableRecordImpl<SalestableRecord> implements Record3<Integer, String, Integer> {

    private static final long serialVersionUID = -1418020340;

    /**
     * Setter for <code>salesTable.idSale</code>.
     */
    public void setIdsale(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>salesTable.idSale</code>.
     */
    public Integer getIdsale() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>salesTable.nameProduct</code>.
     */
    public void setNameproduct(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>salesTable.nameProduct</code>.
     */
    public String getNameproduct() {
        return (String) get(1);
    }

    /**
     * Setter for <code>salesTable.priceProduct</code>.
     */
    public void setPriceproduct(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>salesTable.priceProduct</code>.
     */
    public Integer getPriceproduct() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Salestable.SALESTABLE.IDSALE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Salestable.SALESTABLE.NAMEPRODUCT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Salestable.SALESTABLE.PRICEPRODUCT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdsale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getNameproduct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getPriceproduct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdsale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getNameproduct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getPriceproduct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SalestableRecord value1(Integer value) {
        setIdsale(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SalestableRecord value2(String value) {
        setNameproduct(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SalestableRecord value3(Integer value) {
        setPriceproduct(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SalestableRecord values(Integer value1, String value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SalestableRecord
     */
    public SalestableRecord() {
        super(Salestable.SALESTABLE);
    }

    /**
     * Create a detached, initialised SalestableRecord
     */
    public SalestableRecord(Integer idsale, String nameproduct, Integer priceproduct) {
        super(Salestable.SALESTABLE);

        set(0, idsale);
        set(1, nameproduct);
        set(2, priceproduct);
    }
}
