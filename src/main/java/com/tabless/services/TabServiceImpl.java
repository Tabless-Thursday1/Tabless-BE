package com.tabless.services;

import com.tabless.models.Tab;
import com.tabless.models.User;
import com.tabless.repository.TabRepository;
import com.tabless.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "tabService")
public class TabServiceImpl implements TabService {

    @Autowired
    private TabRepository tabrepos;

    @Autowired
    private UserRepository userrepos;

    public Tab addTabToUser(long id, Tab tab){
        User user = userrepos.findById(id);
        Tab newTab = new Tab();

        newTab.setTabname(tab.getTabname());
        newTab.setTabdesc(tab.getTabdesc());
        newTab.setTaburl(tab.getTaburl());
        newTab.setUser(user);
        newTab.setTabprivate(false);
        if(tab.getTabcat() != null){
            newTab.setTabcat(tab.getTabcat());
        }else{
            newTab.setTabcat("None");
        }

        return tabrepos.save(newTab);
    }

    public Tab modifyTabById(long id, Tab tab){
        Tab currentTab = tabrepos.findById(id);

        if (currentTab != null){
            if (id == currentTab.getTabid()){
                if(tab.getTabname() != null){
                    currentTab.setTabname(tab.getTabname());
                }
                if(tab.getTabdesc() != null){
                    currentTab.setTabdesc(tab.getTabdesc());
                }
                if(tab.getTaburl() != null){
                    currentTab.setTaburl(tab.getTaburl());
                }
                if(tab.getTabcat() != null){
                    currentTab.setTabcat(tab.getTabcat());
                }
                if(tab.isTabprivate() != currentTab.isTabprivate()){
                    currentTab.setTabprivate(tab.isTabprivate());
                }
            }
        }

        return tabrepos.save(currentTab);
    }

    public void deleteTab(long id){
        Tab tabToDelete = tabrepos.findById(id);

        tabrepos.delete(tabToDelete);
    }
}
