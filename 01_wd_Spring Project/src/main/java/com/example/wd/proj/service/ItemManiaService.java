package com.example.wd.proj.service;

import com.example.wd.proj.entity.ItemManiaBoard;

import java.util.List;

public interface ItemManiaService {
    // 인터페이스 부분

    public List<ItemManiaBoard> maniaList() throws Exception;

    public void maniaRegister(ItemManiaBoard board) throws Exception;

}
