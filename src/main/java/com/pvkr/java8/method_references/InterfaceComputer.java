package com.pvkr.java8.method_references;

import com.pvkr.java8.domain.Computer;

@FunctionalInterface
public interface InterfaceComputer {
    Computer create();
}