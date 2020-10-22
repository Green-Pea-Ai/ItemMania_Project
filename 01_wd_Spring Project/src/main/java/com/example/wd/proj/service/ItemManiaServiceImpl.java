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

    // 아이템 리스트 보기
    @Override
    public List<ItemManiaBoard> maniaList() throws Exception {
        return maniaRepository.mbList();
    }
    // 아이템 등록
    @Override
    public void maniaRegister(ItemManiaBoard board) throws Exception {
        maniaRepository.itemInsert(board);
    }
    // 아이템 삭제
    @Override
    public void removeFromServ(Integer custNo) throws Exception {
        maniaRepository.removeFromRepo(custNo);
    }
    // 아이템 정보 보기
    @Override
    public ItemManiaBoard readFromServ(Integer custNo) throws Exception {
        return maniaRepository.readFromRepo(custNo);
    }
    // 아이템 정보 수정
    @Override
    public void modifyFromServ(ItemManiaBoard board) throws Exception {
        maniaRepository.modifyFromRepo(board);
    }
}
