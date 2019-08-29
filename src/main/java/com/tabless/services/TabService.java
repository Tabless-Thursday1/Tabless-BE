package com.tabless.services;

import com.tabless.models.Tab;

import java.util.List;

public interface TabService {


    Tab addTabToUser(long id, Tab tab);

    Tab modifyTabById(long id, Tab tab);

    void deleteTab(long id);

}
