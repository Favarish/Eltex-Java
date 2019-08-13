/*
 * This file is generated by jOOQ.
 */
package ru.eltex.database.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;

import ru.eltex.database.DefaultSchema;
import ru.eltex.database.tables.records.LangstableRecord;


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
public class Langstable extends TableImpl<LangstableRecord> {

    private static final long serialVersionUID = 73930744;

    /**
     * The reference instance of <code>langsTable</code>
     */
    public static final Langstable LANGSTABLE = new Langstable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LangstableRecord> getRecordType() {
        return LangstableRecord.class;
    }

    /**
     * The column <code>langsTable.idLang</code>.
     */
    public final TableField<LangstableRecord, Integer> IDLANG = createField("idLang", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>langsTable.langName</code>.
     */
    public final TableField<LangstableRecord, String> LANGNAME = createField("langName", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>langsTable</code> table reference
     */
    public Langstable() {
        this(DSL.name("langsTable"), null);
    }

    /**
     * Create an aliased <code>langsTable</code> table reference
     */
    public Langstable(String alias) {
        this(DSL.name(alias), LANGSTABLE);
    }

    /**
     * Create an aliased <code>langsTable</code> table reference
     */
    public Langstable(Name alias) {
        this(alias, LANGSTABLE);
    }

    private Langstable(Name alias, Table<LangstableRecord> aliased) {
        this(alias, aliased, null);
    }

    private Langstable(Name alias, Table<LangstableRecord> aliased, Field<?>[] parameters) {
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
    public Identity<LangstableRecord, Integer> getIdentity() {
        return Internal.createIdentity(ru.eltex.database.tables.Langstable.LANGSTABLE, ru.eltex.database.tables.Langstable.LANGSTABLE.IDLANG);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LangstableRecord> getPrimaryKey() {
        return Internal.createUniqueKey(ru.eltex.database.tables.Langstable.LANGSTABLE, "KEY_langsTable_PRIMARY", ru.eltex.database.tables.Langstable.LANGSTABLE.IDLANG);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LangstableRecord>> getKeys() {
        return Arrays.<UniqueKey<LangstableRecord>>asList(
              Internal.createUniqueKey(ru.eltex.database.tables.Langstable.LANGSTABLE, "KEY_langsTable_PRIMARY", ru.eltex.database.tables.Langstable.LANGSTABLE.IDLANG)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Langstable as(String alias) {
        return new Langstable(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Langstable as(Name alias) {
        return new Langstable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Langstable rename(String name) {
        return new Langstable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Langstable rename(Name name) {
        return new Langstable(name, null);
    }
}