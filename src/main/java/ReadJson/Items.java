package ReadJson;

import java.util.List;

/**
 * JSON中的bean类
 *
 * @author mezereon E-mail:mezereonxp@gmail.com
 * @since 18-4-12
 */

public class Items {
    public List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
