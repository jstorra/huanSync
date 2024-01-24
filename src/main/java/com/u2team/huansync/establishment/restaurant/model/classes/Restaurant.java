package com.u2team.huansync.establishment.restaurant.model.classes;

import com.u2team.huansync.establishment.model.classes.Establishment;
import com.u2team.huansync.establishment.model.classes.builder.CategoryEstablishment;
import com.u2team.huansync.establishment.restaurant.itemMenu.model.classes.ItemMenu;
import java.util.List;

/**
 * 
 * @author dfrincong
 */
public class Restaurant extends Establishment
{    /**
     * 
     */
    private List<ItemMenu> listItemMenu;

    public Restaurant() {
    }

    public Restaurant(List<ItemMenu> listItemMenu, long establishmentId, String nameEstablishment, long managerEstablishment, CategoryEstablishment categoyEstablisment, long establishmentEventId) {
        super(establishmentId, nameEstablishment, managerEstablishment, categoyEstablisment, establishmentEventId);
        this.listItemMenu = listItemMenu;
    }

    public List<ItemMenu> getListItemMenu() {
        return listItemMenu;
    }

    public void setListItemMenu(List<ItemMenu> listItemMenu) {
        this.listItemMenu = listItemMenu;
    }


}
