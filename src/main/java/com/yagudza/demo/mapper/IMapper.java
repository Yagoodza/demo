package com.yagudza.demo.mapper;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Class to map from S to D
 * @param <S>	source class
 * @param <D>	destination class
 */

public interface IMapper<S, D> {

    D map(S source);

    default Iterable<D> map(Iterable<S> source) {
        return StreamSupport.stream(source.spliterator(), false)
                .map(this::map)
                .collect(Collectors.toList());
    }
}
