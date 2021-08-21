package com.digicore.digicore.service;

import org.springframework.stereotype.Component;

public interface AccountNumberGenerator<T> {
    T generateAccount();
}
