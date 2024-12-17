import java.util.ArrayList;
import java.util.List;

public class IdleState implements VendingMachineState{

    public IdleState() {
        System.out.println("Currently machine is in Idle State");
    }

    public void clickOnInsertCoinButton(VendingMachine machine) {
        machine.setVendingMachineState(new HasMoneyState());
    }

    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("First click on the insert coin button");
    }

    public void clickOnSelectProductButton(VendingMachine machine) throws Exception{
        throw new Exception("First click on the insert coin button");
    }

    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("First click on the insert coin button");
    }

    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("No money have been inserted yet");
    }

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("No money have been inserted yet");
    }

    public List<Coin> refundMoney(VendingMachine machine) throws Exception {
        throw new Exception("No money have been inserted yet");
    }

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item, codeNumber);
    }
 }
