package com.example.wd.proj.service;

import com.example.wd.proj.entity.ItemManiaBoard;
import com.example.wd.proj.repository.ItemManiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemManiaServiceImpl implements ItemManiaService {

    @Autowired
    private ItemManiaRepository maniaRepository;

    @Override
    public List<ItemManiaBoard> maniaList() throws Exception {
        return maniaRepository.mbList();
    }

    @Override
    public void maniaRegister(ItemManiaBoard board) throws Exception {
        maniaRepository.itemInsert(board);
    }

    @Override
    public void removeFromServ(Integer custNo) throws Exception {
        maniaRepository.removeFromRepo(custNo);
    }

    @Override
    public ItemManiaBoard readFromServ(Integer custNo) throws Exception {
        return maniaRepository.readFromRepo(custNo);
    }

    @Override
    public void modifyFromServ(ItemManiaBoard board) throws Exception {
        maniaRepository.modifyFromRepo(board);
    }
}
