import java.util.List;

public class HasMoneyState implements VendingMachineState {

    public HasMoneyState () {
        System.out.println("Currently machine is in the hasMoney state");
    }

    public void clickOnInsertCoinButton(VendingMachine machine) {
        return;
    }

    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("Accepting the coin");
        machine.getCoinList().add(coin);
    }

    public void clickOnSelectProductButton(VendingMachine machine) {
        machine.setVendingMachineState(new SelectProductState());
    }

    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You first need to click on the select product button");
    }

    public int getChange(int returnChangeMoney) throws Exception{
        throw  new Exception("Select cancel button to get your money because you haven't selected any product");
    }

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception{
        throw new Exception("you first need to click on the select product button");
    }

    public List<Coin> refundMoney(VendingMachine machine) {
        System.out.println("Return all the money inserted by user");
        machine.setVendingMachineState(new IdleState());
        return machine.getCoinList();
    }

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("You cannot update inventory in the hasMoney state");
    }
}
