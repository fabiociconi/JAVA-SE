/*******************************************************************************
 * Lab - Patient provide ID, First Name, Last Name, Address, City, Province,   *
 * and Postal Code -  Program return Patient info formatted                    *
 *-----------------------------------------------------------------------------*
 * Date = 01/23/2017     +   LAB #1 - ex 1           + @author: Fabio Ciconi   *
 ******************************************************************************/
package exercise1;

public class Patient 
{
    private String lastName;//Patient Last Name 
    private int id; //Identification's Patient
    private String firstName;//Patient First Name 
    private String addressName;//Patient Addres
    private String provinceName;//Patient Province
    private String cityName; //Patient City
    private String postalCode;//Patient Postal Code
    
    // Default Constructor
    // Only dsyplay to Show that I am use it.
    public Patient()
    {
        System.out.println("Default Constructor");
    };
    
    // Multiple Argument Constructor 
    /* @param aux_id - Identification's Patient
     * @param aux_f_name - Patient First Name 
     * @param aux_l_name - Patient Last Name 
     * @param aux_address - Patient Address 
     * @param aux_city - Patient Cit
     * @param aux_province -Patient Province
     * @param aux_postal - Patient Postal Code 
     */
    Patient(int aux_id, String aux_f_name, String aux_l_name, String aux_address, 
            String aux_city, String aux_province, String aux_postal )
    {
	id              = aux_id;
	firstName       = aux_f_name;
	lastName        = aux_l_name;
	addressName     = aux_address;
	cityName        = aux_city;
	provinceName    = aux_province;
	postalCode      = aux_postal; 
    }
    
    //* Fomart the pacient information
    public String getPatientinfo()
    {
    	String info =String.format("Patient Information: %n"
                                   + "ID: %d%n"
                                   + "First Name: %s%n"
                                   + "Last Name: %s%n"
                                   + "Address : %s%n"
                                   + "City : %s%n"
                                   + "Province: %s%n "
                                   + "Postal Code: %s%n",
                id, firstName, lastName, addressName, cityName, 
                provinceName, postalCode);
    	return info;
    }
}
