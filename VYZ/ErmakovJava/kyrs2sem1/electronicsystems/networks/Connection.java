package VYZ.ErmakovJava.kyrs2sem1.electronicsystems.networks;

import java.util.concurrent.ThreadLocalRandom;

import VYZ.ErmakovJava.kyrs2sem1.electronicsystems.exceptions.ConnectionLostException;
import VYZ.ErmakovJava.kyrs2sem1.electronicsystems.exceptions.ResourceClosedException;

public class Connection {
    private final String address;
    private boolean status;

    public Connection(String adress){
        this.address = adress;
        this.status = true;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getAdress() {
        return address;
    }
    public void switchStatus() {
        this.status = !status;
    }
    public void close() {
        this.status = false;
    }


    public String getData() throws ConnectionLostException,ResourceClosedException{
        if (!status) {
            throw new ResourceClosedException();
        }
        if (ThreadLocalRandom.current().nextBoolean()) {
            return "test connection: "+ this.toString();
        }
        throw new ConnectionLostException(address);
    }

    @Override
    public String toString() {
        return "Connection{" +
                "adress='" + address + '\'' +
                ", status=" + status +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return java.util.Objects.equals(address, that.address);
    }


    @Override
    public int hashCode() {
        return java.util.Objects.hash(address);
    }

}
