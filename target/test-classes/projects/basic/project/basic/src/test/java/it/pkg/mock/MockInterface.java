package it.pkg.mock;

public interface MockInterface<T,E> {
    T mockEntity(Integer num);
    E mockRequest(Integer num);
}
