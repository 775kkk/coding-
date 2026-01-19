package interfaces;

import exceptions.ParentsException;

public interface ParentsInterface<dto,react,policy> {
    public react react(dto dto,policy policy) throws ParentsException;
}
