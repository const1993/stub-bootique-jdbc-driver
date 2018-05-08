package io.bootique.jdbc.driver.stub;

public class RowId implements java.sql.RowId {
    @Override
    public byte[] getBytes() {
        return new byte[0];
    }
}
