import java.util.List;

public class SelectProductState implements VendingMachineState {

    public SelectProductState() {
        System.out.println("Currently in the Select Product state");
    }

    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception{
        throw new Exception("You must not select the insert coin button in the selection state");
    }

    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in the selection state");
    }

    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        throw new Exception("Select the product");
    }

    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
        Item item = machine.getInventory().getItem(codeNumber);

        int paidByUser = 0;

        for (Coin coin: machine.getCoinList()) {
            paidByUser += coin.value;
        }

        if (paidByUser < item.getPrice()) {
            System.out.println("Insufficient money, user have insert the less money");
            refundMoney(machine);
            throw new Exception("Insufficient money");
        } else {
            if (paidByUser > item.getPrice()) {
                getChange(paidByUser-item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }
    }

    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Money returned: " + returnChangeMoney);
        return returnChangeMoney;
    }

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Select product first");
    }

    public List<Coin> refundMoney(VendingMachine machine) throws Exception {
        System.out.println("Transaction is cancel, refunding the money");
        machine.setVendingMachineState(new IdleState());
        return machine.getCoinList();
    }

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory cannot be selected in the Selection state");
    }
}
