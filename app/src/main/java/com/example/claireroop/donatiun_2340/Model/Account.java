public class Account {



    private String _username;
    private String _password;
    private Role _role;
    private String _firstName;
    private String _lastName;
    private String _email;


    public Account(String u, String p, Role r, String f, String l, String e){
        _username = u;
        _password = p;
        _role = r;
        _firstName = f;
        _lastName = l;
        _email = e;
    }
    public Account(String u, String p, Role r) {
        this(u,p,r,null,null,null);
    }

    //utilities
    public boolean isAdmin() {
        return _role == Role.ADMIN;
    }
    public boolean isUser() {
        return _role == Role.USER;
    }
    public boolean usernameEquals(String u) {
        return u.equals(_username);
    }
    public boolean passwordEquals(String p) {
        return p.equals(_password);
    }
    public void makeAdmin() {
        set_role(Role.ADMIN);
    }
    public void makeUser() {
        set_role(Role.USER);
    }

    //getters:
    public String get_username() {
        return _username;
    }
    public String get_password() {
        return _password;
    }
    public Role get_role(){
        return _role;
    }
    public String get_firstName() {
        return _firstName;
    }
    public String get_lastName() {
        return _lastName;
    }
    public String get_email() {
        return _email;
    }

    //setters:
    public void set_username(String u) {
        _username = u;
    }
    public void set_password(String p) {
        _password = p;
    }
    public void set_role(Role r) {
        _role = r;
    }
    public void set_firstName(String f) {
        _firstName = f;
    }
    public void set_lastName(String l) {
        _lastName = l;
    }
    public void set_email(String e) {
        _email = e;
    }

}
