package by.htp.bean;

public class User {
    private String name;
    private String surname;
	private String login;
	private String password;
    private String readBook;
	private String imageAdres;
	private String role;
	private int editId;
	

	public User() {
		super();
		//this.role = "unknown";
	}
	
	public User(String login, String password, String role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	
	
	
	public User(String name, String surname, String login, String password, String imageAdres)
    {
        super();
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.imageAdres = imageAdres;
    }
   public String getReadBook()
    {
        return readBook;
    }

    public void setReadBook(String readBook)
    {
        this.readBook = readBook;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getImageAdres()
    {
        return imageAdres;
    }

    public void setImageAdres(String imageAdres)
    {
        this.imageAdres = imageAdres;
    }

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getEditId() {
		return editId;
	}

	public void setEditId(int editId) {
		this.editId = editId;
	}
	
	
}
