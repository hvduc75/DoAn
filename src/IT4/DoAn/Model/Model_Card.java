package IT4.DoAn.Model;

import javax.swing.Icon;

public class Model_Card {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return values;
    }

    public void setValue(String value) {
        this.values = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public Model_Card(Icon icon, String title, String values, String description, String title1) {
        this.icon = icon;
        this.title = title;
        this.values = values;
        this.description = description;
        this.title1 = title1;
    }

    public Model_Card() {
    }
    private Icon icon;
    private String title;
    private String values;
    private String description;
    private String title1;
}
