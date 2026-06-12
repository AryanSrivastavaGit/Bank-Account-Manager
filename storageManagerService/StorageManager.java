package storageManagerService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Account;
import model.CurrentAccount;
import model.SavingAccount;

public class StorageManager {
    private static final String dataFolder = "Accounts/";

    public static void createAccountsFolder(){
        File folder = new File(dataFolder);
        if(!folder.exists()){
            folder.mkdir();
            System.out.println("Accounts folder created at: " + folder.getAbsolutePath());
        }
    }

    public static void saveAccount(Account account){

        String fileName;
        if(account instanceof SavingAccount){
            SavingAccount s = (SavingAccount) account;
            fileName = s.getAccountNumber() + ".dat";
        }else{
            CurrentAccount s = (CurrentAccount) account;
            fileName = s.getAccountNumber() + ".dat";
        }

        try(
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        ){
            oos.writeObject(dataFolder+fileName);
            System.out.println("Saved " + fileName);

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Account loadAccount(String accountNumber){
        String fileName = accountNumber + ".dat";
        File file = new File(fileName);

        if(!file.exists()){
            System.out.println("Account not found.");
            return null;
        }

        try(
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))
        ){
            return (Account)ois.readObject();
        }catch(Exception e){
            System.out.println("Account not found.");
            return null;
        }
    }
}
