package sg.edu.np.notes;

public class UserData
{
    private String Username;
    private String Password;

    public UserData() {}

    public UserData(String username, String password)
    {
        Username = username;
        Password = password;
    }

    public String getUsername()
    {
        return Username;
    }

    public void setUsername(String username)
    {
        Username = username;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String password)
    {
        Password = password;
    }
}
