package com.example.claireroop.donatiun_2340.Model;

import java.util.LinkedList;

public class AccountList {

    private LinkedList<Account> userList;
    public AccountList(){
        userList = new LinkedList<Account>();
    }

    /** Get User from list
     * @param email - Email : No User should have the same Email
     * @return if (Account found) - return Account : else return null
     */
    public Account getUser(String email){

        for(int i = 0; i <= this.userList.size(); i++){
            Account account = this.userList.get(i);
            if(account.get_email() == email){
                return account;
            }
        }
        return null;
    }

    /** Check for User in list
     * @param email - User account email
     * @return boolean - TRUE is user exists : FALSE if user does not exist
     */
    public boolean checkListForUser(String email){
        for (Account user : userList) {

            String userEmail = user.get_email();
            if(userEmail.equals(email)){
                return true;
            }

        }
        return false;
    }

    /** Creates New User - New Acount Defaults to USER Role
     * @param email
     * @param password
     * @return boolean - TRUE if user added : FALSE if userName already exists
     */
    public boolean createNewUser(String email, String password, String name){
        if(checkListForUser(email) == false){
            Account user = new Account(email, password, name, Role.USER);
            addUser(user);
            return true;
        }
        else{
            return false;
        }
    }

    /** Adds user to list
     * @param user
     */
    private void addUser(Account user){
        this.userList.add(user);
    }

    public boolean compareAccountToPassword(String email, String password){
        Account account = getUserObjectByEmail(email);
        if(account != null && account.get_password().matches(password)) return true;
        else return false;
    }

    private Account getUserObjectByEmail(String email){
        for(Account account : userList){
            if(account.get_email().matches(email)) return account;
        }
        return null;
    }


}