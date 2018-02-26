package newpackage;

public class Patient {
	
	private String lastName;
	private int id;
	private String firstName;
	private String addressName;
	private String provinceName;
	private String cityName;
	private String postalCode;
	Patient()
	{
		
	}

	Patient(int sid, String fname, String lname, String address, String city, String province, String postal )
	{
		id              = sid;
		firstName        = fname;
		lastName        = lname;
		addressName     = address;
		cityName        = city;
		provinceName    = province;
		postalCode      = postal; 
	}
	
	public void setid(int sid)
	{
		id = sid;
	}
    public int getid()
    {
    	return id;
    }
    //* First name
    public void setfirtName(String fname)
    {
    	fname=firstName;
    }
    public String getsfirtName()
    {
    	return firstName;
    }
   
    //* Last name 
    public void setlastName(String lname)
    {
    	lname=lastName;
    }
    public String getslastName()
    {
    	return lastName;
    }
  //* addressName
    public void setaddressName(String address)
    {
    	address=addressName;
    }
    public String getsaddressName()
    {
    	return addressName;
    }
    //*city name
    public void setcityName(String city)
    {
    	city=cityName;
    }
    public String getcityName()
    {
    	return cityName;
    }
    // Province name
    public void setprovinceName(String province)
    {
    	provinceName=province;
    }
    public String provinceName()
    {
    	return provinceName;
    }
        
    //*postalCode
    public void setpostalCode(String postal)
    {
    	postalCode=postal;
    }
    public String getpostalCode()
    {
    	return postalCode;
    }

    public String getPatientinfo()
    {
    	String info =String.format("Patient Information:%n id:%d%n firstName:%s%n,"
    			                + "lastName:%s%n addressName:%s%n cityName:%s%n, "
    			                + "provinceName:%s%n postalCode:%s%n", id, firstName, lastName, addressName, cityName, cityName,provinceName, postalCode);
    	return info;
    }
}
