package com.ohashi.pixexample.services;

import com.ohashi.pixexample.entities.PixKey;

public interface KeysService {
    PixKey inputKey(String cpf, PixKey newKey);
}