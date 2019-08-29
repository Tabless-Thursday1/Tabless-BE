package com.tabless.services;

import com.tabless.models.Tab;

import java.util.List;

public interface TabService {


    Tab addTabToUser(String username, Tab tab);

    Tab modifyTabByIds(long id, Tab tab);

    void deleteTab(long id);

}
