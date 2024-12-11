#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mock;

public interface MockInterface<T,E> {
    T mockEntity(Integer num);
    E mockRequest(Integer num);
}
