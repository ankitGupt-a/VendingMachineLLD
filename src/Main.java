
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        try {
            System.out.println("|");
            System.out.println("Filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("Click on the insert Coin button");
            System.out.println("|");

            VendingMachineState vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.clickOnInsertCoinButton(vendingMachine);

            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.insertCoin(vendingMachine, Coin.TEN);
            vendingMachineState.insertCoin(vendingMachine, Coin.FIVE);

            System.out.println("|");
            System.out.println("Click on the Product Selection Button");
            System.out.println("|");
            vendingMachineState.clickOnSelectProductButton(vendingMachine);

            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.selectProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        } catch (Exception e) {
            displayInventory(vendingMachine);
        }
    }


    public static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();

        for (int i=0; i<slots.length; i++) {
            Item item = new Item();
            if (i<3) {
                item.setItemType(ItemType.COKE);
                item.setPrice(12);
            } else if (i<5) {
                item.setItemType(ItemType.JUICE);
                item.setPrice(10);
            } else if (i<7) {
                item.setItemType(ItemType.SODA);
                item.setPrice(11);
            } else {
                item.setItemType(ItemType.PEPSI);
                item.setPrice(13);
            }

            slots[i].setItem(item);
            slots[i].setSoldOut(false);
        }
    }

    public static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();

        for (ItemShelf slot: slots) {
            System.out.println("CodeNumber: " + slot.getCode() + " Item: " + slot.getItem().getItemType().name() +
                    " Price: " + slot.getItem().getPrice() + " IsAvailable: " + !slot.isSoldOut());
        }
    }
}