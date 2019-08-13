/*
 * This file is generated by jOOQ.
 */
package ru.eltex.database.tables;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import ru.eltex.database.DefaultSchema;
import ru.eltex.database.tables.records.SalestableRecord;


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
public class Salestable extends TableImpl<SalestableRecord> {

    private static final long serialVersionUID = 2018701702;

    /**
     * The reference instance of <code>salesTable</code>
     */
    public static final Salestable SALESTABLE = new Salestable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SalestableRecord> getRecordType() {
        return SalestableRecord.class;
    }

    /**
     * The column <code>salesTable.idSale</code>.
     */
    public final TableField<SalestableRecord, Integer> IDSALE = createField("idSale", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>salesTable.nameProduct</code>.
     */
    public final TableField<SalestableRecord, String> NAMEPRODUCT = createField("nameProduct", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>salesTable.priceProduct</code>.
     */
    public final TableField<SalestableRecord, Integer> PRICEPRODUCT = createField("priceProduct", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>salesTable</code> table reference
     */
    public Salestable() {
        this(DSL.name("salesTable"), null);
    }

    /**
     * Create an aliased <code>salesTable</code> table reference
     */
    public Salestable(String alias) {
        this(DSL.name(alias), SALESTABLE);
    }

    /**
     * Create an aliased <code>salesTable</code> table reference
     */
    public Salestable(Name alias) {
        this(alias, SALESTABLE);
    }

    private Salestable(Name alias, Table<SalestableRecord> aliased) {
        this(alias, aliased, null);
    }

    private Salestable(Name alias, Table<SalestableRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Salestable as(String alias) {
        return new Salestable(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Salestable as(Name alias) {
        return new Salestable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Salestable rename(String name) {
        return new Salestable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Salestable rename(Name name) {
        return new Salestable(name, null);
    }
}