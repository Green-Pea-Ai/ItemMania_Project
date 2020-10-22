package com.example.wd.proj.service;

import com.example.wd.proj.entity.ItemManiaBoard;

import java.util.List;

// 인터페이스 부분
public interface ItemManiaService {

    // 아이템 리스트 보기
    public List<ItemManiaBoard> maniaList() throws Exception;
    // 아이템 등록
    public void maniaRegister(ItemManiaBoard board) throws Exception;
    // 아이템 삭제
    public void removeFromServ(Integer custNo) throws Exception;
    // 아이템 정보 읽기
    public ItemManiaBoard readFromServ(Integer custNo) throws Exception;
    // 아이템 정보 수정
    public void modifyFromServ(ItemManiaBoard board) throws Exception;
}
