package com.epatient.backend.converter;

public interface BiConverter<T, S, V> {
    V convert(T t, S s);
}
