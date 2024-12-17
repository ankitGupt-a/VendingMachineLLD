import java.util.List;

public class DispenseState implements VendingMachineState {

    public DispenseState(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Currently in the DispenseState");
        dispenseProduct(machine, codeNumber);
    }

    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("You cannot click insert coin button because machine is in product dispense state");
    }

    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in the product dispense state");
    }

    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        throw new Exception("You cannot select the product in the product dispense state");
    }

    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You cannot select product in the product dispense state");
    }

    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Change cannot be returned in the dispense state");
    }

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Dispensing the product");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState());
        return item;
    }

    public List<Coin> refundMoney(VendingMachine machine) throws Exception {
        throw new Exception("Money cannot be returned in the product dispense state");
    }

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory cannot be updated in the product dispense state");
    }
}
