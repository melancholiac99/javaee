package com.sbjv.sportplay.Dao;

import com.sbjv.sportplay.bean.MainMenu;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
   public List<MainMenu> getMenus();
}
