package IT4.DoAn.Model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IT4.DoAn.Model.Model_Menu.MenuType getType() {
        return type;
    }

    public void setType(IT4.DoAn.Model.Model_Menu.MenuType type) {
        this.type = type;
    }

    public Model_Menu(String icon, String name, IT4.DoAn.Model.Model_Menu.MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Model_Menu() {
    }

    private String icon;
    private String name;
    private IT4.DoAn.Model.Model_Menu.MenuType type;

    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/IT4/DoAn/Icon/" + icon + ".png"));
    }
    
    
    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
