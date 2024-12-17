import java.util.List;

public interface VendingMachineState {
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;

    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;

    public void clickOnSelectProductButton(VendingMachine machine) throws Exception;

    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception;

    public int getChange(int returnChangeMoney) throws Exception;

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception;

    public List<Coin> refundMoney(VendingMachine machine) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;


}
