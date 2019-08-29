package com.tabless.services;

import com.tabless.models.Tab;
import com.tabless.models.User;
import com.tabless.repository.TabRepository;
import com.tabless.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "tabService")
public class TabServiceImpl implements TabService {

    @Autowired
    private TabRepository tabrepos;

    @Autowired
    private UserRepository userrepos;

    public Tab addTabToUser(String username, Tab tab){
        User user = userrepos.findByUsername(username);
        Tab newTab = new Tab();

        newTab.setTabname(tab.getTabname());
        newTab.setTabdesc(tab.getTabdesc());
        newTab.setTaburl(tab.getTabdesc());
        newTab.setUser(user);
        newTab.setTabprivate(false);
        if(tab.getTabcat() != null){
            newTab.setTabcat(tab.getTabcat());
        }else{
            newTab.setTabcat("None");
        }

        return tabrepos.save(newTab);
    }
}
