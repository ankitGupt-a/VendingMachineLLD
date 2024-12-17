public class Inventory {
    ItemShelf[] inventory;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    private void initialEmptyInventory() {
        int startCode = 101;

        for (int i=0; i<inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("Item is already present, you cannot add item here");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception{
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode() == codeNumber) {
                return itemShelf.getItem();
            }
        }

        throw new Exception("Invalid Code Number");
    }

    public void updateSoldOutItem(int codeNubmer) {
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode() == codeNubmer) {
                itemShelf.setSoldOut(true);
            }
        }
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }
}
