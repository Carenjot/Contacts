package hello;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {
	
	
	private Long id;
	
    @NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

    public void setId(Long id) {
    	this.id = id;
    }
    
    public Long getId() {
    	return id;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }

	public Customer getPerson() {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		
		c.setName(name);
		c.setAge(age);
		c.setId(id);			
		return c;
	}
}