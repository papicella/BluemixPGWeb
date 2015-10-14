package com.ibm.pas.bluemix.pgweb.dao.tables;

public interface Constants
{
    public static final String USER_TABLES_COUNT =
            "select object_type, count(*) " +
                    "from ( " +
                    "  SELECT n.nspname as \"Schema\", " +
                    "    c.relname as \"Name\", " +
                    "    'Table'::text as object_type, " +
                    "    pg_catalog.pg_get_userbyid(c.relowner) as \"Owner\" " +
                    "  FROM pg_catalog.pg_class c " +
                    "       LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace " +
                    "  WHERE c.relkind IN ('r','') " +
                    "        AND n.nspname = ? " +
                    "        AND n.nspname <> 'pg_catalog' " +
                    "        AND n.nspname <> 'information_schema' " +
                    "        AND n.nspname !~ '^pg_toast' " +
                    "    AND pg_catalog.pg_table_is_visible(c.oid) " +
                    "  ORDER BY 1,2) a " +
                    "group by object_type ";
}