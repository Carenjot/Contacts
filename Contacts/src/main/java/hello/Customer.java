package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private Integer age;

    protected Customer() {}

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', lastName='%s']",
                id, name, lastName);
    }
    
  

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public Long getId() {
    	return id;
    }
    
	public PersonForm getPersonForm() {
		PersonForm c = new PersonForm();
		
		c.setName(name);
		c.setAge(age);
		c.setId(id);			
		return c;
	}

}