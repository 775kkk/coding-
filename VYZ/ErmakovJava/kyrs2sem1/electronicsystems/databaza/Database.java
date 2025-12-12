package VYZ.ErmakovJava.kyrs2sem1.electronicsystems.databaza;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Database {
    private final List<String> records = new ArrayList<>();
    private final int maxConnections;
    private final DbConnection[] pool;
    private final boolean[] inUse;

    public Database(int maxConnections) {
        if (maxConnections <= 0) {
            throw new IllegalArgumentException("maxConnections must be > 0");
        }
        this.maxConnections = maxConnections;

        for (int i = 0; i < 10; i++) {
            records.add("record #" + i);
        }

        this.pool = new DbConnection[maxConnections];
        this.inUse = new boolean[maxConnections];

        for (int i = 0; i < maxConnections; i++) {
            pool[i] = new DbConnection(this, i);
            inUse[i] = false;
        }
    }

    public synchronized DbConnection getConnection() {
        for (int i = 0; i < maxConnections; i++) {
            if (!inUse[i]) {
                inUse[i] = true;
                return pool[i];
            }
        }
        return null;
    }

    synchronized String getValue(int index) {
        if (index < 0 || index >= records.size()) {
            return null;
        }
        return records.get(index);
    }

    synchronized void addValue(String value) {
        records.add(Objects.toString(value, "null"));
    }

    synchronized void releaseConnection(int poolIndex) {
        if (poolIndex >= 0 && poolIndex < maxConnections) {
            inUse[poolIndex] = false;
        }
    }
}

