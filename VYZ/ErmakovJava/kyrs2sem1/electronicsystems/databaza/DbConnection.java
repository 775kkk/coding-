package VYZ.ErmakovJava.kyrs2sem1.electronicsystems.databaza;

public class DbConnection {
    private final Database database;
    private final int poolIndex;
    private boolean closed = false;

    DbConnection(Database database, int poolIndex) {
        this.database = database;
        this.poolIndex = poolIndex;
    }

    public String get(int index) {
        if (closed) {
            throw new IllegalStateException("connection is closed");
        }
        return database.getValue(index);
    }

    public void put(String value) {
        if (closed) {
            throw new IllegalStateException("connection is closed");
        }
        database.addValue(value);
    }

    public void close() {
        if (!closed) {
            closed = true;
            database.releaseConnection(poolIndex);
        }
    }

    public boolean isClosed() {
        return closed;
    }
}
